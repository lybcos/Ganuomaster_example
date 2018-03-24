package com.example.administrator.ganuo_master_example.data.retrofit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.administrator.ganuo_master_example.MyApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/2/21.
 * 新建 retrofit 抽象类
 */

public abstract class RetrofitUtils {
    private static Retrofit retrofit;
    public static OkHttpClient httpClient;

    public Retrofit getRetrofit(String baseUrl) {
        if (null == httpClient) {
            httpClient=OkHttp3Utils.getOkHttpClient(baseUrl);
        }
        retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                //添加转化库，默认Gson
                .addConverterFactory(GsonConverterFactory.create())
                //添加回调库，采用RxJava
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //设置使用okHttp网络请求
                .client(httpClient)
                .build();
        return retrofit;
    }
}
