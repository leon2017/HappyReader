package com.leonwang.app.chinashop.net;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.leonwang.app.chinashop.config.App;
import com.leonwang.app.chinashop.net.api.LolVedioService;
import com.leonwang.app.chinashop.net.api.TopNewsService;
import com.leonwang.app.chinashop.net.api.WeatherAqiService;
import com.leonwang.app.chinashop.net.api.WeatherDay5Service;
import com.leonwang.app.chinashop.net.api.WeatherNowService;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 当前类注释：retrofit帮助类
 * Author :LeonWang
 * Created  2016/9/21.9:59
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class RetrofitHelper {


    private static OkHttpClient mOkHttpClient;

    //聚合数据base url
    public static final String JUHE_BASE_URL = "http://v.juhe.cn/";
    //LOL视频
    public static final String LOL_BASE_URL = "http://lol.zhangyoubao.com/apis/";
    //小米天气
    public static final String XIAOMI_WEATHER = "http://weatherapi.market.xiaomi.com/";


    static{
        initOkhttpClient();
    }

    //获取小米天气实时数据
    public static WeatherNowService getNowWeatherApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(XIAOMI_WEATHER)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(WeatherNowService.class);
    }

    //获取小米未来五天的天气数据
    public static WeatherDay5Service getDay5WeatherApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(XIAOMI_WEATHER)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(WeatherDay5Service.class);
    }

    //获取小米天气实时的指数
    public static WeatherAqiService getAqiWeatherApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(XIAOMI_WEATHER)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(WeatherAqiService.class);
    }

    //获取新闻头条api
    public static TopNewsService getTopNewsApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JUHE_BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(TopNewsService.class);
    }

    //获取LOL视频api
    public static LolVedioService getLolVedioApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LOL_BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(LolVedioService.class);
    }

    private static void initOkhttpClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (mOkHttpClient == null) {
                    //设置http缓存
                    Cache cache = new Cache(new File(App.getInstance()
                            .getCacheDir(), "HttpCache"), 1024 * 1024 * 100);
                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addInterceptor(interceptor)
                            .addNetworkInterceptor(new StethoInterceptor())
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }
}
