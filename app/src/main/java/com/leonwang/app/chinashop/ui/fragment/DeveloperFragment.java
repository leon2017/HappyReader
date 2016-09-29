package com.leonwang.app.chinashop.ui.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.adapter.ZhiShuAdapter;
import com.leonwang.app.chinashop.base.RxLazyBaseFragment;
import com.leonwang.app.chinashop.db.dao.CityDao;
import com.leonwang.app.chinashop.db.dao.bean.City;
import com.leonwang.app.chinashop.db.dao.greendao.Alarms;
import com.leonwang.app.chinashop.db.dao.greendao.Aqi;
import com.leonwang.app.chinashop.db.dao.greendao.RealWeather;
import com.leonwang.app.chinashop.db.dao.greendao.Zhishu;
import com.leonwang.app.chinashop.db.manager.WeatherInfo;
import com.leonwang.app.chinashop.db.manager.WeatherManager;
import com.leonwang.app.chinashop.entity.WeatherNowEntity;
import com.leonwang.app.chinashop.net.RetrofitHelper;
import com.leonwang.app.chinashop.utils.ConstantUtils;
import com.leonwang.app.chinashop.utils.GpsUtil;
import com.leonwang.app.chinashop.utils.LogUtils;
import com.leonwang.app.chinashop.utils.ScreenUtil;
import com.leonwang.app.chinashop.utils.TextUtil;
import com.leonwang.app.chinashop.widget.AqiView;
import com.leonwang.app.chinashop.widget.HourForeCastView;
import com.leonwang.app.chinashop.widget.MyListView;
import com.leonwang.app.chinashop.widget.SunRiseView;
import com.leonwang.app.chinashop.widget.WeekForecastView;
import com.leonwang.app.chinashop.widget.WindForecastView;
import com.leonwang.app.chinashop.widget.WindmillView;
import com.leonwang.app.chinashop.widget.weather.SkyView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 当前类注释：开发
 * Author :LeonWang
 * Created  2016/9/22.13:18
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class DeveloperFragment extends RxLazyBaseFragment implements BDLocationListener{

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


    private CityDao cityDao ;
    private String weatherID = "101190501";
    private boolean openOrClose = false;

    private WeatherManager weatherManager;
    private ZhiShuAdapter mZhiShuAdapter;
    private List<Zhishu> zhishuList;
    private WeatherNowEntity.WeatherinfoEntity mWeatherinfo;
    private City mCity;

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
        cityDao = new CityDao(getApplicationContext());
        weatherManager = new WeatherManager(getSupportActivity());
//        contentMian.setVisibility(View.INVISIBLE);
        //6.0权限请求
       // ActivityCompat.requestPermissions(getSupportActivity(), mPermissionList, 100);

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
                getNetData(mCity.getWeatherId(),mCity.getAreaName()+"·"+mCity.getCityName());
            }
        });

        TypedArray actionbarSizeTypedArray = getActivity().obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        int h = (int) actionbarSizeTypedArray.getDimension(0, 0);
        mFirstShowRl.getLayoutParams().height = ScreenUtil.getScreenHeight(getApplicationContext()) - h - ScreenUtil.getStatusBarHeight(getApplicationContext());
        isPrepared = true;
        setWind();
        setZhiShu();
        lazyLoad();
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getPermission(Manifest.permission.ACCESS_FINE_LOCATION);
        } else {
            initParam();
        }
    }

    protected void getPermission(final String permission) {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{permission}, 0);
        } else {
            initParam();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        initParam();
    }

    private void initParam() {
        /*UseArea useArea = weatherManager.queryMianUseArea();
        if (useArea == null) {
            GpsUtil gpsUtil = new GpsUtil(getApplicationContext(), this);
            gpsUtil.start();
        } else {
            weatherID = useArea.getAreaid();
            LogUtils.d("----------weatherID---------"+weatherID);
            mCurrentAreaTv.setText(useArea.getAreaName());
            refresh(true);
        }*/

        GpsUtil gpsUtil = new GpsUtil(getApplicationContext(), this);
        gpsUtil.start();
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        Log.d("aaa", bdLocation.getCity() + bdLocation.getDistrict());
        String areaName = TextUtil.getFormatArea(bdLocation.getDistrict());
        String cityName = TextUtil.getFormatArea(bdLocation.getCity());
        LogUtils.d("---------地址---------"+areaName+cityName);
        mCity = cityDao.getCityByCityAndArea(cityName, areaName);
        if (mCity == null) {
            mCity = cityDao.getCityByCityAndArea(cityName, cityName);
            if (mCity == null) {
                //TODO 此处定位失败，跳转到页面选择页面
                refreshStop();
                return;
            }
        }
        getNetData(mCity.getWeatherId(),areaName+"·"+cityName);
    }

    private void getNetData(String weatherIDs,String city) {
        weatherID = weatherIDs;
        mCurrentAreaTv.setText(city);
        //获取实时天气
        getNowWeather();

    }

    private void getNowWeather() {
        RetrofitHelper.getNowWeatherApi()
                .getNowWeather(weatherID)
                .compose(this.<WeatherNowEntity>bindToLifecycle())
                .flatMap(new Func1<WeatherNowEntity, Observable<?>>() {
                    @Override
                    public Observable<?> call(WeatherNowEntity weatherNowEntity) {
                        //TODO:这里可以做一些需求处理
                        mWeatherinfo = weatherNowEntity.getWeatherinfo();
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
        refreshStop();
        mSkyView.setWeather(mWeatherinfo.getWeather()+"");
        swipeRefreshLayout.setColorSchemeColors(mSkyView.getBackGroundColor());
//        mCurrentAreaTv.setText(mWeatherinfo.getCity()+"");
        mRealTempTv.setText(mWeatherinfo.getTemp() + "");
        mUpdateTimeTv.setText(
                String.format(getResources().getString(R.string.activity_home_refresh_time), mWeatherinfo.getTime())
        );
        mWeatherAndFeelTemp.setText(
                String.format(getResources().getString(R.string.activity_home_type_and_real_feel_temp),
                        mWeatherinfo.getWeather(), mWeatherinfo.getWD()+mWeatherinfo.getWS()+"")
        );

    }


    private void refresh(boolean useLocal) {
        weatherManager.refreshWeather(weatherID, useLocal, new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                contentMian.setVisibility(View.VISIBLE);
                swipeRefreshLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });

                if (msg.what == ConstantUtils.MSG_ERROR) {
                    Toast.makeText(getApplicationContext(), "刷新失败", Toast.LENGTH_SHORT).show();
                } else {
                    WeatherInfo weatherInfo = (WeatherInfo) msg.obj;
                    Aqi aqi = weatherInfo.getAqi();

                    //实时
                    RealWeather realWeather = weatherInfo.getRealWeather();
                    mSkyView.setWeather(realWeather.getWeatherCondition(), realWeather.getSunrise(), realWeather.getSundown());
                    swipeRefreshLayout.setColorSchemeColors(mSkyView.getBackGroundColor());
                    mCurrentAreaTv.setText(realWeather.getAreaName());
                    mRealTempTv.setText(realWeather.getTemp() + "");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
                    mUpdateTimeTv.setText(
                            String.format(getResources().getString(R.string.activity_home_refresh_time), simpleDateFormat.format(realWeather.getLastUpdate()))
                    );
                    mRealAqiTv.setText("空气" + aqi.getQuality() + " " + aqi.getAqi());
                    mWeatherAndFeelTemp.setText(
                            String.format(getResources().getString(R.string.activity_home_type_and_real_feel_temp),
                                    realWeather.getWeatherCondition(), realWeather.getFeeltemp()+"")
                    );

                    //周报&&时报
                    weekForeCastView.setForeCasts(weatherInfo.getWeekForeCasts());
                    hourForeCastView.setHourForeCasts(weatherInfo.getHourForeCasts());
                    windForecastView.setForeCasts(weatherInfo.getWeekForeCasts());

                    //风速湿度
                    windViewBig.setWindSpeedDegree(Integer.parseInt(realWeather.getFj().replace("级", "")));

                    windViewSmall.setWindSpeedDegree(Integer.parseInt(realWeather.getFj().replace("级", "")));
                    mWindDegreeTv.setText(realWeather.getFx());
                    mWindLevelTv.setText(realWeather.getFj());
                    progressBar.setProgress(realWeather.getShidu());
                    mShiduTv.setText(realWeather.getShidu() + "");
                    //空气
                    mAqi.setProgressAndLabel(aqi.getAqi(), "空气" + aqi.getQuality());
                    mPm2_5Tv.setText(aqi.getPm2_5() + " μg/m³");
                    mPm10Tv.setText(aqi.getPm10() + " μg/m³");
                    mSo2Tv.setText(aqi.getSo2() + " μg/m³");
                    mNo2Tv.setText(aqi.getNo2() + " μg/m³");
                    //日出
                    mSunRiseView.setSunRiseDownTime(realWeather.getSunrise(), realWeather.getSundown());

                    //指数
                    zhishuList.clear();
                    zhishuList.addAll(weatherInfo.getZhishu());
                    mZhiShuAdapter.notifyDataSetChanged();
                    contentMian.smoothScrollTo(0, 0);

                    //预警
                    final Alarms alarms = weatherInfo.getAlarms();
                    if (alarms != null) {
                        mRealAqiTv.setClickable(true);
                        mRealAqiTv.setText(alarms.getAlarmLevelNoDesc() + alarms.getAlarmTypeDesc());
                        mRealAqiTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                /*Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
                                intent.putExtra("alarminfo", alarms);
                                startActivity(intent);*/
                            }
                        });
                    } else
                        mRealAqiTv.setClickable(false);
                }
            }
        });
    }

    //可以将一下代码加到你的MainActivity中，或者在任意一个需要调用分享功能的activity当中
    String[] mPermissionList = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_LOGS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.SET_DEBUG_APP,
            Manifest.permission.SYSTEM_ALERT_WINDOW,
    };

    protected void refreshStop() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

}
