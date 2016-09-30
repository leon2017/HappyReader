package com.leonwang.app.chinashop.ui.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.adapter.ZhiShuAdapter;
import com.leonwang.app.chinashop.base.RxLazyBaseFragment;
import com.leonwang.app.chinashop.db.dao.CityDao;
import com.leonwang.app.chinashop.db.dao.bean.City;
import com.leonwang.app.chinashop.entity.WeatherMZEntity;
import com.leonwang.app.chinashop.net.RetrofitHelper;
import com.leonwang.app.chinashop.ui.activity.CityLocationActivity;
import com.leonwang.app.chinashop.utils.GpsUtil;
import com.leonwang.app.chinashop.utils.LogUtils;
import com.leonwang.app.chinashop.utils.ScreenUtil;
import com.leonwang.app.chinashop.utils.TextUtil;
import com.leonwang.app.chinashop.utils.ToastUtils;
import com.leonwang.app.chinashop.widget.AqiView;
import com.leonwang.app.chinashop.widget.HourForeCastView;
import com.leonwang.app.chinashop.widget.MyListView;
import com.leonwang.app.chinashop.widget.SunRiseView;
import com.leonwang.app.chinashop.widget.WeekForecastView;
import com.leonwang.app.chinashop.widget.WindForecastView;
import com.leonwang.app.chinashop.widget.WindmillView;
import com.leonwang.app.chinashop.widget.weather.SkyView;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 当前类注释：天气
 * Author :LeonWang
 * Created  2016/9/22.13:18
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class DeveloperFragment extends RxLazyBaseFragment implements BDLocationListener {

    @BindView(R.id.myWeatherView)
    SkyView mSkyView;
    @BindView(R.id.tv_topCity)
    TextView mCurrentAreaTv;
    @BindView(R.id.toolbar)
    RelativeLayout mToolbar;
    @BindView(R.id.tv_updateTime)
    TextView mUpdateTimeTv;
    @BindView(R.id.tv_RTTemp)
    TextView mRealTempTv;
    @BindView(R.id.tv_degree)
    TextView mTvDegree;
    @BindView(R.id.tv_RTTypeAndRealFeel)
    TextView mWeatherAndFeelTemp;
    @BindView(R.id.tv_aqi)
    TextView mTvAqi;
    @BindView(R.id.weekForecast)
    WeekForecastView weekForeCastView;
    @BindView(R.id.first_show_rl)
    RelativeLayout mFirstShowRl;
    @BindView(R.id.wind_forecast)
    WindForecastView windForecastView;
    @BindView(R.id.hourForecast)
    HourForeCastView hourForeCastView;
    @BindView(R.id.windViewBig)
    WindmillView windViewBig;
    @BindView(R.id.windViewSmall)
    WindmillView windViewSmall;
    @BindView(R.id.tv_windDire)
    TextView mWindDegreeTv;
    @BindView(R.id.tv_windSpeed)
    TextView mWindLevelTv;
    @BindView(R.id.pb_humidity)
    ProgressBar progressBar;
    @BindView(R.id.tv_humidity)
    TextView mShiduTv;
    @BindView(R.id.view_aqi)
    AqiView mAqi;
    @BindView(R.id.tv_aqiQuality)
    TextView mRealAqiTv;
    @BindView(R.id.tv_pm25)
    TextView mPm2_5Tv;
    @BindView(R.id.tv_pm10)
    TextView mPm10Tv;
    @BindView(R.id.tv_so2)
    TextView mSo2Tv;
    @BindView(R.id.tv_no2)
    TextView mNo2Tv;
    @BindView(R.id.ll_aqi)
    LinearLayout mLlAqi;
    @BindView(R.id.view_sun)
    SunRiseView mSunRiseView;
    @BindView(R.id.lv_livingIndex)
    MyListView mZhishuLv;
    @BindView(R.id.ll_livingIndex)
    LinearLayout mLlLivingIndex;
    @BindView(R.id.content_mains)
    ScrollView contentMian;
    @BindView(R.id.refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tv_changeCity)
    TextView mTVChangeCity;


    private CityDao cityDao;
    private String weatherID = "101190501";
    private boolean openOrClose = false;
    private ZhiShuAdapter mZhiShuAdapter;
    private List<WeatherMZEntity.IndexesBean> zhishuList;
    private City mCity;
    private WeatherMZEntity mWeatherMZEntity;

    public static DeveloperFragment newInstance(String param4) {
        DeveloperFragment developerFragment = new DeveloperFragment();
        Bundle args = new Bundle();
        args.putString("args4", param4);
        developerFragment.setArguments(args);
        return developerFragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.content_main;
    }

    @SuppressLint({"NewApi", "ClickableViewAccessibility"})
    @Override
    protected void finishCreateView(Bundle savedInstanceState) {
        //注册事件
        EventBus.getDefault().register(this);
        cityDao = new CityDao(getApplicationContext());
        contentMian.setVisibility(View.INVISIBLE);
        mWeatherMZEntity = new WeatherMZEntity();
        mCurrentAreaTv.setText("正在刷新");
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               lazyLoad();
            }
        });
        TypedArray actionbarSizeTypedArray = getActivity().obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        int h = (int) actionbarSizeTypedArray.getDimension(0, 0);
        mFirstShowRl.getLayoutParams().height = ScreenUtil.getScreenHeight(getApplicationContext()) - h - ScreenUtil.getStatusBarHeight(getApplicationContext());
        isPrepared = true;
        setWind();
        setZhiShu();
        lazyLoad();
        initChangeCity();
    }

    /**
     * 初始化风速
     */
    private void setWind() {
        mSunRiseView.setSunRiseDownTime("05:00", "18:46");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    windViewBig.refreshView();
                    windViewSmall.refreshView();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    private void setZhiShu() {
        zhishuList = new ArrayList<>();
        mZhiShuAdapter = new ZhiShuAdapter(zhishuList, getSupportActivity());
        mZhishuLv.setAdapter(mZhiShuAdapter);
    }

    @Override
    protected void lazyLoad() {

        //开启6.0+全选
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //判断是否拥有权限
            if (getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && getApplicationContext().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    ) {
                initParam();
            } else {
                getPerimissons();
            }
        } else {
            initParam();
        }

    }

    private void initParam() {
        GpsUtil gpsUtil = new GpsUtil(getApplicationContext(), this);
        gpsUtil.start();
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        if (null != bdLocation && bdLocation.getLocType() != BDLocation.TypeServerError) {
            Log.d("aaa", bdLocation.getCity() + bdLocation.getDistrict());
            String areaName = TextUtil.getFormatArea(bdLocation.getDistrict());
            String cityName = TextUtil.getFormatArea(bdLocation.getCity());
            LogUtils.d("---------地址---------" + areaName + cityName);
            mCity = cityDao.getCityByCityAndArea(cityName, areaName);
            if (mCity == null) {
                mCity = cityDao.getCityByCityAndArea(cityName, cityName);
                if (mCity == null) {
                    //TODO 此处定位失败，跳转到页面选择页面
                    refreshStop();
                    return;
                }
            }
            getNetData(mCity.getWeatherId(), areaName + "·" + cityName);
        } else if (bdLocation.getLocType() == BDLocation.TypeServerError
                || bdLocation.getLocType() == BDLocation.TypeNetWorkException
                || bdLocation.getLocType() == BDLocation.TypeCriteriaException) {
            //TODO 此处定位失败，跳转到页面选择页面
            refreshStop();
            return;
        }

    }

    private void getNetData(String weatherIDs, String city) {
        weatherID = weatherIDs;
//        mCurrentAreaTv.setText(city);
        //获取实时天气
        getNowWeather();

    }

    private void getNowWeather() {
        RetrofitHelper.getMZWeatherApi()
                .getMZWeather(weatherID)
                .compose(this.<WeatherMZEntity>bindToLifecycle())
                .flatMap(new Func1<WeatherMZEntity, Observable<?>>() {
                    @Override
                    public Observable<?> call(WeatherMZEntity weatherMZEntity) {
                        //TODO:这里可以做一些需求处理
                        mWeatherMZEntity = weatherMZEntity;
                        return Observable.just("onNext");
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        //加载数据处理
                        doSetNowWeatherData();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        refreshStop();
                    }
                });
    }

    private void doSetNowWeatherData() {
        contentMian.setVisibility(View.VISIBLE);
        refreshStop();
        WeatherMZEntity.RealtimeBean realtime = mWeatherMZEntity.getRealtime();
        WeatherMZEntity.Pm25Bean pm25 = mWeatherMZEntity.getPm25();
        List<WeatherMZEntity.WeathersBean> weathers = mWeatherMZEntity.getWeathers();
        //24小时
        List<WeatherMZEntity.WeatherDetailsInfoBean.Weather24HoursDetailsInfosBean> weather24Hours
                = mWeatherMZEntity.getWeatherDetailsInfo().getWeather24HoursDetailsInfos();
        List<WeatherMZEntity.IndexesBean> zhishu = mWeatherMZEntity.getIndexes();

        mCurrentAreaTv.setText(mWeatherMZEntity.getCity() + "·" + mWeatherMZEntity.getProvinceName());
        mSkyView.setWeather(realtime.getWeather() + "");
        swipeRefreshLayout.setColorSchemeColors(mSkyView.getBackGroundColor());
        mRealTempTv.setText(realtime.getTemp() + "");
        //2016-09-30 10:00:00
        mUpdateTimeTv.setText(
                String.format(getResources().getString(R.string.activity_home_refresh_time), realtime.getTime().split(" ")[1].substring(0, 5))
        );
        mWeatherAndFeelTemp.setText(
                String.format(getResources().getString(R.string.activity_home_type_and_real_feel_temp),
                        realtime.getWeather(), realtime.getWD() + realtime.getWS() + "")
        );
        mRealAqiTv.setText("空气" + pm25.getQuality() + " " + pm25.getAqi());
        //周报&&时报
        weekForeCastView.setForeCasts(weathers);
        hourForeCastView.setHourForeCasts(weather24Hours);
        windForecastView.setForeCasts(weathers);
        //风速湿度
        windViewBig.setWindSpeedDegree(Integer.parseInt(realtime.getWS().replace("级", "")));
        windViewSmall.setWindSpeedDegree(Integer.parseInt(realtime.getWS().replace("级", "")));
        mWindDegreeTv.setText(realtime.getWD());
        mWindLevelTv.setText(realtime.getWS());
        progressBar.setProgress(realtime.getSD());
        mShiduTv.setText(realtime.getSD() + "");
        //空气
        mAqi.setProgressAndLabel(pm25.getAqi(), "空气" + pm25.getQuality());
        mPm2_5Tv.setText(pm25.getPm25() + " μg/m³");
        mPm10Tv.setText(pm25.getPm10() + " μg/m³");
        mSo2Tv.setText(pm25.getSo2() + " μg/m³");
        mNo2Tv.setText(pm25.getNo2() + " μg/m³");

        //日出-----暂无数据
//        mSunRiseView.setSunRiseDownTime(realWeather.getSunrise(), realWeather.getSundown());

        //指数
        zhishuList.clear();
        zhishuList.addAll(zhishu);
        mZhiShuAdapter.notifyDataSetChanged();
        contentMian.smoothScrollTo(0, 0);

    }

    protected void refreshStop() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public void getPerimissons() {
        Acp.getInstance(getSupportActivity()).request(new AcpOptions.Builder()
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.ACCESS_FINE_LOCATION
                                , Manifest.permission.ACCESS_COARSE_LOCATION
                        )
                        .build(),
                new AcpListener() {
                    @Override
                    public void onGranted() {
                        //权限被允许
                        initParam();
                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        //TODO 此处定位失败，跳转到页面选择页面
                        refreshStop();
                        ToastUtils.showToast(getApplicationContext(), "相关权限被拒绝");
                    }
                });
    }


    /*
    * 切换城市
    * */
    private void initChangeCity() {

        mTVChangeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getSupportActivity(), CityLocationActivity.class));
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消注册事件
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void cityEvent(City city) {
        getNetData(city.getWeatherId(),city.getCityName());
    }
}
