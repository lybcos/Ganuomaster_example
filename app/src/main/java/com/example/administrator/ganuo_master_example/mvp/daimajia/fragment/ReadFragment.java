package com.example.administrator.ganuo_master_example.mvp.daimajia.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.ganuo_master_example.R;
import com.example.administrator.ganuo_master_example.mvp.base.BaseFragment;
import com.example.administrator.ganuo_master_example.mvp.daimajia.adapter.ReadAdapter;
import com.example.administrator.ganuo_master_example.mvp.daimajia.view.HomeFragmentView;
import com.example.administrator.ganuo_master_example.mvp.entity.DataResults;
import com.example.administrator.ganuo_master_example.mvp.entity.HuaResults;
import com.example.administrator.ganuo_master_example.mvp.entity.Results;
import com.example.administrator.ganuo_master_example.mvp.huaban.view.HuaBanFragmentView;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Administrator on 2018/3/10.
 */

public class ReadFragment extends BaseFragment implements HomeFragmentView {
    private static final String ARG_TITLE="title";
    private SwipyRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private Boolean isTop=true;
    private ReadAdapter readAdapter;
    private static int NOW_PAGE_READ = 1;

    public static ReadFragment getInstance(String title) {//这里返回的是ReadFragment对象
        ReadFragment fra = new ReadFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        fra.setArguments(bundle);
        return fra;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup contain) {
        return inflater.inflate(R.layout.fragment_zhihu,contain,false);
    }

    @Override
    public void initListener() {
        initRecyclerView();
        initSwipyRefreshLayout();

    }

    private void initSwipyRefreshLayout() {
            refreshLayout=mView.findViewById(R.id.swipyrefreshlayout);
            refreshLayout.setColorSchemeColors();
            refreshLayout.setDirection(SwipyRefreshLayoutDirection.BOTH);
            refreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh(SwipyRefreshLayoutDirection direction) {
                    Observable.timer(2, TimeUnit.SECONDS)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Action1<Long>() {
                                @Override
                                public void call(Long aLong) {
                                    refreshLayout.setRefreshing(false);
                                }
                            });
                    isTop=direction==SwipyRefreshLayoutDirection.TOP?true:false;
                    getData(false);
                }
            });

    }

    private void getData(boolean b) {

    }
    private void clearAdapterResults() {
        readAdapter.getResults().clear();
    }

    private void dealWithDataInRecyclerView(List<Results> read_list) {
        readAdapter.getResults().addAll(read_list);
        readAdapter.notifyDataSetChanged();
        NOW_PAGE_READ++;
    }


    private void initRecyclerView() {
        recyclerView = mView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        readAdapter = new ReadAdapter(null,getActivity());
        recyclerView.setAdapter(readAdapter);

    }

    @Override
    public void loadData() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }


    @Override
    public void showLoadFailMsg() {

    }

    @Override
    public void newData(DataResults data) {
        if (data.isError()) {
            Snackbar.make(recyclerView, "啊擦，服务器出问题啦", Snackbar.LENGTH_SHORT).show();
        } else {

            if (isTop) {
                clearAdapterResults();
            }
            dealWithDataInRecyclerView(data.getResults());
        }
    }
}
