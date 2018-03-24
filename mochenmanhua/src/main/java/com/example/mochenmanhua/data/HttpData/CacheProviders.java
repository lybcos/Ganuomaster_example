package com.example.mochenmanhua.data.HttpData;


import com.example.mochenmanhua.data.HttpData.retrofit.entity.BookList;
import com.example.mochenmanhua.data.HttpData.retrofit.entity.Chapter;
import com.example.mochenmanhua.data.HttpData.retrofit.entity.Classify;
import com.example.mochenmanhua.data.HttpData.retrofit.entity.Detail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.LifeCache;
import io.rx_cache.Reply;

/**
 * Created by Administrator on 2018/2/27.
 * 新建缓存接口
 * 缓存API接口
 *
 * @LifeCache设置缓存过期时间. 如果没有设置@LifeCache , 数据将被永久缓存理除非你使用了 EvictProvider, EvictDynamicKey or EvictDynamicKeyGroup .
 * EvictProvider可以明确地清理清理所有缓存数据.
 * EvictDynamicKey可以明确地清理指定的数据 DynamicKey.
 * EvictDynamicKeyGroup 允许明确地清理一组特定的数据. DynamicKeyGroup.
 * DynamicKey驱逐与一个特定的键使用EvictDynamicKey相关的数据。比如分页，排序或筛选要求
 * DynamicKeyGroup。驱逐一组与key关联的数据，使用EvictDynamicKeyGroup。比如分页，排序或筛选要求
 */


public interface CacheProviders {
    @LifeCache(duration = 7,timeUnit = TimeUnit.DAYS)
    rx.Observable<Reply<List<Chapter>>> getChapter(rx.Observable observable, DynamicKey username, EvictDynamicKey evictDynamicKey);
    //缓存时间 1天
    @LifeCache(duration = 7, timeUnit = TimeUnit.DAYS)
    rx.Observable<Reply<List<BookList>>> getBookList(rx.Observable observable, DynamicKey userName, EvictDynamicKey evictDynamicKey);

    //缓存时间 1天
    @LifeCache(duration = 7, timeUnit = TimeUnit.DAYS)
    rx.Observable<Reply<List<Classify>>> getClassify(rx.Observable observable, DynamicKey userName, EvictDynamicKey evictDynamicKey);

    //缓存时间 1天
    @LifeCache(duration = 7, timeUnit = TimeUnit.DAYS)
    rx.Observable<Reply<List<Detail>>> getDetail(rx.Observable observable, DynamicKey userName, EvictDynamicKey evictDynamicKey);
}

