package com.example.administrator.ganuo_master_example.mvp.zhihu.view;

import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuDetailResults;
import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuResults;

/**
 * Created by Administrator on 2018/2/21.
 */

public interface ZhiHuFragmentView {
    //显示加载页
    void showProgress();
    //隐藏加载页
    void hideProgress();
    //显示加载失败
    void showLoadFailMsg();
    //加载新数据
    void newDatas(ZhiHuResults results);
    //加载zhihuDetail页面的新数据
    void newDataDetail(ZhiHuDetailResults results);
}
