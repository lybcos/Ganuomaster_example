package com.example.administrator.ganuo_master_example.mvp.zhihu.presenter;

import com.example.administrator.ganuo_master_example.mvp.base.OnLoadDataListListener;
import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuResults;
import com.example.administrator.ganuo_master_example.mvp.zhihu.model.ZhihuFragmentModel;
import com.example.administrator.ganuo_master_example.mvp.zhihu.view.ZhiHuFragmentView;

/**
 * Created by Administrator on 2018/2/27.
 */

public class ZhiHuPresenter implements OnLoadDataListListener<ZhiHuResults> {
    private ZhiHuFragmentView mView;
    private ZhihuFragmentModel mModel;

    public ZhiHuPresenter(ZhiHuFragmentView mView) {
        this.mView = mView;
        this.mModel = new ZhihuFragmentModel();
        mView.showProgress();
    }

    public void getDataResult(boolean isCache,String date) {
        mModel.loadData(this,isCache,date);
    }
    @Override
    public void OnSuccess(ZhiHuResults data) {
        mView.newDatas(data);
        mView.hideProgress();
    }

    @Override
    public void Error(Throwable e) {
         mView.showLoadFailMsg();
    }
}
