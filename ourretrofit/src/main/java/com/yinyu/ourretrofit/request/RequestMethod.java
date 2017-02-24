package com.yinyu.ourretrofit.request;

/**
 * @author yy
 * @time 2017/2/24 10:37
 * @desc ${TODO}
 */

public enum RequestMethod {

    GET("GET"),

    POST("POST");

    private final String value;

    RequestMethod(String value) {
        this.value = value;
    }
}
