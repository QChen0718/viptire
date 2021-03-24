package com.example.notificationtest.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Log;

import com.example.notificationtest.common.AppGlobal;
import com.example.notificationtest.entity.BaseResponse;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Api {
    private static OkHttpClient client;
    private static String requestUrl;
    private static HashMap<String,Object> mParams;
    public static Api api = new Api();
    public Api() {

    }
    public static Api config(String url,HashMap<String,Object> params) {
        client = new OkHttpClient.Builder().build();
        requestUrl = ApiConfig.BASE_URL + url;
        mParams = params;
        return api;
    }
    public void postRequest(Context context,final TtitCallback callback){
//        SharedPreferences sp = context.getSharedPreferences("")
        JSONObject jsonObject = new JSONObject(mParams);
        String jsonStr = jsonObject.toString();
        RequestBody requestBodyJson = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonStr);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                        .url(requestUrl)
                        .addHeader("contentType","application/json;charset=utf-8")
                        .addHeader("Authorization", AppGlobal.token)
                        .addHeader("token",AppGlobal.token)
                        .addHeader("appId","10")
                        .addHeader("platformId","2")
                        .addHeader("timestamp", String.valueOf(System.currentTimeMillis()))
                        .addHeader("sign","AE339A0261FCA705D24E5C5D0D663C05")
                        .post(requestBodyJson)
                        .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure",e.getMessage());
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                Gson gson = new Gson();
                BaseResponse baseResponse = gson.fromJson(result,BaseResponse.class);
                callback.onSuccess(baseResponse);
            }
        });
    }

    public void getRequest(Context context,final TtitCallback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                        .url(requestUrl)
                .addHeader("contentType","application/json;charset=utf-8")
                .addHeader("Authorization", AppGlobal.token)
                .addHeader("token",AppGlobal.token)
                .addHeader("appId","10")
                .addHeader("platformId","2")
                .addHeader("timestamp", String.valueOf(System.currentTimeMillis()))
                .addHeader("sign","AE339A0261FCA705D24E5C5D0D663C05")
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure",e.getMessage());
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                Gson gson = new Gson();
                BaseResponse baseResponse = gson.fromJson(result,BaseResponse.class);
                callback.onSuccess(baseResponse);
            }
        });
    }
}
