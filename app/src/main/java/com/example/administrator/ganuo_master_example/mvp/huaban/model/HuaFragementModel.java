package com.example.administrator.ganuo_master_example.mvp.huaban.model;

import com.example.administrator.ganuo_master_example.data.HttpData.HttpData;
import com.example.administrator.ganuo_master_example.mvp.base.OnLoadDataListListener;
import com.example.administrator.ganuo_master_example.mvp.entity.HuaResults;

import rx.Observer;

/**
 * Created by Administrator on 2018/3/16.
 */

public class HuaFragementModel {
    public void loadData(final OnLoadDataListListener listener, boolean isUseCache, String type, int max) {
        HttpData.getInstance().getHuaInfo(new Observer<HuaResults>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.Error(e);
            }

            @Override
            public void onNext(HuaResults huaResults) {
                    listener.OnSuccess(huaResults);
            }
        },isUseCache, type, max);
    }
}
