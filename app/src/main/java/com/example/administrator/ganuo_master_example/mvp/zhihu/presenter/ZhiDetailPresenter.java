package com.example.administrator.ganuo_master_example.mvp.zhihu.presenter;

import com.example.administrator.ganuo_master_example.mvp.base.OnLoadDataListListener;
import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuDetailResults;
import com.example.administrator.ganuo_master_example.mvp.zhihu.model.ZhihuFragmentModel;
import com.example.administrator.ganuo_master_example.mvp.zhihu.view.ZhiHuFragmentView;

/**
 * Created by Administrator on 2018/2/27.
 */

public class ZhiDetailPresenter implements OnLoadDataListListener<ZhiHuDetailResults> {
    private ZhiHuFragmentView mView;
    private ZhihuFragmentModel mModel;

    public ZhiDetailPresenter(ZhiHuFragmentView mView) {
        this.mView = mView;
        this.mModel = new ZhihuFragmentModel();
    }

    @Override
    public void OnSuccess(ZhiHuDetailResults data) {
        mView.newDataDetail(data);
        mView.hideProgress();
    }

    @Override
    public void Error(Throwable e) {
        mView.showLoadFailMsg();
    }

    public void getDataResults(String s) {
        mModel.LoadDataDetail(this,s);
    }
}
