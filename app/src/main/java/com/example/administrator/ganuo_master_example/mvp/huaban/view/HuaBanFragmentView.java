package com.example.administrator.ganuo_master_example.mvp.huaban.view;


import com.example.administrator.ganuo_master_example.mvp.entity.DataResults;
import com.example.administrator.ganuo_master_example.mvp.entity.HuaResults;

/**
 * Created by XY on 2016/9/17.
 */
public interface HuaBanFragmentView {
    //显示加载页
    void showProgress();
    //关闭加载页
    void hideProgress();
    //加载新数据
    void newDatas(HuaResults data);
    //显示加载失败
    void showLoadFailMsg();

}
