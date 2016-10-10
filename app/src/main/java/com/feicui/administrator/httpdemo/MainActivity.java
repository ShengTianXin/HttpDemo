package com.feicui.administrator.httpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends Activity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.et_Username)
    EditText etUsername;
    @BindView(R.id.et_Passrword)
    EditText etPassrword;
    @BindView(R.id.btn_Register)
    Button btnRegister;
//    private String BASE_URL = "http://admin.syfeicuiedu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_Register)
    public void onClick() {
        User user = new User(etUsername.getText().toString(), etPassrword.getText().toString());
        NetPostClient.getInstance().register(user).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("---------", "error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("+++++++++++", "ok");
            }
        });
//        /**执行请求*/
//        NetPostClient.getInstance().getData().enqueue(new UICallBack() {
//            @Override
//            public void onFailureInUI(Call call, IOException e) {
//                Toast.makeText(MainActivity.this, "Response defeat", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onResponseInUI(Call call, Response response) {
//                Toast.makeText(MainActivity.this, "Response succeed", Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}



