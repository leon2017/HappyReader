package com.leonwang.app.chinashop.net.api;

import com.leonwang.app.chinashop.entity.WeatherAqiEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 当前类注释：小米天气实时指数
 * Author :LeonWang
 * Created  2016/9/29.17:05
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public interface WeatherAqiService {

    @GET("wtr/data/aqi")
    Observable<WeatherAqiEntity> getAqiWeather(@Query("city_id") String cityId);
}
