package com.example.notificationtest.activity;


import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.notificationtest.R;
import com.example.notificationtest.adapter.MyPagerAdapter;
import com.example.notificationtest.entity.TabEntity;
import com.example.notificationtest.fragment.HomeFragment;
import com.example.notificationtest.fragment.MyFragment;
import com.example.notificationtest.fragment.ShoppingCarFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity{
    private String[] mTitles = {"首页","购物车","我"};
    private int[] mIconUnselectIds = {
            R.mipmap.icon_home,R.mipmap.icon_shop_car,R.mipmap.icon_me
    };
    private int[] mIconSelectIds = {
            R.mipmap.icon_home_select,R.mipmap.icon_shop_car_select,R.mipmap.icon_me_select
    };
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ViewPager viewPager;
    private CommonTabLayout commonTabLayout;
    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.viewpager);
        commonTabLayout = findViewById(R.id.commonTabLayout);
    }

    @Override
    protected void initData() {
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(ShoppingCarFragment.newInstance());
        mFragments.add(MyFragment.newInstance());
        for (int i = 0;i<mTitles.length;i++){
            mTabEntities.add(new TabEntity(mTitles[i],mIconSelectIds[i],mIconUnselectIds[i]));
        }
        commonTabLayout.setTabData(mTabEntities);
//        TabBar点击监听
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
//                选中
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
//                未选中
            }
        });
//        设置页数
        viewPager.setOffscreenPageLimit(mFragments.size());
//        页面滑动的监听方法
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mTitles,mFragments));
    }
}
