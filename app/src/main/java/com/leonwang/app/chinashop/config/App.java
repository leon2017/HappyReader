package com.leonwang.app.chinashop.config;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.stetho.Stetho;
import com.leonwang.app.chinashop.utils.ConstantUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 当前类注释：application
 * Author :LeonWang
 * Created  2016/9/19.17:32
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class App extends Application {

    private static Context appContext;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appContext = getApplicationContext();
        init();
    }

    private void init() {
        //初始化Stetho调试工具
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }

    public static App getInstance() {
        return instance;
    }

    public Context getAppContext() {
        return appContext;
    }

    public List<String> getStringArray(int resId) {
        return Arrays.asList(getAppContext().getResources().getStringArray(resId));
    }


    /**
     * 封装图片请求
     *
     * @param uri 图片地址
     * @param iv  iamgeView控件
     */
    public void simpleDisplayImage(String uri, ImageView iv) {
        Glide.with(appContext)
                .load(uri)
                .centerCrop()
                .into(iv);
    }

    /**
     * 封装图片请求
     *
     * @param uri               图片地址
     * @param iv                控件
     * @param resId             加载失败显示的图片---默认加载参数为0
     * @param isSkipMemoryCache 内存缓存策略
     * @param diskCacheType     磁盘缓存策略
     */
    public void displayImage(String uri, ImageView iv, int resId,
                             boolean isSkipMemoryCache, DiskCacheStrategy diskCacheType) {
        Glide.with(appContext)
                .load(uri)
                .placeholder(ConstantUtils.LOADING_IMAGE_ID)
                .error(resId != 0 ? resId : ConstantUtils.ERROR_IMAGE_ID)
                .centerCrop()//填充
                .skipMemoryCache(isSkipMemoryCache)
                .diskCacheStrategy(diskCacheType)
                .into(iv);
    }

    public void displayImage(String uri, ImageView iv) {
        displayImage(uri, iv, 0, false, DiskCacheStrategy.ALL);
    }

    public void displayImage(String uri, ImageView iv, int redId) {
        displayImage(uri, iv, redId, false, DiskCacheStrategy.ALL);
    }

    public void displayImage(String uri, ImageView iv, boolean isSkipMemoryCache) {
        displayImage(uri, iv, 0, isSkipMemoryCache, DiskCacheStrategy.ALL);
    }

    public void displayImage(String uri, ImageView iv, DiskCacheStrategy diskCacheType) {
        displayImage(uri, iv, 0, false, diskCacheType);
    }

}
