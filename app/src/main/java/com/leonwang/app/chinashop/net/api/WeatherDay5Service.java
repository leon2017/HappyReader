package com.leonwang.app.chinashop.net.api;

import com.leonwang.app.chinashop.entity.WeatherDay5Entity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 当前类注释：小米天气未来五天数据
 * Author :LeonWang
 * Created  2016/9/29.16:59
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public interface WeatherDay5Service {

    @GET("wtr-v2/temp/forecast")
    Observable<WeatherDay5Entity> getDay5Weather(@Query("cityId") String cityId);
}
