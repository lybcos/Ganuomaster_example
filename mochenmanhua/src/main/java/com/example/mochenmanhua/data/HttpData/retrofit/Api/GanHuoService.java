package com.example.mochenmanhua.data.HttpData.retrofit.Api;


import com.example.mochenmanhua.data.HttpData.retrofit.entity.BookList;
import com.example.mochenmanhua.data.HttpData.retrofit.entity.Chapter;
import com.example.mochenmanhua.data.HttpData.retrofit.entity.Classify;
import com.example.mochenmanhua.data.HttpData.retrofit.entity.Detail;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/3/19.
 *
 */

public interface GanHuoService {
    //漫画分类列表
    @GET("category")
    Observable<Classify> getClassify(@Query("key")int key);    //漫画章节

    //漫画书列表
    @GET("book")
    Observable<BookList>getBookList(@FieldMap Map<String ,String>map);    //漫画章节

    //漫画章节
    @GET("chapter")
    Observable<Chapter>getChapter(@Query("comicName")String comicName, @Query("key")int key);    //漫画章节

    //漫画书章节详细内容
    @GET("chapterContent")
    Observable<Detail>getDetail(@Query("comicName")String comicName, @Query("key")int key, @Query("id")int id);
}
