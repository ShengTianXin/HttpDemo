package com.feicui.administrator.httpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class SecondActivity extends AppCompatActivity {
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.et_Username)
    EditText etUsername;
    @BindView(R.id.et_Passrword)
    EditText etPassrword;
    @BindView(R.id.btn_Register)
    Button btnRegister;
    private String BASE_URL = "http://admin.syfeicuiedu.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_Register)
    public void onClick() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Gson gson = new Gson();
        User user = new User(etUsername.getText().toString(), etPassrword.getText().toString());
        String content = gson.toJson(user);

        RequestBody requestBody = RequestBody.create(null, content);

        Request request = new Request.Builder()
                .post(requestBody)
                .url(BASE_URL + "/Handler/UserHandler.ashx?action=register")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("---------", "error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("+++++++++++", "ok");
            }
        });
    }

}
//    @OnClick(R.id.button)
//    public void onClick() {
//        /**拦截器*/
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                /**添加拦截器*/
//                .addInterceptor(interceptor)
//                .build();
//        //等同于OkHttpClient.Builder的简写方式
//        //OkHttpClient okHttpClient = new OkHttpClient();
//        //okHttpClient.Builder builder = new OkHttpClient.Builder();
//        //builder.addInterceptor(interceptor)
//        //builder.build();
//        Request request = new Request.Builder()
//                .get()
//                .url("https://api.github.com/users/gqq")
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.i("-----------", "error");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.i("++++++++++++", "OK");
//            }
//        });


//        /**2.构建请求*/
//        HttpGet httpGet = new HttpGet();
//        httpGet.setURI(URI.create("http://www.baidu.com"));
//        httpGet.addHeader(new BasicHeader("x_name", "fc"));
//        httpGet.addHeader(new BasicHeader("hjkf", "hik"));
//        /**1.执行请求，得到相应*/
//        HttpClient httpClient = new DefaultHttpClient();
//        try {
//            HttpResponse httpResponse = httpClient.execute(httpGet);
//            /**3.处理响应*/
//            if (httpResponse.getStatusLine().getStatusCode() == 200) {
//                httpResponse.getHeaders("x_name");
//                httpResponse.getAllHeaders();
//                HttpEntity httpEntity = httpResponse.getEntity();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
