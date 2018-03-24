package com.example.mochenmanhua.data.HttpData;

import com.example.mochenmanhua.data.HttpData.retrofit.Api.GanHuoService;
import com.example.mochenmanhua.data.HttpData.retrofit.RetrofitUtil;
import com.example.mochenmanhua.data.HttpData.retrofit.entity.BookList;
import com.example.mochenmanhua.data.HttpData.retrofit.entity.Chapter;
import com.example.mochenmanhua.data.HttpData.retrofit.entity.Classify;
import com.example.mochenmanhua.data.HttpData.retrofit.entity.Detail;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.internal.RxCache;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/3/19.
 */

public class HttpData extends RetrofitUtil {
    private File file = new File("E:/");
    private CacheProviders providers=new RxCache
            .Builder()
            .persistence(file)
            .using(CacheProviders.class);

    private GanHuoService chapter=getRetrofit().create(GanHuoService.class);
    private GanHuoService bookList=getRetrofit().create(GanHuoService.class);
    private GanHuoService classIfy=getRetrofit().create(GanHuoService.class);
    private GanHuoService detail=getRetrofit().create(GanHuoService.class);

    public static  class  SingleInstance{
        private static final HttpData httpData = new HttpData();
    }
    public static HttpData getInstace(){
        return SingleInstance.httpData;
    }

    public void getChapter(Observer<Chapter> observer,String coniname, int key) {
        Observable observable = chapter.getChapter(coniname,key);
        //!isUseCache
       Observable observableCahce =providers.getChapter(observable,new DynamicKey(""),new EvictDynamicKey(true)).map(new HttpResultFuncCcche<List<Chapter>>());
        setSubscribe(observableCahce, observer);
    }

    public void getBookList(Observer<Chapter> observer ,int key,String name,String type,int skip,int finish) {
        Map map = new HashMap();
        map.put("key",key);
        map.put("name",name);
        map.put("type",type);
        map.put("skip",skip);
        map.put("finish",finish);
        Observable observable = bookList.getBookList(map);
        //!isUseCache
       Observable observableCahce =providers.getBookList(observable,new DynamicKey(""),new EvictDynamicKey(true)).map(new HttpResultFuncCcche<List<BookList>>());
        setSubscribe(observableCahce, observer);
    }

    public void getClassify(Observer<Chapter> observer ,int key) {
        Observable observable = classIfy.getClassify(key);
        //!isUseCache
       Observable observableCahce =providers.getClassify(observable,new DynamicKey(""),new EvictDynamicKey(true)).map(new HttpResultFuncCcche<List<Classify>>());
        setSubscribe(observableCahce, observer);
    }

    public void getDetail(Observer<Chapter> observer,String coniname, int key,int id) {
        Observable observable = detail.getDetail(coniname,key,id);
        //!isUseCache
       Observable observableCahce =providers.getDetail(observable,new DynamicKey(""),new EvictDynamicKey(true)).map(new HttpResultFuncCcche<List<Detail>>());
        setSubscribe(observableCahce, observer);
    }

    private void setSubscribe(Observable observableCahce, Observer<Chapter> observer) {
        observableCahce.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    //用来处理RxCache处理的结果
    private class HttpResultFuncCcche<T> implements rx.functions.Func1 {
        @Override
        public Object call(Object o) {
            return null;
        }
    }
}
