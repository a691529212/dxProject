package com.yktong.dogodgod.tool.net;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vampire on 2017/9/27.
 */

public interface NetInterface {
    //常规请求 get/post
    <T> void startRequest(int type, String url, Class<T> tClass, OnHttpCallBack<T> callBack);

    //post json
    <T> void jsonRequest(String json, String url, Class<T> tClass, OnHttpCallBack<T> callBack);

    //uploadFiles
    <T> void uploadFiles(String url, ArrayList<String> fileNames, Class<T> tClass, ProgressCallBack<T> callBack);

    //downLoadFile
    <T> void downloadFile(String url, String fileDir,String[] fileNames, Class<T> tClass, ProgressCallBack<T> callBack);

    //form-data
    <T> void formDataRequest(String url, Map<String, List<File>> paramFile, Class<T> tClass, ProgressCallBack<T> callBack, HashMap<String, String>... params);

}
