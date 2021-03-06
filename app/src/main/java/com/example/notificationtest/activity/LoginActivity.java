package com.example.notificationtest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.notificationtest.MainActivity;
import com.example.notificationtest.common.AppGlobal;
import com.example.notificationtest.entity.BaseResponse;
import com.example.notificationtest.entity.LoginResponse;
import com.google.gson.Gson;
import com.example.notificationtest.R;
import com.example.notificationtest.api.Api;
import com.example.notificationtest.api.ApiConfig;
import com.example.notificationtest.api.TtitCallback;
import com.example.notificationtest.util.StringUtils;
import com.google.gson.JsonElement;

import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends BaseActivity {

    private Button loginBtn;
    private EditText accountEdit;
    private EditText pwdEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = (Button) findViewById(R.id.login_btn);
        accountEdit = (EditText) findViewById(R.id.mobile_edit);
        accountEdit.setText("18721375555");
        pwdEdit = (EditText) findViewById(R.id.pwd_edit);
        pwdEdit.setText("123456");
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginClick();
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    private void loginClick(){
        String account = accountEdit.getText().toString().trim();
        String pwd = pwdEdit.getText().toString().trim();
        if (StringUtils.isEmpty(account)){
            showToast("?????????????????????");
        }
        if (StringUtils.isEmpty(pwd)){
            showToast("??????????????????");
        }
//        navigateTo(HomeActivity.class);
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("username",account);
        params.put("password",pwd);
        params.put("type",0);
        params.put("appId",10);
        Api.config(ApiConfig.LOGIN,params).postRequest(this, new TtitCallback() {
            @Override
            public void onSuccess(Object res) {
//                Log.e("onSuccess",res.toString());
                Gson gson = new Gson();
                BaseResponse baseResponse = (BaseResponse) res;
                String json = gson.toJson(baseResponse.getData());
                LoginResponse loginResponse =
                        gson.fromJson(json,LoginResponse.class);
                Log.d("----->",loginResponse.getUsername());
                Looper.prepare();
                AppGlobal appGlobal = new AppGlobal(LoginActivity.this);
                appGlobal.saveUserInfo(LoginActivity.this,loginResponse.getResult());
                showToast("????????????");
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                Looper.loop();
            }
            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}