package com.example.administrator.ganuo_master_example.mvp.daimajia.model;

import com.example.administrator.ganuo_master_example.data.HttpData.HttpData;
import com.example.administrator.ganuo_master_example.mvp.base.OnLoadDataListListener;
import com.example.administrator.ganuo_master_example.mvp.entity.DataResults;

import rx.Observer;

/**
 * Created by Administrator on 2018/3/11.
 */

public class HomeFragmentModel {
    public void loadData(final OnLoadDataListListener listener,String type,boolean isCache,int number, int page) {
        HttpData.getInstance().getHomeInfo(new Observer<DataResults>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.Error(e);
            }

            @Override
            public void onNext(DataResults results) {
                    listener.OnSuccess(results);
            }
        },isCache,type,number,page);
    }
}
