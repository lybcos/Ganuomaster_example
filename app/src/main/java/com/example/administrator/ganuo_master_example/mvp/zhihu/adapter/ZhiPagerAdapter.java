package com.example.administrator.ganuo_master_example.mvp.zhihu.adapter;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.administrator.ganuo_master_example.MyApplication;
import com.example.administrator.ganuo_master_example.R;
import com.example.administrator.ganuo_master_example.common.Constant;
import com.example.administrator.ganuo_master_example.mvp.zhihu.fragment.ZhiHuFragment;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;



/**
 * Created by liuyu1 on 2017/8/22.
 */

public class ZhiPagerAdapter extends FragmentStatePagerAdapter {

//    private String[]mString={"首页", "应用","游戏","专题", "推荐", "分类", "排行"};
    @SuppressLint("ResourceType")
    public ZhiPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Calendar dateToGet=Calendar.getInstance();
        dateToGet.add(Calendar.DAY_OF_YEAR,1-position);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyMMdd",Locale.CHINA);
        String date = dateFormat.format(dateToGet.getTime());
        ZhiHuFragment fra = ZhiHuFragment.getInstance(date, position);
        return fra;
    }

    @Override
    public int getCount() {
        return Constant.Num.PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Calendar calendar=Calendar.getInstance();//默认当前日期，获取一个Calendar对象
        calendar.add(Calendar.DAY_OF_YEAR,-position);


       return (position == 0 ? MyApplication.getInstance().getString(R.string.zhihu_daily_today) + " " : "")
               + DateFormat.getDateInstance().format(calendar.getTime());
    }
}
