package com.example.retrofitdemo;

import android.support.v4.provider.SelfDestructiveThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class MainActivity extends AppCompatActivity {

    private RetrofitApi api;
    private TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tt=findViewById(R.id.tt);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/toutiao/index/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(RetrofitApi.class);//获得接口实例
    }

    public void retrofitApi(View view) throws IOException {
//        Map<String,String>map=new HashMap<>();
//        map.put("id","1");
//        map.put("username","lyb");
        //调用方法得到一个call
//      Call<User>call= api.getApiInfoPath(3);
//      //异步(进行网络请求)
//      call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//
//                    Toast.makeText(MainActivity.this, "\nid="+
//                            response.body().getId(), Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//
//            }
//        });
//
//        Call<wanAndroid>call= api.getRex("guonei",R.string.xinwen);
//        call.enqueue(new Callback<wanAndroid>() {
//            @Override
//            public void onResponse(Call<wanAndroid> call, Response<wanAndroid> response) {
//              Toast.makeText(MainActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<wanAndroid> call, Throwable t) {
//                Log.d("messageas",t.toString());
//                Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get("http://apis.juhe.cn/train/s?name=G4&dtype=&key=3af0876df49123de34e2503512171ab6",new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Toast.makeText(MainActivity.this, "请求成功"+statusCode, Toast.LENGTH_SHORT).show();

//                    JSONObject object=response.getJSONObject("result");
//                    String a=object.getString("result");
                    Log.d("Msglyb", response.toString());
                try {
                    tt.setText(response.getString("start"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

        }
}
