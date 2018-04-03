package com.example.retrofitdemo;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2018/2/24.
 */

public interface RetrofitApi {
    @GET("Home/view/")
    Call<User>getApiInfo(@Query("id")int id);//动态传递参数

    @GET("Home/view/api.json")//大括号表示占位符
    Call<User>getApiInfoPath(@Path("id")int user_id);

    @GET("Home/{id}")//大括号表示占位符
    Call<User>getApiInfoMap(@QueryMap()Map<String,String>params);

    @FormUrlEncoded
    @POST("book/reviews")
    Call<String> addReviews(@FieldMap Map<String, String> fields);


    @POST("")//@GET("")里面一定要有数据，不能为@GET 或者@GET("")，要想解决，
    Call<String>addReviews(@Body Review review);//如果请求的参数比较多一点，统一封装到一个类中应该会更好

            public class Review{
                private String book;
                private String title;
                private String content;
                private String rating;
            }

    @GET("/")
    Call<wanAndroid> getRex(@Query("type")String type,@Query("key")int key );
}
