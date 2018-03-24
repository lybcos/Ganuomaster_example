package com.example.administrator.ganuo_master_example.data.Api;

import com.example.administrator.ganuo_master_example.mvp.entity.DataResults;
import com.example.administrator.ganuo_master_example.mvp.entity.DayResults;
import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuDetailResults;
import com.example.administrator.ganuo_master_example.mvp.entity.ZhiHuResults;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2018/2/27.
 * 新建API接口
 */

public interface ZhihuService {

    @GET("/api/4/news/before/{timestamp}")
    Observable<ZhiHuResults> getDataResults(
            @Path("timestamp") String timestamp
    );

    @GET("/api/4/news/{id}")
    Observable<ZhiHuDetailResults> getDataResultsDetail(
            @Path("id") String id
    );
}
