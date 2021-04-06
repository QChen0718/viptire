package com.example.notificationtest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notificationtest.R;
import com.example.notificationtest.adapter.MyPagerAdapter;
import com.example.notificationtest.fragment.ProductFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class ProductActivity extends BaseActivity {
    private String[] titles = {"全部","代付款","待发货","待收货","已完成"};
    private Toolbar toolbar;
    private SlidingTabLayout slidingTabLayout;
//    ViewPager 管理每一个fragment
    private ViewPager viewPager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_product;
    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.slidingTabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    protected void initData() {
        for (int i = 0;i<titles.length;i++){
            mFragments.add(ProductFragment.newInstance());
        }
//        缓存页面
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),titles,mFragments));
        slidingTabLayout.setViewPager(viewPager);
    }
}