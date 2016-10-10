package com.feicui.administrator.httpdemo;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public abstract class UICallBack implements Callback{
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(final Call call, final IOException e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailureInUI(call, e);
            }
        });
    }

    @Override
    public void onResponse(final Call call, final Response response) throws IOException {
        handler.post(new Runnable() {
            @Override
            public void run() {
              onResponseInUI(call, response);
            }
        });
    }

    public abstract void onFailureInUI(Call call, IOException e);

    public abstract void onResponseInUI(Call call, Response response);
}
