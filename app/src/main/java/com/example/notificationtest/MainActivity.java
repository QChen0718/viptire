package com.example.notificationtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.notificationtest.adapter.FruitAdapter;
import com.example.notificationtest.api.Api;
import com.example.notificationtest.api.ApiConfig;
import com.example.notificationtest.api.TtitCallback;
import com.example.notificationtest.common.AppGlobal;
import com.example.notificationtest.entity.BaseResponse;
import com.example.notificationtest.entity.HomeResponse;
import com.example.notificationtest.entity.HomeResultResponse;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FruitAdapter adapter;
    private List<HomeResultResponse> homeResultResponses= new ArrayList<>();
    private Handler handler;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FruitAdapter(homeResultResponses,this);
        recyclerView.setAdapter(adapter);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        loadData();

    }
    private void loadData(){
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("cityId","1");
        params.put("categoryCodes",new Object[0]);
        params.put("brandCodes",new Object[0]);
        params.put("commodityKeyword","");
        params.put("minPrice","");
        params.put("maxPrice","");
        params.put("isShort","0");
        params.put("shortName","createTime");
        params.put("modelId","");
        params.put("treadPattern",new Object[0]);
        params.put("speedLevel",new Object[0]);
        params.put("tireTread",new Object[0]);
        params.put("flatnessRatio",new Object[0]);
        params.put("diameter",new Object[0]);
        params.put("antiExplosionType","2");
        params.put("seasonType","2");
        params.put("loadIndex","");
        params.put("deviceNo","");
        params.put("page","1");
        params.put("pageSize","20");

        Api.config(ApiConfig.PRODUCT_LIST,params).postRequest(this, new TtitCallback() {
            @Override
            public void onSuccess(Object res) {
                Gson gson = new Gson();
                BaseResponse baseResponse = (BaseResponse) res;
                String json = gson.toJson(baseResponse.getData());
                Log.d("MainActivity",json);
                HomeResponse homeResponse = gson.fromJson(json,HomeResponse.class);
                homeResultResponses.addAll(homeResponse.getResult());
//                在UI线程中更新UI

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        if (progressBar.getVisibility() == View.GONE){
                            progressBar.setVisibility(View.VISIBLE);
                        }else {
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}