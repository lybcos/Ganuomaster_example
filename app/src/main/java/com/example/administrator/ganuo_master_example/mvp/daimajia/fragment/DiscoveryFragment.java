package com.example.administrator.ganuo_master_example.mvp.daimajia.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.ganuo_master_example.mvp.base.BaseFragment;
import com.example.administrator.ganuo_master_example.mvp.daimajia.view.HomeFragmentView;
import com.example.administrator.ganuo_master_example.mvp.entity.DataResults;
import com.example.administrator.ganuo_master_example.mvp.entity.HuaResults;
import com.example.administrator.ganuo_master_example.mvp.huaban.view.HuaBanFragmentView;

/**
 * Created by Administrator on 2018/3/10.
 */

public class DiscoveryFragment extends BaseFragment implements HomeFragmentView {

    public static DiscoveryFragment getInstance(String type) {
        DiscoveryFragment fra = new DiscoveryFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        fra.setArguments(bundle);
        return fra;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }



    @Override
    public void showLoadFailMsg() {

    }

    @Override
    public void newData(DataResults results) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup contain) {
        return null;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void loadData() {

    }
}
