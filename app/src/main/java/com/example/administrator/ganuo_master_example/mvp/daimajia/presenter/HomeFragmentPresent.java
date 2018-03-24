package com.example.administrator.ganuo_master_example.mvp.daimajia.presenter;

import com.example.administrator.ganuo_master_example.mvp.base.OnLoadDataListListener;
import com.example.administrator.ganuo_master_example.mvp.daimajia.model.HomeFragmentModel;
import com.example.administrator.ganuo_master_example.mvp.daimajia.view.HomeFragmentView;
import com.example.administrator.ganuo_master_example.mvp.entity.DataResults;

/**
 * Created by Administrator on 2018/3/11.
 */

public class HomeFragmentPresent implements OnLoadDataListListener<DataResults> {
    private HomeFragmentView mView;
    private HomeFragmentModel mModel;

    public HomeFragmentPresent(HomeFragmentView hView) {
        this.mView = hView;
        mModel=new HomeFragmentModel();
        mView.showProgress();
    }
    public void getDataResults(boolean isCache,String type,int number,int page){
        mModel.loadData(this,type,isCache,number,page);
    }

    @Override
    public void OnSuccess(DataResults data) {
        mView.newData(data);
        mView.hideProgress();
    }

    @Override
    public void Error(Throwable e) {
        mView.showLoadFailMsg();
    }
}
