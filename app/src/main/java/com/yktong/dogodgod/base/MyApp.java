package com.yktong.dogodgod.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by vampire on 2017/9/27.
 */

public class MyApp extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext =this;
    }
}
