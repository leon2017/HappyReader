package com.leonwang.app.chinashop.net.api;

import com.leonwang.app.chinashop.entity.WeatherMZEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 当前类注释：魅族天气
 * Author :LeonWang
 * Created  2016/9/30.10:06
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public interface WeatherMZService {

    @GET("/1.0/weather/{cityid}.json")
    Observable<WeatherMZEntity> getMZWeather(@Path("cityid")String cityid);
}
