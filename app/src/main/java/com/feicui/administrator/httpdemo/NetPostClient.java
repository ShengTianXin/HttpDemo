package com.feicui.administrator.httpdemo;

import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class NetPostClient implements UserApi {
    private static NetPostClient netPostClient;
    private final OkHttpClient OkHttpClient;
    private String BASE_URL = "http://admin.syfeicuiedu.com";
    private UserApi userApi;

    private NetPostClient() {
        /**进行请求及拦截*/
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    public static NetPostClient getInstance() {
        if (netPostClient == null) {
            netPostClient = new NetPostClient();
        }
        return netPostClient;
    }

    /**
     * 完成注册请求的构建
     */
    @Override
    public Call register(User user) {
        Gson gson = new Gson();
        String content = gson.toJson(user);
        /**设置请求体*/
        RequestBody requestBody = RequestBody.create(null, content);
        /**构建一个请求*/
        Request request = new Request.Builder()
                .post(requestBody)
                .url(BASE_URL + "/Handler/UserHandler.ashx?action=register")
                .build();
        return OkHttpClient.newCall(request);
    }

    @Override
    public Call getData() {
        /**构建一个请求*/
        Request request = new Request.Builder()
                .get()
                .url(BASE_URL + "/Handler/UserHandler.ashx?action=register")
                .build();
        return OkHttpClient.newCall(request);
    }
}
