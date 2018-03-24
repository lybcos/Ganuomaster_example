package com.example.administrator.ganuo_master_example.mvp.huaban.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/10.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mlist = new ArrayList<>();
    private String[]mTitle;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> mlist, String[] mTitle) {
        super(fm);
        this.mlist = mlist;
        this.mTitle = mTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
