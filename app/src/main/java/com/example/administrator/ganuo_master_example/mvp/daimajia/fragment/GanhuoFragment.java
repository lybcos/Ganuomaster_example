package com.example.administrator.ganuo_master_example.mvp.daimajia.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.ganuo_master_example.R;
import com.example.administrator.ganuo_master_example.mvp.base.BaseFragment;
import com.example.administrator.ganuo_master_example.mvp.daimajia.activity.ReadActivity;
import com.example.administrator.ganuo_master_example.mvp.huaban.adapter.MyPagerAdapter;
import com.example.administrator.ganuo_master_example.mvp.huaban.fragment.HuaBanFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/2/16.
 */

public class GanhuoFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager vp;
    private ArrayList<Fragment> mFragments;
    private final String[] mTitles = {"首页", "干货", "妹纸"};
    private Toolbar toolbar;


    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup contain) {
        return inflater.inflate(R.layout.activity_home,contain,false);
    }

    @Override
    public void initListener() {
        tabLayout=mView.findViewById(R.id.tabLayout);
        toolbar = mView.findViewById(R.id.toolbar);
        vp = mView.findViewById(R.id.vp);
    }

    @Override
    public void loadData() {
        toolbar.setTitle("代码家");
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
        vp.setOffscreenPageLimit(3);
        mFragments = new ArrayList<>();
        for (String titleType : mTitles) {
            mFragments.add(DiscoveryFragment.getInstance(titleType));
        }
        vp.setAdapter(new MyPagerAdapter(getChildFragmentManager(),mFragments,mTitles));
        tabLayout.setupWithViewPager(vp);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick=new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_read:
                    Intent intent = new Intent(getActivity(), ReadActivity.class);
                    startActivity(intent);
                    break;
            }
            return true;
        }
    };
}
