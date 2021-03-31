package com.example.notificationtest;

import android.view.View;
import android.widget.Button;

import com.example.notificationtest.activity.BaseActivity;
import com.example.notificationtest.activity.HomeActivity;
import com.example.notificationtest.activity.LoginActivity;
import com.example.notificationtest.common.AppGlobal;
import com.example.notificationtest.util.StringUtils;


public class MainActivity extends BaseActivity {

    private AppGlobal appGlobal;
    private Button loginBtn;
    private Button registerBtn;
    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        loginBtn = (Button) findViewById(R.id.btn_login);
        registerBtn = (Button) findViewById(R.id.btn_register);
        appGlobal = new AppGlobal(this);
    }

    @Override
    protected void initData() {
        if (!StringUtils.isEmpty(appGlobal.getToken())) {
            navigateTo(HomeActivity.class);
            finish();
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(LoginActivity.class);
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}