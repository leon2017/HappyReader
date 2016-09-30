package com.leonwang.app.chinashop.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.adapter.CityListAdapter;
import com.leonwang.app.chinashop.adapter.ResultListAdapter;
import com.leonwang.app.chinashop.base.RxAppCompatBaseActivity;
import com.leonwang.app.chinashop.db.dao.CityDao;
import com.leonwang.app.chinashop.db.dao.DBManager;
import com.leonwang.app.chinashop.db.dao.LocateState;
import com.leonwang.app.chinashop.db.dao.bean.City;
import com.leonwang.app.chinashop.rx.EventBusUtils;
import com.leonwang.app.chinashop.utils.GpsUtil;
import com.leonwang.app.chinashop.utils.LogUtils;
import com.leonwang.app.chinashop.utils.TextUtil;
import com.leonwang.app.chinashop.utils.ToastUtils;
import com.leonwang.app.chinashop.widget.SideLetterBar;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;

import java.util.List;

import butterknife.BindView;


/**
 * 当前类注释：选择城市
 * Author :LeonWang
 * Created  2016/9/30.13:16
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class CityLocationActivity extends RxAppCompatBaseActivity implements View.OnClickListener ,BDLocationListener{

    @BindView(R.id.et_search)
    EditText searchBox;
    @BindView(R.id.iv_search_clear)
    ImageView clearBtn;
    @BindView(R.id.listview_all_city)
    ListView mListView;
    @BindView(R.id.tv_letter_overlay)
    TextView overlay;
    @BindView(R.id.side_letter_bar)
    SideLetterBar mLetterBar;
    @BindView(R.id.listview_search_result)
    ListView mResultListView;
    @BindView(R.id.empty_view)
    LinearLayout emptyView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private CityListAdapter mCityAdapter;
    private ResultListAdapter mResultAdapter;
    private List<City> mAllCities;
    private DBManager dbManager;
    private Context mContext;
    private CityDao cityDao;
    private City mCity;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_city_list;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        cityDao = new CityDao(getApplicationContext());
        mContext = this;
    }

    @Override
    protected void initToolBar() {
        mToolbar.setNavigationContentDescription("城市选择");
        mToolbar.setTitle("城市选择");
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setDisplayUseLogoEnabled(true);
            mActionBar.setDisplayShowTitleEnabled(true);
        }

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void initData() {
        dbManager = new DBManager(this);
        dbManager.copyDBFile();
        mAllCities = dbManager.getAllCities();
        mCityAdapter = new CityListAdapter(this, mAllCities);
        mCityAdapter.setOnCityClickListener(new CityListAdapter.OnCityClickListener() {
            @Override
            public void onCityClick(String name) {
                back(name);
            }

            @Override
            public void onLocateClick() {
                Log.e("onLocateClick", "重新定位...");
                mCityAdapter.updateLocateState(LocateState.LOCATING, null);
                initParam();
            }

            @Override
            public void onSelected(String cityName) {
                back(cityName);
            }
        });

        mResultAdapter = new ResultListAdapter(this, null);
        initEvent();
        initLocation();
    }

    private void initLocation() {
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
        GpsUtil gpsUtil = new GpsUtil(mContext, this);
        gpsUtil.start();
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        if (null != bdLocation && bdLocation.getLocType() != BDLocation.TypeServerError) {
            Log.d("aaa", bdLocation.getCity() + bdLocation.getDistrict());
            String areaName = TextUtil.getFormatArea(bdLocation.getDistrict());
            String cityName = TextUtil.getFormatArea(bdLocation.getCity());
            LogUtils.d("---------地址---------" + areaName + cityName);
            String location = TextUtil.getFormatArea(areaName);
            mCityAdapter.updateLocateState(LocateState.SUCCESS, areaName);
        } else if (bdLocation.getLocType() == BDLocation.TypeServerError
                || bdLocation.getLocType() == BDLocation.TypeNetWorkException
                || bdLocation.getLocType() == BDLocation.TypeCriteriaException) {
            //定位失败
            mCityAdapter.updateLocateState(LocateState.FAILED, null);
            return;
        }
    }

    private void initEvent() {
        mListView.setAdapter(mCityAdapter);
        mLetterBar.setOverlay(overlay);
        mLetterBar.setOnLetterChangedListener(new SideLetterBar.OnLetterChangedListener() {
            @Override
            public void onLetterChanged(String letter) {
                int position = mCityAdapter.getLetterPosition(letter);
                mListView.setSelection(position);
            }
        });

        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                String keyword = s.toString();
                if (TextUtils.isEmpty(keyword)) {
                    clearBtn.setVisibility(View.GONE);
                    emptyView.setVisibility(View.GONE);
                    mResultListView.setVisibility(View.GONE);
                } else {
                    clearBtn.setVisibility(View.VISIBLE);
                    mResultListView.setVisibility(View.VISIBLE);
                    List<City> result = dbManager.searchCity(keyword);
                    if (result == null || result.size() == 0) {
                        emptyView.setVisibility(View.VISIBLE);
                    } else {
                        emptyView.setVisibility(View.GONE);
                        mResultAdapter.changeData(result);
                    }
                }
            }
        });

        mResultListView.setAdapter(mResultAdapter);
        mResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                back2(mResultAdapter.getItem(position).getName());
            }
        });

        clearBtn.setOnClickListener(this);
    }

    @Override
    protected void onHandlerMessage(Message msg) {

    }

    private void back(String city){
        ToastUtils.showToast(this, "点击的城市：" + city);
        LogUtils.d("---------点击的城市-----------"+city);
        mCity = cityDao.getCityArea(city);
        if (mCity == null) {
            mCity = cityDao.getCityByCityAndArea(city, city);
            if (mCity == null) {
                //定位失败
                mCityAdapter.updateLocateState(LocateState.FAILED, null);
                return;
            }
        }
        //TODO 拿到id
        LogUtils.d("---------mCity-----------"+mCity.toString());
        EventBusUtils.post(mCity);
        finish();
    }

    private void back2(String city){
        ToastUtils.showToast(this, "点击的城市：" + city);
        LogUtils.d("---------点击的城市-----------"+city);
        mCity = cityDao.getCityArea(city);
        if (mCity == null) {
            mCity = cityDao.getCityByCityAndArea(city, city);
            if (mCity == null) {
                Toast.makeText(mContext,"尚未有该城市的天气记录",Toast.LENGTH_SHORT).show();
                return;
            }
        }
        //TODO 拿到id
        LogUtils.d("---------mCity-----------"+mCity.toString());
        EventBusUtils.post(mCity);
        finish();
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_search_clear:
                searchBox.setText("");
                clearBtn.setVisibility(View.GONE);
                emptyView.setVisibility(View.GONE);
                mResultListView.setVisibility(View.GONE);
                break;
        }
    }

    public void getPerimissons() {
        Acp.getInstance(this).request(new AcpOptions.Builder()
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
                        //TODO 此处定位失败，默认上海
//                        back("上海");
                        ToastUtils.showToast(getApplicationContext(), "相关权限被拒绝");
                    }
                });
    }


}
