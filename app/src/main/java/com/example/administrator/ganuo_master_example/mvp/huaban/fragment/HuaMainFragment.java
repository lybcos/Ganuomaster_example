package com.example.administrator.ganuo_master_example.mvp.huaban.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.ganuo_master_example.R;
import com.example.administrator.ganuo_master_example.common.Constant;
import com.example.administrator.ganuo_master_example.mvp.base.BaseFragment;
import com.example.administrator.ganuo_master_example.mvp.huaban.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/10.
 */

public class HuaMainFragment extends BaseFragment {
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager vp;
    private List<Fragment>mFragment;
    private final String[] mTitles = {"美图", "摄影","美食", "美女"};
    private final String[] mTitlesType = {"quotes", "photography","food_drink", "beauty"};
    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup contain) {
        return inflater.inflate(R.layout.activity_home,contain,false);
    }

    @Override
    public void initListener() {
        tabLayout = mView.findViewById(R.id.tabLayout);
        toolbar = mView.findViewById(R.id.toolbar);
        vp = mView.findViewById(R.id.vp);
    }

    @Override
    public void loadData() {
    toolbar.setTitle("花瓣");
    vp.setOffscreenPageLimit(4);
        mFragment = new ArrayList<>();
        for (String titleType : mTitlesType) {
            mFragment.add(HuaBanFragment.getInstance(titleType));
        }
    vp.setAdapter(new MyPagerAdapter(getChildFragmentManager(),mFragment,mTitles));
    tabLayout.setupWithViewPager(vp);
    }
}
