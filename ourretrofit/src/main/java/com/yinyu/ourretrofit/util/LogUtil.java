package com.yinyu.ourretrofit.util;

import android.util.Log;

/**
 * @author yy
 * @time 2017/2/24 10:25
 * @desc ${TODO}
 */

public class LogUtil {

    public static boolean isDebug = false;
    private static final String TAG = "OUR_RETROFIT";

    public static void i(String tag, String message) {
        if (isDebug) {
            Log.i(tag, message);
        }
    }

    public static void i(String message) {
        i(TAG, message);
    }

    public static void e(String tag, String message) {
        if (isDebug) {
            Log.e(tag, message);
        }
    }

    public static void e(String message) {
        e(TAG, message);
    }

    public static void e(String tag, String message, Throwable e) {
        if (isDebug) {
            Log.e(tag, message, e);
        }
    }

    public static void e(String tag, Throwable e) {
        e(tag, "", e);
    }

    public static void e(Throwable e, String message) {
        e(TAG, message, e);
    }

    public static void e(Throwable e) {
        e(TAG, "", e);
    }

}
