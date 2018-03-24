package com.example.mochenmanhua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mochenmanhua.data.HttpData.retrofit.Api.GanHuoService;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

public class MainActivity extends AppCompatActivity {
        private SearchView searchView;
        private GanHuoService ganHuoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView=findViewById(R.id.search_view);
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String content) {

            }
        });
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
    }
}
