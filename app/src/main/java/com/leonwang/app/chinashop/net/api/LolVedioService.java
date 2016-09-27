package com.leonwang.app.chinashop.net.api;

import com.leonwang.app.chinashop.entity.VideoEntity;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 当前类注释：LOL视频
 * Author :LeonWang
 * Created  2016/9/27.13:45
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public interface LolVedioService {

   /* @GET("rest/ItemsService/videos{}")
    Observable<VideoEntity> getLolVideoUrl(@Path("catid") String catid,
                                           @Path("catwordid") String catwordid,
                                           @Path("page") String curPage,
                                           @Path("t_") String t_,
                                           @Path("p_") String p_);*/


    @GET("rest/ItemsService/videos")
    Observable<VideoEntity> getLolVideoUrl(@QueryMap Map<String, String> params);
}
