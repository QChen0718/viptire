package com.example.notificationtest.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.notificationtest.R;
import com.example.notificationtest.adapter.FruitAdapter;
import com.example.notificationtest.api.Api;
import com.example.notificationtest.api.ApiConfig;
import com.example.notificationtest.api.TtitCallback;
import com.example.notificationtest.entity.BaseResponse;
import com.example.notificationtest.entity.HomeResponse;
import com.example.notificationtest.entity.HomeResultResponse;
import com.google.gson.Gson;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private FruitAdapter adapter;
    private List<HomeResultResponse> homeResultResponses= new ArrayList<>();
    private Handler handler;
    private ProgressBar progressBar;
    private RefreshLayout refreshLayout;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int pageSize;
    private int pageNum;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView)mRootView.findViewById(R.id.recycler_view);
        adapter = new FruitAdapter(homeResultResponses,getContext());
        progressBar = (ProgressBar)mRootView.findViewById(R.id.progress_bar);
        refreshLayout = (RefreshLayout)mRootView.findViewById(R.id.refreshLayout);
        pageSize = 20;
        pageNum = 1;
    }

    @Override
    protected void initData() {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
//        ????????????Item???????????????????????????????????? ??????head?????????footer?????????????????????
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (adapter.isHeaderView(position)?layoutManager.getSpanCount():1);
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
//        ??????????????????
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageNum = 1;
                loadData(true);
            }
        });
//        ??????????????????
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                pageNum ++ ;
                loadData(false);
            }
        });
        loadData(true);
    }
    private void loadData(Boolean isRefresh){
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
        params.put("page",pageNum);
        params.put("pageSize",pageSize);
        progressBar.setVisibility(View.VISIBLE);
        Api.config(ApiConfig.PRODUCT_LIST,params).postRequest(getContext(), new TtitCallback() {
            @Override
            public void onSuccess(Object res) {
                if (isRefresh){
                    refreshLayout.finishRefresh(true/*,false*/);//??????false??????????????????
                }else {
                    refreshLayout.finishLoadMore(true);
                }

                Gson gson = new Gson();
                BaseResponse baseResponse = (BaseResponse) res;
                if (baseResponse.getCode() == 0){
                    String json = gson.toJson(baseResponse.getData());
                    Log.d("MainActivity",json);
                    if (baseResponse.getData() != null){
                        HomeResponse homeResponse = gson.fromJson(json,HomeResponse.class);
                        if (isRefresh){
                            homeResultResponses.clear();
                            homeResultResponses.addAll(homeResponse.getResult());
                        }else {
                            homeResultResponses.addAll(homeResponse.getResult());
                        }
//                ???UI???????????????UI
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                                progressBar.setVisibility(View.GONE);
                            }
                        });
                    }
                }else {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                            progressBar.setVisibility(View.GONE);
                        }
                    });
                    showToastSync(baseResponse.getMsg());
                }
            }

            @Override
            public void onFailure(Exception e) {
                progressBar.setVisibility(View.GONE);
                if (isRefresh){
                    refreshLayout.finishRefresh(true/*,false*/);//??????false??????????????????
                }else {
                    refreshLayout.finishLoadMore(true);
                }
            }
        });
    }
}