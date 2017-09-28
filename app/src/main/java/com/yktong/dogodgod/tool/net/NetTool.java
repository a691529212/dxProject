package com.yktong.dogodgod.tool.net;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;

/**
 * Created by vampire on 2017/9/28.
 */

public class NetTool extends OkHttpClient implements NetInterface {
    private static NetTool instance;
    private NetInterface mNetInterface;

    private NetTool() {
        mNetInterface = new OkHttpUtil();
    }

    public static NetTool getInstance() {
        if (instance == null) {
            synchronized (NetTool.class) {
                if (instance == null) {
                    instance = new NetTool();
                }
            }
        }
        return instance;
    }

    @Override
    public <T> void startRequest(int type, String url, Class<T> tClass, OnHttpCallBack<T> callBack) {
        mNetInterface.startRequest(type, url, tClass, callBack);
    }

    @Override
    public <T> void jsonRequest(String json, String url, Class<T> tClass, OnHttpCallBack<T> callBack) {
        mNetInterface.jsonRequest(json, url, tClass, callBack);
    }

    @Override
    public <T> void uploadFiles(String url, ArrayList<String> fileNames, Class<T> tClass, ProgressCallBack<T> callBack) {
        mNetInterface.uploadFiles(url, fileNames, tClass, callBack);
    }

    @Override
    public <T> void downloadFile(String url, String fileDir, String[] fileNames, Class<T> tClass, ProgressCallBack<T> callBack) {
        mNetInterface.downloadFile(url, fileDir, fileNames, tClass, callBack);
    }

    @Override
    public <T> void formDataRequest(String url, Map<String, List<File>> paramFile, Class<T> tClass, ProgressCallBack<T> callBack, HashMap<String, String>... params) {
        mNetInterface.formDataRequest(url, paramFile, tClass, callBack, params);
    }
}
