package com.example.administrator.ganuo_master_example.mvp.zhihu.model;

import com.example.administrator.ganuo_master_example.data.HttpData.HttpData;
import com.example.administrator.ganuo_master_example.mvp.base.OnLoadDataListListener;
import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuDetailResults;
import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuResults;

import rx.Observer;

/**
 * Created by Administrator on 2018/2/21.
 */

public class ZhihuFragmentModel {
    public void  loadData(final OnLoadDataListListener listener,boolean isUseCache,String date){
        HttpData.getInstance().getZhihuInfo(new Observer<ZhiHuResults>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                  listener.Error(e);
            }

            @Override
            public void onNext(ZhiHuResults results) {
                 listener.OnSuccess(results);
            }
        },isUseCache,date);
    }
    public void LoadDataDetail(final OnLoadDataListListener listener,String id){
        HttpData.getInstance().getZhihuDetail(new Observer<ZhiHuDetailResults>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.Error(e);
            }

            @Override
            public void onNext(ZhiHuDetailResults results) {
                listener.OnSuccess(results);
            }
        },id);
    }
}
