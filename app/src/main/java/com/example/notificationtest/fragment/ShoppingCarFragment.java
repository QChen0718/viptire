package com.example.notificationtest.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notificationtest.R;
import com.example.notificationtest.adapter.ShoppingAdapter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShoppingCarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingCarFragment extends BaseFragment {

    RecyclerView recyclerView;
    RefreshLayout refreshLayout;
    public ShoppingCarFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ShoppingCarFragment newInstance() {
        ShoppingCarFragment fragment = new ShoppingCarFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_shopping_car;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.shopping_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        ShoppingAdapter shoppingAdapter = new ShoppingAdapter(getContext());
        recyclerView.setAdapter(shoppingAdapter);
        refreshLayout = (RefreshLayout) mRootView.findViewById(R.id.refreshLayout);
//        刷新回调方法
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(true);
            }
        });
//        加载回调方法
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(true);
            }
        });
    }

    @Override
    protected void initData() {

    }
}