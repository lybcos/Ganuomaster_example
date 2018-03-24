package com.example.administrator.ganuo_master_example.data.Api;

import com.example.administrator.ganuo_master_example.mvp.entity.DataResults;
import com.example.administrator.ganuo_master_example.mvp.entity.DayResults;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2018/2/27.
 */

public interface GanHuoService {

    @GET("data/{type}/{number}/{page}")
    Observable<DataResults> getDataResults(
            @Path("type") String type,
            @Path("number") int number,
            @Path("page") int page
    );

    @GET("day/{year}/{month}/{day}")
    Observable<DayResults> getDayResults(
            @Path("year") int year,
            @Path("month") int month,
            @Path("day") int day
    );

}
