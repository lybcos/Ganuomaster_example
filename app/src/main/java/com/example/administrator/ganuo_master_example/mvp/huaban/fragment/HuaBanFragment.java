package com.example.administrator.ganuo_master_example.mvp.huaban.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.ganuo_master_example.R;
import com.example.administrator.ganuo_master_example.mvp.base.BaseFragment;

/**
 * Created by Administrator on 2018/2/16.
 */

public class HuaBanFragment extends BaseFragment {


    public static HuaBanFragment getInstance(String type) {
        HuaBanFragment fra = new HuaBanFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        fra.setArguments(bundle);
        return fra;
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
