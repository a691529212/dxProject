package com.yktong.dogodgod.tool.net;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.yktong.dogodgod.tool.LogUtil;
import com.yktong.dogodgod.tool.ThreadPool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.framed.FrameReader;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/**
 * Created by vampire on 2017/9/27.
 */

public class OkHttpUtil implements NetInterface {
    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final int GET = 1;
    public static final int POST = 2;
    private OkHttpClient mClient;

    private Handler mHandler =
            new Handler(Looper.getMainLooper());
    private Gson mGson;

    public OkHttpUtil() {
        super();
        mGson = new Gson();
        File path = Environment.getExternalStorageDirectory();
        mClient = new OkHttpClient.Builder().
                cache(new Cache(path, 20 * 1024 * 1024))
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public <T> void startRequest(final int type, final String url, final Class<T> tClass, final OnHttpCallBack<T> callBack) {
        LogUtil.d("okHttpUtil", url);
        ThreadPool.thredP.execute(new Runnable() {
            @Override
            public void run() {
                final Request mRequest;
                FormBody.Builder builder = new FormBody.Builder();
                final RequestBody requestBody = builder.build();
                mRequest = new Request
                        .Builder().url(url.trim())
                        .post(requestBody)
                        .build();
                if (type == GET) {
                    mClient.newCall(mRequest).enqueue(new Callback() {
                        private Object result;

                        @Override
                        public void onFailure(Call call, final IOException e) {
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    callBack.onError(e);
                                    LogUtil.e("okHttpUtil", e.getMessage());
                                }
                            });
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String str = response.body().string().trim();
                            result = mGson.fromJson(str, tClass);
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    callBack.onSuccess((T) result);
                                }
                            });
                        }
                    });
                } else {
                    // post
                    mClient.newCall(mRequest).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, final IOException e) {
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    LogUtil.e("okHttpUtil", e.getMessage());
                                    callBack.onError(e);
                                }
                            });
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String str = response.body().string().trim();
                            final T result = mGson.fromJson(str, tClass);
                            LogUtil.d("okHttpUtil", str);
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    callBack.onSuccess(result);
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    @Override
    public <T> void jsonRequest(String json, String url, final Class<T> tClass, final OnHttpCallBack<T> callBack) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        mClient.newCall(request).enqueue(new Callback() {
            private Object result;

            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                        LogUtil.e("okHttpUtil", e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string().trim();
                LogUtil.d("okHttpUtil", str);
                result = mGson.fromJson(str, tClass);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess((T) result);
                    }
                });

            }
        });
    }

    @Override
    public <T> void uploadFiles(String url, ArrayList<String> fileNames, final Class<T> tClass, final ProgressCallBack<T> callBack) {
        LogUtil.d("okHttpUtil", url);
        MultipartBody.Builder mBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        for (int i = 0; i < fileNames.size(); i++) {
            File file = new File(fileNames.get(i));
            if (file.exists()) {
                mBody.addFormDataPart("file" + i, file.getName(), createProgressRequestBody(MediaType.parse("image/png"), file, callBack));
            }
        }
        RequestBody body = mBody.build();
        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = mClient.newBuilder().writeTimeout(30, TimeUnit.SECONDS)
                .build().newCall(request);
        call.enqueue(new Callback() {
            private Object result;

            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e("okHttpUtil", e.getMessage());
                callBack.onFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.isSuccessful()) {
                    String str = response.body().string().trim();
                    LogUtil.d("okHttpUtil", str);
                    result = mGson.fromJson(str, tClass);
                    callBack.onSuccess((T) result);
                } else {
                    callBack.onFailed("upLoad file fail");
                }
            }
        });

    }

    @Override
    public <T> void downloadFile(String url, String fileDir, String[] fileNames, Class<T> tClass, final ProgressCallBack<T> callBack) {
        File folder = new File(fileDir);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String fileName = null;
        if (fileNames != null && fileNames.length > 0) {
            fileName = fileNames[0];
        } else {
            fileName = url.substring(url.lastIndexOf("/") + 1);
        }
        final File file = new File(fileDir, fileName);
        if (file.exists()) {
            callBack.onSuccess((T) file);
            return;
        }
        Request request = new Request.Builder().url(url).build();
        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e("okHttpUtil", e.getMessage());
                callBack.onFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inputStream = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fileOutputStream = null;
                long length = response.body().contentLength();
                LogUtil.d("okHttpUtil", "totalLength : " + length);
                long current = 0;
                inputStream = response.body().byteStream();
                fileOutputStream = new FileOutputStream(file);
                while ((len = inputStream.read(buf)) != -1) {
                    current += len;
                    fileOutputStream.write(buf, 0, len);
                    LogUtil.d("okHttpUtil", "current : " + current);
                    callBack.onProgress(length, current);
                }
                fileOutputStream.flush();
                callBack.onSuccess((T) file);
            }
        });
    }

    @Override
    public <T> void formDataRequest(String url, Map<String, List<File>> paramFile, final Class<T> tClass, final ProgressCallBack<T> callBack, HashMap<String, String>... params) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        if (params != null && params.length > 0) {
            for (HashMap<String, String> param : params) {
                for (Map.Entry<String, String> stringStringEntry : param.entrySet()) {
                    builder.addFormDataPart(stringStringEntry.getKey(), stringStringEntry.getValue());
                }
            }
        }
        if (paramFile != null) {
            int i = 0;
            for (Map.Entry<String, List<File>> entry : paramFile.entrySet()) {
                for (File file : entry.getValue()) {
                    builder.addFormDataPart(entry.getKey() + i++, file.getName(), createProgressRequestBody(MEDIA_TYPE_MARKDOWN, file, callBack));
                }
            }
        }
        RequestBody body = builder.build();
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = mClient.newBuilder().writeTimeout(50, TimeUnit.SECONDS).build().newCall(request);
        call.enqueue(new Callback() {
            private Object result;

            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.d("okHttpUtil", e.getMessage());
                callBack.onFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    Log.e("okHttpUtil", "response ----->" + string);
                    String trim = response.body().string().trim();
                    result = mGson.fromJson(trim, tClass);
                    callBack.onSuccess((T) result);
                } else {
                    callBack.onFailed("上传失败");
                }
            }
        });
    }

    /**
     * 创建带进度的RequestBody
     *
     * @param contentType MediaType
     * @param file        准备上传的文件
     * @param callBack    回调
     * @param <T>
     * @return
     */
    private <T> RequestBody createProgressRequestBody(final MediaType contentType, final File file, final ProgressCallBack<T> callBack) {
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return contentType;
            }

            @Override
            public long contentLength() {
                return file.length();
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                Source source;
                try {
                    source = Okio.source(file);
                    Buffer buf = new Buffer();
                    long remaining = contentLength();
                    long current = 0;
                    for (long readCount; (readCount = source.read(buf, 2048)) != -1; ) {
                        sink.write(buf, readCount);
                        current += readCount;
                        LogUtil.e("okHttpUtil", "current------>" + current);
                        LogUtil.d("okHttpUtil", "remaining------>" + remaining);
                        progressCallBack(remaining, current, callBack);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private <T> void progressCallBack(final long total, final long current, final ProgressCallBack<T> callBack) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.onProgress(total, current);
                }
            }
        });
    }
}
