package com.example.administrator.ganuo_master_example.data.HttpData;

import com.example.administrator.ganuo_master_example.common.Constant;
import com.example.administrator.ganuo_master_example.data.Api.CacheProviders;
import com.example.administrator.ganuo_master_example.data.Api.GanHuoService;
import com.example.administrator.ganuo_master_example.data.Api.HuaBangService;
import com.example.administrator.ganuo_master_example.data.Api.ZhihuService;
import com.example.administrator.ganuo_master_example.data.retrofit.RetrofitUtils;
import com.example.administrator.ganuo_master_example.mvp.entity.DataResults;
import com.example.administrator.ganuo_master_example.mvp.entity.HuaResults;
import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuDetailResults;
import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuResults;
import com.example.administrator.ganuo_master_example.utils.FileUtil;

import java.io.File;
import java.util.List;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.Reply;
import io.rx_cache.internal.RxCache;
import okhttp3.internal.http.HttpDate;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/2/27.
 *
 * 所有的请求数据的方法集中地
 * 根据MovieService的定义编写合适的方法
 * 其中observable是获取API数据
 * observableCahce获取缓存数据
 * new EvictDynamicKey(false) false使用缓存  true 加载数据不使用缓存
 */

public class HttpData extends RetrofitUtils{
    private static File file= FileUtil.getcacheDirectory();//获得缓存目录
    private static final CacheProviders providers=new RxCache.Builder()
            .persistence(file)
            .using(CacheProviders.class);
    protected GanHuoService ganService = getRetrofit(Constant.Urls.API_SERVER).create(GanHuoService.class);
    protected ZhihuService zhiService = getRetrofit(Constant.Urls.ZHIHU_DAILY_BEFORE).create(ZhihuService.class);
    protected ZhihuService zhiDetailService = getRetrofit(Constant.Urls.ZHIHU_DAILY_OFFLINE_NEWS).create(ZhihuService.class);
    protected HuaBangService huaBangService = getRetrofit(Constant.Urls.HUA_BANG_URL).create(HuaBangService.class);

    private static class SingletonHolder{
        private static final HttpData INSTANCE=new HttpData();
    }
    public static HttpData getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public void getHomeInfo(Observer<DataResults> observer, boolean isUseCache, String type, int number, int page) {
        Observable observable = ganService.getDataResults(type, number, page);
        //!isUseCache
        Observable observableCahce = providers.getHomeTypes(observable, new DynamicKey("首页"), new EvictDynamicKey(true)).map(new HttpResultFuncCcche<List<DataResults>>());
        setSubscribe(observableCahce, observer);
    }

    public void getZhihuInfo(Observer<ZhiHuResults> observer,  boolean isUseCache,String date) {
        Observable observable = zhiService.getDataResults(date);
        Observable observableCahce = providers.getZhiTypes(observable, new DynamicKey("知乎"), new EvictDynamicKey(true)).map(new HttpResultFuncCcche<List<ZhiHuResults>>());
        setSubscribe(observableCahce, observer);
    }

    public void getZhihuDetail(Observer<ZhiHuDetailResults> observer, String id) {
        Observable observable = zhiDetailService.getDataResultsDetail(id);
        setSubscribe(observable, observer);
    }


    public void getHuaInfo(Observer<HuaResults> observer, boolean isUseCache, String type, int max) {
        Observable observable;
        if (max == 0) {
            observable = huaBangService.getDataResults(type, 40);
        } else {
            observable = huaBangService.getDataResultsMax(type, 40, max);
        }
        Observable observableCahce = providers.getHuaTypes(observable, new DynamicKey("花瓣"), new EvictDynamicKey(true)).map(new HttpResultFuncCcche<List<HuaResults>>());
        setSubscribe(observableCahce, observer);
    }


    private static <T> void setSubscribe(Observable<T>observableCahce, Observer<T> observer) {
        observableCahce.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    /**
     * 用来统一处理RxCacha的结果
     */
    private class HttpResultFuncCcche<T> implements Func1<Reply<T>, T> {

        @Override
        public T call(Reply<T> httpResult) {
            return httpResult.getData();
        }
    }

}
