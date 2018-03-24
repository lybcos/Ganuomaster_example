package com.example.administrator.ganuo_master_example.mvp.zhihu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.ganuo_master_example.R;
import com.example.administrator.ganuo_master_example.common.Constant;
import com.example.administrator.ganuo_master_example.WebAcitivity;
import com.example.administrator.ganuo_master_example.mvp.base.BaseFragment;
import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuDetailResults;
import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuResults;
import com.example.administrator.ganuo_master_example.mvp.zhihu.adapter.ZhiFragmentAdapter;
import com.example.administrator.ganuo_master_example.mvp.zhihu.presenter.ZhiDetailPresenter;
import com.example.administrator.ganuo_master_example.mvp.zhihu.presenter.ZhiHuPresenter;
import com.example.administrator.ganuo_master_example.mvp.zhihu.view.ZhiHuFragmentView;
import com.example.administrator.ganuo_master_example.utils.SPUtils;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Administrator on 2018/2/21.
 */

public class ZhiHuFragment extends BaseFragment implements ZhiHuFragmentView {
    private String date;
    private ZhiFragmentAdapter mAdapter;
    private SwipyRefreshLayout swipyRefreshLayout;
    private RecyclerView recyclerview;
    private boolean isToday;
    private ZhiDetailPresenter detailPresenter;
    private ZhiHuPresenter presenter;
    private ZhiHuResults zhiHuResults;
    private boolean isShareClick;
    @Override
    public View initView(LayoutInflater inflater, ViewGroup contain) {
        return inflater.inflate(R.layout.fragment_zhihu, contain, false);
    }
    @Override
    public void initListener() {
        initRecyclerView();
        initSwipyRefreshLayout();
    }
    public static ZhiHuFragment getInstance(String date, int i) {//?
        ZhiHuFragment fra = new ZhiHuFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.BundleKeys.DATE, date);
        bundle.putBoolean(Constant.BundleKeys.IS_FIRST_PAGE, i == 0);
        bundle.putBoolean(Constant.BundleKeys.IS_SINGLE, false);
        fra.setArguments(bundle);
        return fra;
    }

    private void initSwipyRefreshLayout() {
        swipyRefreshLayout = (SwipyRefreshLayout) mView.findViewById(R.id.swipyrefreshlayout);
        swipyRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        swipyRefreshLayout.setDirection(SwipyRefreshLayoutDirection.TOP);

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
                getData(false, date);

            }
        });

    }

    private void getData(boolean b, String date) {
       presenter.getDataResult(b,date);
    }

    private void initRecyclerView() {
        recyclerview = (RecyclerView) mView.findViewById(R.id.recyclerView);
        recyclerview.setHasFixedSize(!isToday);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(llm);
        mAdapter = new ZhiFragmentAdapter(getActivity(), null);
        recyclerview.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ZhiFragmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("position", "position:" + position);
                isShareClick = false;
                int id = zhiHuResults.getStories().get(position).getId();
                detailPresenter.getDataResults(String.valueOf(id));

            }
        });
        mAdapter.setOnShareClickListener(new ZhiFragmentAdapter.OnShareClickListener() {
            @Override
            public void onShareClick(View view, int position) {
                isShareClick = true;
                int id = zhiHuResults.getStories().get(position).getId();
                detailPresenter.getDataResults(String.valueOf(id));
            }
        });
    }

    @Override
    public void loadData() {
        boolean isFirst = (boolean) SPUtils.get(getActivity(), "isFirst", false);
        if(!isFirst){
            SPUtils.put(getActivity(), "isFirst", true);
        }
        getData(isFirst, date);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void newDatas(ZhiHuResults data) {
        if (data != null) {
            this.zhiHuResults = data;
            mAdapter.setZhiHuResults(data);
        }

    }

    @Override
    public void showLoadFailMsg() {

    }

    @Override
    public void newDataDetail(ZhiHuDetailResults data) {
        if (data != null) {
            Log.d("position", "data:" + data.toString());
            if (isShareClick) {
                shareQuestion(data.getShare_url(), data.getTitle());
            } else {
                WebAcitivity.newIntent(getActivity(), data.getShare_url(), data.getTitle());
            }
        }
    }

    private void shareQuestion(String share_url, String title) {
        Intent share=new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");//指定发送内容类型
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        share.putExtra(Intent.EXTRA_TEXT,title+""+share_url+Constant.Strings.SHARE_FROM_ZHIHU);
        startActivity(Intent.createChooser(share,getString(R.string.share_to)));
    }


    @Override
    protected void initData(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Bundle bundle = getArguments();
            date = bundle.getString(Constant.BundleKeys.DATE);
            isToday = bundle.getBoolean(Constant.BundleKeys.IS_FIRST_PAGE);
            setRetainInstance(true);
        }
        presenter=new ZhiHuPresenter(this);
        detailPresenter=new ZhiDetailPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
