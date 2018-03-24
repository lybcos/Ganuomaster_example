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

/**
 * Created by Administrator on 2018/2/21.
 */

public class OkHttp3Utils {
    private static OkHttpClient okHttpClient;

    /**
     * 获取OkHttpClient对象
     */
    protected static OkHttpClient getOkHttpClient(String baseUrl){
        if (null == okHttpClient) {
            okHttpClient=new OkHttpClient.Builder()
                    .addNetworkInterceptor(TestInterceptor)
                    .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10,TimeUnit.SECONDS)
                    .connectTimeout(10,TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }
    /**
     * 云端响应头拦截器，用来配置缓存策略
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
    private static  final Interceptor TestInterceptor=new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request=chain.request();
            //这里就是说判读我们的网络条件，要是有网络的话我么就直接获取网络上面的数据，要是没有网络的话我么就去缓存里面取数据
            if (!isNeetWorkReachable(MyApplication.getInstance()
                    .getApplicationContext())){
    //这个的话内容有点多啊，大家记住这么写就是只从缓存取，想要了解这个东西我等下再
   // 给大家写连接吧。大家可以去看下，获取大家去找拦截器资料的时候就可以看到这个方面的东西反正也就是缓存策略。
                request=request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response=chain.proceed(request);
            if (!isNeetWorkReachable(MyApplication.getInstance().getApplicationContext())){
                String cacheControl=request.cacheControl().toString();
                return response.newBuilder()
                        .header("Cache-Control",cacheControl)
                        .removeHeader("Pragma")
                        .build();
            }else {
                int maxStale=60*60*24*365;//无网络时间
                //这里的设置的是我们的没有网络的缓存时间，想设置多少就是多少。
                return response.newBuilder().
                        header("Cache-Control","public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build();
            }
        }

    };

    /**
     * 判断网络是否可用
     *
     * @param context Context对象
     */
    public static Boolean isNeetWorkReachable(Context context) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo current=cm.getActiveNetworkInfo();
        if (current == null) {
            return false;
        }
        return (current.isAvailable());
    }
}
