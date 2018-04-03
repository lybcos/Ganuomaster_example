package com.example.administrator.ganuo_master_example.data.db;

import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.ganuo_master_example.MyApplication;


public class TasksManagerDBController {
    public final static String TABLE_NAME = "freebook";
    public final SQLiteDatabase db;

    public TasksManagerDBController() {
        TasksManagerDBOpenHelper openHelper = new TasksManagerDBOpenHelper(MyApplication.getInstance());

        db = openHelper.getWritableDatabase();
    }
}