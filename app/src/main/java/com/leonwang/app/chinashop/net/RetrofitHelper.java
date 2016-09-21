package com.leonwang.app.chinashop.net;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.leonwang.app.chinashop.config.App;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 当前类注释：retrofit帮助类
 * Author :LeonWang
 * Created  2016/9/21.9:59
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class RetrofitHelper {

    private static OkHttpClient mOkHttpClient;

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
                            .writeTimeout(20,TimeUnit.SECONDS)
                            .readTimeout(20,TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }
}
