package com.example.administrator.ganuo_master_example.mvp.daimajia.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.ganuo_master_example.R;
import com.example.administrator.ganuo_master_example.common.Constant;
import com.example.administrator.ganuo_master_example.mvp.base.BaseFragment;
import com.example.administrator.ganuo_master_example.mvp.daimajia.adapter.GirlAdapter;
import com.example.administrator.ganuo_master_example.mvp.daimajia.presenter.HomeFragmentPresent;
import com.example.administrator.ganuo_master_example.mvp.daimajia.view.HomeFragmentView;
import com.example.administrator.ganuo_master_example.mvp.entity.DataResults;
import com.example.administrator.ganuo_master_example.mvp.entity.HuaResults;
import com.example.administrator.ganuo_master_example.mvp.entity.Results;
import com.example.administrator.ganuo_master_example.mvp.huaban.view.HuaBanFragmentView;
import com.example.administrator.ganuo_master_example.utils.SPUtils;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Administrator on 2018/3/10.
 */

public class DiscoveryFragment extends BaseFragment implements HomeFragmentView {
    private RecyclerView recyclerView;
    SwipyRefreshLayout swipyRefreshLayout;
    private GirlAdapter girlyAdapter;
    private String title;
    private HomeFragmentPresent homePresent;
    private static final String ARG_TITLE = "title";
    private static int FRESH_GANHUO_TIME = 4;
    private static int fi_num = Constant.Num.FI_NUM;
    private static int mz_num = Constant.Num.MZ_NUM;
    private static int NOW_PAGE_FI = 1;
    private static int NOW_PAGE_GH = 1;
    private static int NOW_PAGE_MZ = 1;
    private List<Results> ganhuo_list;
    private List<List<Results>> ganhuo_real_list = new ArrayList<>();
    private boolean isTop = true;

    public static DiscoveryFragment getInstance(String title) {
        DiscoveryFragment fra = new DiscoveryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        fra.setArguments(bundle);
        return fra;
    }



    @Override
    protected void initData(Bundle savedInstanceState) {
        Bundle bundle=getArguments();
        title=bundle.getString(ARG_TITLE);
        homePresent=new HomeFragmentPresent(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup contain) {
        return inflater.inflate(R.layout.fragment_list,contain,false);
    }

    @Override
    public void initListener() {
        initRecyclerView();
        initSwipyRefreshLayout();
    }

    private void initSwipyRefreshLayout() {
        swipyRefreshLayout = (SwipyRefreshLayout) mView.findViewById(R.id.swipyrefreshlayout);
        swipyRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        swipyRefreshLayout.setDirection(SwipyRefreshLayoutDirection.BOTH);

        swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {

                Observable.timer(2, TimeUnit.SECONDS)

                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Long>() {
                            @Override
                            public void call(Long aLong) {

                                swipyRefreshLayout.setRefreshing(false);
                            }
                        });
                isTop = direction == SwipyRefreshLayoutDirection.TOP ? true : false;
                getData(false);
            }
        });
    }

    private void initRecyclerView() {
        recyclerView=mView.findViewById(R.id.recyclerView);
        switch (title) {
            case "首页":
                break;
            case "干货":
                break;
            case "妹纸":
               recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                girlyAdapter=new GirlAdapter(getContext(), 1);
                recyclerView.setAdapter(girlyAdapter);
                break;
        }
    }

    @Override
    public void loadData() {
        boolean isFrist = (boolean) SPUtils.get(getActivity(), "isFrist", false);
            if (!isFrist){
                SPUtils.put(getActivity(),"isFrist",true);
            }
        getData(isFrist);
    }
    private void getData(boolean isUseCache) {
        switch (title) {
            case "首页":
                break;
            case "干货":
                break;
            case "妹纸":
                if (isTop) {
                    NOW_PAGE_MZ=1;
                }
                homePresent.getDataResults(isUseCache,"福利",mz_num,NOW_PAGE_MZ);
                break;
        }
    }

    @Override
    public void newData(DataResults dataResults) {

        if (dataResults.isError()) {
            Snackbar.make(recyclerView, "服务器出问题啦", Snackbar.LENGTH_SHORT).show();
        } else {
            if (title.equals("干货")) {
                ganhuo_list = new ArrayList<>();
                ganhuo_list.addAll(dataResults.getResults());
                ganhuo_real_list.add(ganhuo_list);
                FRESH_GANHUO_TIME++;
            }

            if (isTop) {
                clearAdapterResults();
            }
            dealWithDataInRecyclerView(dataResults.getResults(), ganhuo_real_list, dataResults.getResults());
        }
    }

    private void clearAdapterResults() {
        switch (title) {
            case "首页":
//                partAdapter.getResults().clear();
                break;
            case "妹纸":
                girlyAdapter.getResults().clear();
                break;
        }
    }

    private void dealWithDataInRecyclerView(List<Results> part_list, List<List<Results>> ganhuo_real_list, List<Results> girly_list) {
        switch (title) {
            case "首页":
//                partAdapter.getResults().addAll(part_list);
//                partAdapter.notifyDataSetChanged();
//                NOW_PAGE_FI++;
                break;
            case "干货":
//                if (FRESH_GANHUO_TIME == 4) {
//                    realAdapter.getRealResults().clear();
//                    realAdapter.getRealResults().addAll(ganhuo_real_list);
//                    realAdapter.notifyDataSetChanged();
//                    ganhuo_real_list.clear();
//                }
                break;
            case "妹纸":
                girlyAdapter.getResults().addAll(girly_list);
                girlyAdapter.notifyDataSetChanged();
                NOW_PAGE_MZ++;
                break;
        }
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



}
