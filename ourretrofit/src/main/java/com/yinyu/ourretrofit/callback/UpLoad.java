package com.yinyu.ourretrofit.callback;

import com.yinyu.ourretrofit.util.LogUtil;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * @author yy
 * @time 2017/2/24 10:31
 * @desc ${TODO}
 */

public abstract class UpLoad {

    public abstract void onResponse(Call<ResponseBody> call, Response<ResponseBody> response);

    public abstract void onProgress(long progress, long total, boolean done);

    public void onFailure(Call<ResponseBody> call, Throwable t) {
        LogUtil.e(t);
    }

}
