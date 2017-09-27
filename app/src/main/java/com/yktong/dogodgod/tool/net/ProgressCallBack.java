package com.yktong.dogodgod.tool.net;

/**
 * Created by vampire on 2017/9/27.
 */

public interface ProgressCallBack<T> {
    void onProgress(long total, long current);

    void onSuccess(T response);

    void onFailed(String msg);
}
