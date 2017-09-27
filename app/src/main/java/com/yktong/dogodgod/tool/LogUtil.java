package com.yktong.dogodgod.tool;

import android.util.Log;

import com.yktong.dogodgod.BuildConfig;

/**
 * Created by vampire on 2017/9/27.
 */

public class LogUtil {
    public static void d(String param, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(param, msg);
        }
    }

    public static void e(String param, String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(param, msg);
        }
    }
}
