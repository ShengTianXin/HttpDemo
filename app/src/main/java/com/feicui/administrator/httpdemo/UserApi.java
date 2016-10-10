package com.feicui.administrator.httpdemo;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public interface UserApi {
    Call register(User user);
    Call getData();
}
