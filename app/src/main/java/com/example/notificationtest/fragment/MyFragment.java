package com.example.notificationtest.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.notificationtest.R;
import com.example.notificationtest.activity.ProductActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFragment extends BaseFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final String[] titles = {"待付款", "待发货", "待收货", "已完成", "全部订单"};
    private final int[] imageIds = {R.mipmap.icon_dfk,R.mipmap.icon_dfh,R.mipmap.icon_dsh,R.mipmap.icon_ywc,R.mipmap.icon_allorder};
    private List<ViewStub> viewStubs = new ArrayList<ViewStub>();
    private ViewStub viewStub;
    private ViewStub viewStub2;
    private ViewStub viewStub3;
    private ViewStub viewStub4;
    private ViewStub viewStub5;
    private View itemView;
    private ImageView imageView;
    private TextView textView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static  MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        viewStub = (ViewStub) mRootView.findViewById(R.id.item1);
        viewStub2 = (ViewStub) mRootView.findViewById(R.id.item2);
        viewStub3 = (ViewStub) mRootView.findViewById(R.id.item3);
        viewStub4 = (ViewStub) mRootView.findViewById(R.id.item4);
        viewStub5 = (ViewStub) mRootView.findViewById(R.id.item5);

        viewStubs.add(viewStub);
        viewStubs.add(viewStub2);
        viewStubs.add(viewStub3);
        viewStubs.add(viewStub4);
        viewStubs.add(viewStub5);
    }

    @Override
    protected void initData() {
        for (int i = 0;i<viewStubs.size();i++){
            itemView = (View) viewStubs.get(i).inflate();
            itemView.setTag(i);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("---->",view.getTag().toString());
                    navigateTo(ProductActivity.class);
                }
            });
            textView = (TextView) itemView.findViewById(R.id.item_text);
            textView.setText(titles[i]);
            imageView = (ImageView) itemView.findViewById(R.id.item_image);
            imageView.setImageResource(imageIds[i]);
        }
    }
}