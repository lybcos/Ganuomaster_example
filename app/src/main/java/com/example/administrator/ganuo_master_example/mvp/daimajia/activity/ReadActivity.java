package com.example.administrator.ganuo_master_example.mvp.daimajia.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.ganuo_master_example.R;
import com.example.administrator.ganuo_master_example.mvp.base.BaseActivity;
import com.example.administrator.ganuo_master_example.mvp.daimajia.fragment.ReadFragment;
import com.example.administrator.ganuo_master_example.mvp.huaban.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

/**
 * Created by Administrator on 2018/3/10.
 */

public class ReadActivity extends BaseActivity {
    private CoordinatorTabLayout coordinatorTabLayout;
    private ViewPager vp;
    private int[] mImageArray, mColorArray;
    private List<Fragment> mFragments;
    private final String[] mTitles = {"Android", "iOS", "前端", "App","瞎推荐","拓展资源"};
    private int numToSetCurrentItem = 0;

    @Override
    protected void loadViewLayout() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
        ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_read);
        numToSetCurrentItem = getIntent().getIntExtra("numToSetCurrentItem", 0);
    }

    @Override
    protected void findViewById() {
        coordinatorTabLayout=findViewById(R.id.coordinatortablayout);
        vp = findViewById(R.id.vp);
    }

    @Override
    protected void setListener() {
        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            mFragments.add(ReadFragment.getInstance(title));
        }
        vp.setOffscreenPageLimit(4);
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mFragments,mTitles));
        mImageArray = new int[]{R.mipmap.bg_android,
                R.mipmap.bg_ios,
                R.mipmap.bg_js,
                R.mipmap.bg_js,
                R.mipmap.bg_ios,
                R.mipmap.bg_other};
        mColorArray = new int[]{android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_purple,
                android.R.color.holo_purple,
                android.R.color.holo_green_light};
        coordinatorTabLayout
                .setTitle("分类阅读")
                .setBackEnable(true)
                .setImageArray(mImageArray,mColorArray)
                .setupWithViewPager(vp);
        coordinatorTabLayout.getTabLayout().setTabMode(TabLayout.MODE_SCROLLABLE);
        vp.setCurrentItem(numToSetCurrentItem);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected Context getActivityContext() {
        return null;
    }
}
