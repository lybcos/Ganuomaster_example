package com.example.administrator.ganuo_master_example;

import android.content.Context;
import android.content.IntentFilter;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.administrator.ganuo_master_example.mvp.base.BaseActivity;
import com.example.administrator.ganuo_master_example.mvp.daimajia.fragment.GanhuoFragment;
import com.example.administrator.ganuo_master_example.mvp.huaban.fragment.HuaMainFragment;
import com.example.administrator.ganuo_master_example.mvp.zhihu.fragment.ZhiHuMainFragment;

import com.example.administrator.ganuo_master_example.utils.PerfectClickListener;

public class MainActivity extends BaseActivity{
    NavigationView mNavView;
    DrawerLayout mDrawerLayout;
    private long mExitTime = 0;
    private FrameLayout fl_content;
    private long lastTime=0;
    private GanhuoFragment ganhuoFragment;
    private ZhiHuMainFragment zhiHuFragment;
    private HuaMainFragment huaBanFragment;
    private IntentFilter intentFilter;
    private NetWorkBroadcast  netWorkBroadcast;


    @Override
    public void loadViewLayout() {
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netWorkBroadcast=new NetWorkBroadcast();
        registerReceiver(netWorkBroadcast,intentFilter);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netWorkBroadcast);
    }

    @Override
    protected void findViewById() {
        fl_content = findViewById(R.id.fl_content);
        mNavView = findViewById(R.id.nav_view);
        mDrawerLayout = findViewById(R.id.mainActivity);
    }

    @Override
    protected void setListener() {
        initDrawer();
    }

    @Override
    protected void processLogic() {
        ganhuoFragment = new GanhuoFragment();
        zhiHuFragment=new ZhiHuMainFragment();
        huaBanFragment= new HuaMainFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_content,ganhuoFragment)
                .add(R.id.fl_content,zhiHuFragment)
                .add(R.id.fl_content,huaBanFragment)
                .show(zhiHuFragment).hide(ganhuoFragment).hide(huaBanFragment).commit();
    }

    @Override
    protected Context getActivityContext() {
        return null;
    }

    public void initDrawer() {
        mNavView.inflateHeaderView(R.layout.layout_main_nav);
        View headerview= mNavView.getHeaderView(0);
        headerview.findViewById(R.id.ll_nav_zhihu).setOnClickListener(clickListener);
        headerview.findViewById(R.id.ll_nav_daima).setOnClickListener(clickListener);
        headerview.findViewById(R.id.ll_nav_sister).setOnClickListener(clickListener);
        headerview.findViewById(R.id.ll_nav_exit).setOnClickListener(clickListener);
    }
    private PerfectClickListener clickListener=new PerfectClickListener() {
        @Override
        protected void onNoDoubleClick(final View v) {
            mDrawerLayout.closeDrawer(Gravity.START);
            mDrawerLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch (v.getId()) {
                        case R.id.ll_nav_zhihu:
                            getSupportFragmentManager().beginTransaction().show(zhiHuFragment).hide(huaBanFragment)
                                    .hide(ganhuoFragment).commit();
                            break;
                        case R.id.ll_nav_daima:
                            getSupportFragmentManager().beginTransaction().show(ganhuoFragment).hide(huaBanFragment)
                                    .hide(zhiHuFragment).commit();
                            break;
                        case R.id.ll_nav_sister:
                            getSupportFragmentManager().beginTransaction().show(huaBanFragment).hide(zhiHuFragment)
                                    .hide(ganhuoFragment).commit();
                            break;
                        case R.id.ll_nav_exit:
                            finish();
                            break;
                    }
                }
            }, 260);

        }
    };

        @Override
        public void onBackPressed() {
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }

            if ( System.currentTimeMillis() - lastTime > 2000) {
                Toast.makeText(MainActivity.this, R.string.exit_again, Toast.LENGTH_SHORT).show();
                lastTime = System.currentTimeMillis();
                return;
            }else {
                finish();
            }
        }


    }

