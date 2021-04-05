package com.example.notificationtest.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notificationtest.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends BaseFragment {


    public ProductFragment() {
        // Required empty public constructor
    }

    public static ProductFragment newInstance() {
        ProductFragment fragment = new ProductFragment();

        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_product;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}