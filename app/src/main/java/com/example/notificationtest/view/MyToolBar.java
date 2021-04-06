package com.example.notificationtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Toolbar;

public class MyToolBar extends Toolbar {
    public MyToolBar(Context context) {
        super(context);
    }

    public MyToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyToolBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setTitle(int resId) {
        super.setTitle(resId);

    }
}
