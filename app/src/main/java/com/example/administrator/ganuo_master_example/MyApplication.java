package com.example.administrator.ganuo_master_example;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/16.
 */

public class MyApplication extends Application{

    //记录当前栈里所有activity
    private List<Activity> activities = new ArrayList<Activity>();
    //记录需要一次性关闭的页面
    private List<Activity> activitys = new ArrayList<Activity>();
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        Fresco.initialize(this);
    }
    private static MyApplication instance;

    public static MyApplication getInstance(){
        return instance;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void finishActivity(Activity activity){
        if (activity != null) {
            this.activities.remove(activity);
            activity.finish();
            activity=null;
        }
    }
    /*
*给临时Activitys
* 添加activity
* */
    public void addTemActivity(Activity activity)    {
        activitys.add(activity);
    }

    public void finishTemActivity(Activity activity) {
        if (activity != null) {
            this.activitys.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /*
    * 退出指定的Activity
    * */
    public void exitActivitys() {
        for (Activity activity : activitys) {
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /**
     * 应用退出，结束所有的activity
     */
    public void exit() {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
    }

}
