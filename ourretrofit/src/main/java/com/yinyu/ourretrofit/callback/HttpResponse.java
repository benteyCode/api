package com.yinyu.ourretrofit.callback;

import com.yinyu.ourretrofit.util.LogUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * @author yy
 * @time 2017/2/24 10:23
 * @desc ${TODO}
 */

public abstract class HttpResponse<T> {
    public Type getType() {
        Type mySuperClass = getClazz().getGenericSuperclass();
        Type type = ((ParameterizedType) mySuperClass).getActualTypeArguments()[0];
        return type;
    }

    public Class getClazz() {
        return getClass();
    }

    public abstract void onResponse(T t, Headers headers);

    public void onFailure(Call<ResponseBody> call, Throwable e) {
        LogUtil.e(e);
    }
}
