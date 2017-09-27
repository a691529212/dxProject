package com.yktong.dogodgod.tool.net;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.yktong.dogodgod.tool.LogUtil;
import com.yktong.dogodgod.tool.ThreadPool;

import java.io.File;
import java.io.IOException;
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
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.framed.FrameReader;

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
    public <T> void jsonRequest(String json, String url, Class<T> tClass, OnHttpCallBack<T> callBack) {

    }

    @Override
    public <T> void uploadFiles(String url, ArrayList<String> fileNames, Class<T> tClass, OnHttpCallBack<T> callBack) {

    }

    @Override
    public <T> void downloadFile(String url, String fileDir, Class<T> tClass, ProgressCallBack<T> callBack) {

    }

    @Override
    public <T> void formDataRequest(String url, Map<String, List<File>> paramFile, Class<T> tClass, OnHttpCallBack<T> callBack, HashMap<String, String>... params) {

    }
}
