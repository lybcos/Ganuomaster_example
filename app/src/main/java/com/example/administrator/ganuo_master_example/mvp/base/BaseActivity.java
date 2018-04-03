package com.example.administrator.ganuo_master_example.mvp.base;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.ganuo_master_example.MyApplication;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/16.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected Context mContext;
    private ConnectivityManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 锁定竖屏
        // setTheme(R.style.AnimationActivity);//设置切换动画
        mContext = getActivityContext();
        initView();
        ButterKnife.bind(this);
        initdata();
        MyApplication.getInstance().addActivity(this);
    }

    /**
     * 初始activity方法
     */
    private void initView() {
        loadViewLayout();
    }

    private void initdata() {
        findViewById();
        setListener();
        processLogic();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
//		StatService.onPause(mContext);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
//		StatService.onResume(mContext);
    }

    public void checkNetWork() {

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        MyApplication.getInstance().finishActivity(this);
    }

    /**
     * 加载页面layout
     */
    protected abstract void loadViewLayout();

    /**
     * 加载页面元素
     */
    protected abstract void findViewById();

    /**
     * 设置各种事件的监听器
     */
    protected abstract void setListener();

    /**
     * 业务逻辑处理，主要与后端交互
     */
    protected abstract void processLogic();


    /**
     * Activity.this
     */
    protected abstract Context getActivityContext();

    @Override
    public void onClick(View v) {

    }
}
