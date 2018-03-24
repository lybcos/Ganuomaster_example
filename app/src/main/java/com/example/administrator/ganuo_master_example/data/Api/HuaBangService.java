package com.example.administrator.ganuo_master_example.data.Api;

import com.example.administrator.ganuo_master_example.mvp.entity.HuaResults;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/2/27.
 */

public interface HuaBangService {

    @GET("favorite/{type}")
    Observable<HuaResults> getDataResults(@Path("type") String type, @Query("limit") int limit);

    //模板类型 的后续联网 max
    @GET("favorite/{type}")
    Observable<HuaResults> getDataResultsMax( @Path("type") String type, @Query("max") int max, @Query("limit") int limit);

}
