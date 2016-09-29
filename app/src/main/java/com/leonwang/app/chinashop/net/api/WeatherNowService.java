package com.leonwang.app.chinashop.net.api;

import com.leonwang.app.chinashop.entity.WeatherNowEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 当前类注释：小米天气实时数据
 * Author :LeonWang
 * Created  2016/9/29.17:02
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public interface WeatherNowService {

    @GET("wtr-v2/temp/realtime")
    Observable<WeatherNowEntity> getNowWeather(@Query("cityId") String cityId);
}
