package com.example.administrator.ganuo_master_example.mvp.huaban.presenter;

import com.example.administrator.ganuo_master_example.mvp.base.OnLoadDataListListener;
import com.example.administrator.ganuo_master_example.mvp.entity.HuaResults;
import com.example.administrator.ganuo_master_example.mvp.huaban.model.HuaFragementModel;
import com.example.administrator.ganuo_master_example.mvp.huaban.view.HuaBanFragmentView;

/**
 * Created by Administrator on 2018/3/16.
 */

public class HuaPresent implements OnLoadDataListListener<HuaResults> {
    public HuaBanFragmentView mView;
    private HuaFragementModel mModel;

    public HuaPresent(HuaBanFragmentView mView) {
        this.mView = mView;
        this.mModel = new HuaFragementModel();
    }

    public void getDataResults(boolean isUseCache, String type, int max) {
        mModel.loadData(this,isUseCache,type,max);
    }
    @Override
    public void OnSuccess(HuaResults data) {
        mView.newDatas(data);
        mView.hideProgress();
    }

    @Override
    public void Error(Throwable e) {
        mView.showLoadFailMsg();
    }
}
