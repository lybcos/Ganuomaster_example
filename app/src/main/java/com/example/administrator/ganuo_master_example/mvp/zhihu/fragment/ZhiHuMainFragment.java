package com.example.administrator.ganuo_master_example.mvp.zhihu.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.administrator.ganuo_master_example.R;
import com.example.administrator.ganuo_master_example.common.Constant;
import com.example.administrator.ganuo_master_example.mvp.base.BaseFragment;
import com.example.administrator.ganuo_master_example.mvp.zhihu.adapter.ZhiPagerAdapter;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/16.
 */

public class ZhiHuMainFragment extends BaseFragment {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager vp;

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup contain) {
        mView=inflater.inflate(R.layout.activity_zhihu, contain,false);
        ButterKnife.bind(this, mView);
        return  mView;
    }

    @Override
    public void initListener() {
        toolbar=mView.findViewById(R.id.toolbar);
        tabLayout = mView.findViewById(R.id.tabLayout);
        vp=mView.findViewById(R.id.vp);

    }

    @Override
    public void loadData() {
        toolbar.setTitle("知乎日报");
        toolbar.inflateMenu(R.menu.menu_zhuhu);
        vp.setOffscreenPageLimit(Constant.Num.PAGE_COUNT);//表示几个界面来回切换，不会重新加载
        ZhiPagerAdapter adapter=new ZhiPagerAdapter(getChildFragmentManager());
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
