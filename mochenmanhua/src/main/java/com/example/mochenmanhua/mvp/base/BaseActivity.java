package com.example.mochenmanhua.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/3/19.
 */

public abstract  class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initdata();
    }

    private void initdata() {
        findViewId();
        initListenter();
    }

    public abstract void initView();//添加布局
    public abstract void findViewId();//初始化
    public abstract void initListenter();//监听

}
