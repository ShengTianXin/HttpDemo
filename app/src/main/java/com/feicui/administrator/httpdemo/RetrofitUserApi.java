package com.feicui.administrator.httpdemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public interface RetrofitUserApi {

    @GET("https://api.github.com/users/gqq")
    Call<ResponseBody> getData();

    /**
     * post请求需要添加GSON转换器吗，加依赖
     */
    @POST("/Handler/UserHandler.ashx?action=register")
    Call<ResponseBody> useRegister(@Body User user);
}
