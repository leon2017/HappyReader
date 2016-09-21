package com.leonwang.app.chinashop.ui;

import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.base.RxAppCompatBaseActivity;

import butterknife.BindView;

public class MainActivity extends RxAppCompatBaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.layFrame)
    FrameLayout mLayFrame;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.activity_main)
    LinearLayout mActivityMain;



    private String TAB[] = {"资讯", "视频", "知乎", "开发者"};
    private String TITLE;
    private int TAB_COLOR[] = {R.color.colorPrimary,
            R.color.slategray,
            R.color.goldyellow,
            R.color.mediumslateblue};
    private int mToolBarBG = R.color.colorPrimary;
    private Bundle mSavedInstanceState;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mSavedInstanceState = savedInstanceState;
        initNavigationBar();
    }

    private void initNavigationBar() {
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.main_icon_news, TAB[0]).setActiveColorResource(TAB_COLOR[0]))
                .addItem(new BottomNavigationItem(R.mipmap.main_icon_vedio, TAB[1]).setActiveColorResource(TAB_COLOR[1]))
                .addItem(new BottomNavigationItem(R.mipmap.main_icon_zhihu, TAB[2]).setActiveColorResource(TAB_COLOR[2]))
                .addItem(new BottomNavigationItem(R.mipmap.main_icon_code, TAB[3]).setActiveColorResource(TAB_COLOR[3]))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(new MyTabListener());

    }

    @Override
    protected void initToolBar() {
        TITLE = "资讯";
        mToolbar.setNavigationContentDescription(TITLE);
        mToolbar.setTitle(TITLE);
        mToolbar.setNavigationIcon(R.mipmap.toolbar_logo);
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setDisplayUseLogoEnabled(false);
            mActionBar.setDisplayShowTitleEnabled(true);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onHandlerMessage(Message msg) {

    }

    //tab切换
    public class MyTabListener implements BottomNavigationBar.OnTabSelectedListener {

        @Override
        public void onTabSelected(int position) {
            TITLE = TAB[position];
            mToolBarBG = TAB_COLOR[position];
            switch (position) {
                case 0://资讯
                    break;
                case 1://视频
                    break;
                case 2://知乎
                    break;
                case 3://开发
                    break;
            }
            updateToolbar();
        }

        @Override
        public void onTabUnselected(int position) {

        }

        @Override
        public void onTabReselected(int position) {

        }
    }

    private void updateToolbar() {
        mToolbar.setTitle(TITLE);
        mToolbar.setBackgroundResource(mToolBarBG);
        onPostCreate(mSavedInstanceState);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.mTintManager.setTintColor(this.getResources().getColor(mToolBarBG));
    }
}
