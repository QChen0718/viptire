package com.example.notificationtest.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.notificationtest.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public abstract class BaseFragment extends Fragment {

    protected View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mRootView == null){
            mRootView = inflater.inflate(initLayout(),container,false);
            initView();
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract int initLayout();
    protected abstract void initView();
    protected abstract void initData();

    public void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
    public void showToastSync(String msg){
        Looper.prepare();
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
        Looper.loop();
    }
}