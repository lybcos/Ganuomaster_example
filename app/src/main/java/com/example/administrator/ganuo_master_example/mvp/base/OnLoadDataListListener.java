package com.example.administrator.ganuo_master_example.mvp.base;

/**
 * Created by Administrator on 2018/2/21.
 */

public interface OnLoadDataListListener<T>{
    void OnSuccess(T Data);
    void Error(Throwable e);
}
