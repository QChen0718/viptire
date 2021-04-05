package com.example.notificationtest.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notificationtest.R;
import com.example.notificationtest.adapter.ShoppingAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShoppingCarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingCarFragment extends BaseFragment {

    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShoppingCarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ShoppingCarFragment.
     */
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
        ShoppingAdapter shoppingAdapter = new ShoppingAdapter();
        recyclerView.setAdapter(shoppingAdapter);
    }

    @Override
    protected void initData() {

    }
}