# `retrofit-OurRetrofit`
### retrofit网络封装库，内部使用gson解析json

## 用法及注意事项
* 在project的build.gradle添加如下代码

	>allprojects {
     repositories {
         jcenter()
         maven { url "https://jitpack.io" }
     }
	 }

* 在build.gradle添加依赖

	>compile 'com.github.yy941002:retrofit-OurRetrofit:v1.0.0'
	
* 需要的权限

	><uses-permission android:name="android.permission.INTERNET" />
	 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
	 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
	 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

## 全局配置

###初始化
OurRetrofit初始化需要二个参数Context、baseUrl，在Application的onCreate()中初始化，记 得在manifest.xml中注册Application。

    OurRetrofit.init(this, baseUrl);  //格式："http://xxxxxx/xxxxx/"

###设置是否缓存http响应数据（默认支持缓存）
    OurRetrofit.setHttpCache(false);//false不缓存，true缓存

###get/Post Bean类型异步请求（内部使用Gson解析json数据）
    //OurRetrofit.newPostRequest(apiUrl)
	Request request = OurRetrofit.newGetRequest(apiUrl);//apiUrl格式："xxx/xxxxx"
	Call call = OurRetrofit.send(request, new HttpResponse<Bean>() {
    @Override
    public void onResponse(Bean bean, Headers headers) {
        
    }
       /**
     	* 可以不重写失败回调
     	* @param call
     	* @param e
     	*/
    @Override
    public void onFailure(Call<ResponseBody> call, Throwable e) {
        
    }
	});

	//@param httpResponse 回调监听
	//@param <T> Http响应数据泛型String或者Bean(使用String可以自己解析数据)
	//@return Call可以取消网络请求

    Request request = OurRetrofit.newGetRequest(apiUrl);//apiUrl格式："xxx/xxxxx"
	Call call = OurRetrofit.send(request, new HttpResponser<String>() {
    @Override
    public void onResponse(String string, Headers headers) {
        
    }
       /**
    	* 可以不重写失败回调
     	* @param call
    	* @param e
    	*/
    @Override
    public void onFailure(Call<ResponseBody> call, Throwable e) {
        
    }
	});

	//@param httpResponse 回调监听
	//@param <T> Http响应数据泛型String或者Bean(使用String可以自己解析数据)
	//@return Call可以取消网络请求

###添加请求参数
    request.putParams(key,value)
	.putParams(key,value)
	.putParams(key,value);


	Map<String,Object> map = new HashMap<>();
	map.put(key,value);
	request.putParamsMap(map);

###添加请求头
    //添加请求头
	request.putHeader(key,value)
	.putHeader(key,value);

###取消网络请求
    call.cancel();

###是否需要查看日志
    OurRetrofit.setDebug(true);

>如果你觉得这个库还不错,请赏我一颗star吧~~~


[回到顶部](#readme)



