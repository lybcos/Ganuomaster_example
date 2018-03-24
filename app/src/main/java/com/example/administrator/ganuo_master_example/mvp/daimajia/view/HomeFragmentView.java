package com.example.administrator.ganuo_master_example.mvp.daimajia.view;

import com.example.administrator.ganuo_master_example.mvp.entity.DataResults;

/**
 * Created by Administrator on 2018/3/11.
 */

public interface HomeFragmentView {
    //显示加载页
    void showProgress();
    //隐藏加载页
    void hideProgress();
    //显示加载失败
    void showLoadFailMsg();
    //加载新数据
    void newData(DataResults results);
}
