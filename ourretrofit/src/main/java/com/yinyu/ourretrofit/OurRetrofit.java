package com.yinyu.ourretrofit;

import android.content.Context;

import com.yinyu.ourretrofit.callback.HttpResponse;
import com.yinyu.ourretrofit.callback.UpLoad;
import com.yinyu.ourretrofit.request.Request;
import com.yinyu.ourretrofit.request.RequestMethod;
import com.yinyu.ourretrofit.util.HttpUtil;
import com.yinyu.ourretrofit.util.LogUtil;

import retrofit2.Call;

/**
 * @author yy
 * @time 2017/2/24 10:52
 * @desc ${TODO}
 */

public class OurRetrofit {

    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    public static void setHttpCache(boolean cache){
        HttpUtil.setHttpCache(cache);
    }

    public static final void init(Context context, String httpBaseUrl) {
        mContext = context.getApplicationContext();
        HttpUtil.setBaseUrl(httpBaseUrl);
    }

    public static <T> Call getAsync(String apiUrl, final HttpResponse<T> httpResponse) {
        return HttpUtil.getAsync(apiUrl, null, null, httpResponse);
    }

    public static <T> Call postAsync(String apiUrl, HttpResponse<T> httpResponse) {
        return HttpUtil.postAsync(apiUrl, null, null, httpResponse);
    }

    /**
     * 发送http网络请求
     *
     * @param request
     * @param httpResponse
     * @param <T>
     * @return
     */
    public static <T> Call send(Request request, HttpResponse<T> httpResponse) {
        if (RequestMethod.GET.equals(request.getRequestMethod())) {
            return HttpUtil.getAsync(request.getApiUlr()
                    , request.getHeaderMap()
                    , request.getParamsMap()
                    , httpResponse);
        } else {
            return HttpUtil.postAsync(request.getApiUlr()
                    , request.getHeaderMap()
                    , request.getParamsMap()
                    , httpResponse);
        }
    }

    public static <T> Call upload(Request request, UpLoad uploadListener) {
        return HttpUtil.upload(request, uploadListener);
    }

    /**
     * @param apiUlr 格式：xxxx/xxxxx
     * @return
     */
    public static Request newRequest(String apiUlr, RequestMethod method) {
        return new Request(apiUlr, method);
    }

    /**
     * @param apiUlr 格式：xxxx/xxxxx
     * @return
     */
    public static Request newPostRequest(String apiUlr) {
        return new Request(apiUlr, RequestMethod.POST);
    }

    /**
     * @param uploadFileUrl 格式：http://xxxx/xxxxx
     * @return
     */
    public static Request newUploadRequest(String uploadFileUrl, RequestMethod method) {
        return new Request(uploadFileUrl, method);
    }

    /**
     * 默认是GET方式
     *
     * @param apiUlr 格式：xxxx/xxxxx
     * @return
     */
    public static Request newGetRequest(String apiUlr) {
        return new Request(apiUlr, RequestMethod.GET);
    }

    /**
     * 是否显示日志，默认不显示 true:显示
     *
     * @param isDebug
     */
    public static void setDebug(boolean isDebug) {
        LogUtil.isDebug = isDebug;
    }

}
