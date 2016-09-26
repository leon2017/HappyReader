package com.leonwang.app.chinashop.net.api;

import com.leonwang.app.chinashop.entity.TopNewsEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;


/**
 * 当前类注释：新闻头条数据请求
 * Author :LeonWang
 * Created  2016/9/23.9:52
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public interface TopNewsService {

    //---->toutiao/index
    @FormUrlEncoded
    @POST("toutiao/index")
    Observable<TopNewsEntity> getNews(@Field("type")String type, @Field("key") String data);

}
