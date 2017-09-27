package com.yktong.dogodgod.tool.net;

/**
 * Created by vampire on 2017/9/27.
 */

public interface OnHttpCallBack<T> {

    void onSuccess(T response);

    void onError(Throwable e);
}
