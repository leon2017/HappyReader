package com.leonwang.app.chinashop.ui.activity;


import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.base.RxAppCompatBaseActivity;
import com.leonwang.app.chinashop.ui.fragment.DeveloperFragment;
import com.leonwang.app.chinashop.ui.fragment.NewsFragment;
import com.leonwang.app.chinashop.ui.fragment.VideoFragment;
import com.leonwang.app.chinashop.ui.fragment.ZhihuFragment;
import com.leonwang.app.chinashop.utils.LogUtils;
import com.leonwang.app.chinashop.utils.SnackBarUtils;

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

    //fragment
    private NewsFragment mNewsFragment;
    private VideoFragment mVideoFragment;
    private ZhihuFragment mZhihuFragment;
    private DeveloperFragment mDeveloperFragment;

    private String TAB[] = {"资讯", "视频", "知乎", "开发者"};
    private String TITLE;
    private int TAB_COLOR[] = {R.color.colorPrimary,
            R.color.slategray,
            R.color.goldyellow,
            R.color.mediumslateblue};
    private int mToolBarBG = R.color.colorPrimary;
    private Bundle mSavedInstanceState;
    private FragmentManager mFm;
    private long firstTime = 0;// 记录第一次按返回键的时间

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
        setDefaultFragment();
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

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mNewsFragment = NewsFragment.newInstance("资讯");
        transaction.replace(R.id.layFrame, mNewsFragment);
        transaction.commit();
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
            LogUtils.d("onTabSelected() called with: " + "position = [" + position + "]");
            TITLE = TAB[position];
            mToolBarBG = TAB_COLOR[position];
            if (null == mFm) {
                mFm = getSupportFragmentManager();
            }
            FragmentTransaction transaction = mFm.beginTransaction();
            if (null == transaction) {
                return;
            }
            switch (position) {
                case 0://资讯
                    hideFragment(transaction);
                    if (mNewsFragment == null) {
                        mNewsFragment = NewsFragment.newInstance(TAB[0]);
                        transaction.add(R.id.layFrame, mNewsFragment);
                    } else {
                        transaction.show(mNewsFragment);
                    }
//                    transaction.replace(R.id.layFrame, mNewsFragment);
                    break;
                case 1://视频
                    hideFragment(transaction);
                    if (mVideoFragment == null) {
                        mVideoFragment = VideoFragment.newInstance(TAB[1]);
                        transaction.add(R.id.layFrame, mVideoFragment);
                    } else {
                        transaction.show(mVideoFragment);
                    }
//                    transaction.replace(R.id.layFrame, mVideoFragment);
                    break;
                case 2://知乎
                    hideFragment(transaction);
                    if (mZhihuFragment == null) {
                        mZhihuFragment = ZhihuFragment.newInstance(TAB[2]);
                        transaction.add(R.id.layFrame, mZhihuFragment);
                    } else {
                        transaction.show(mZhihuFragment);
                    }
//                    transaction.replace(R.id.layFrame, mZhihuFragment);
                    break;
                case 3://开发
                    hideFragment(transaction);
                    if (mDeveloperFragment == null) {
                        mDeveloperFragment = DeveloperFragment.newInstance(TAB[3]);
                        transaction.add(R.id.layFrame, mDeveloperFragment);
                    } else {
                        transaction.show(mDeveloperFragment);
                    }
//                    transaction.replace(R.id.layFrame, mDeveloperFragment);
                    break;
            }
            transaction.addToBackStack(null);
            transaction.commit();
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

    private void hideFragment(FragmentTransaction transaction) {
        if (mNewsFragment != null) {
            transaction.hide(mNewsFragment);
        }
        if (mVideoFragment != null) {
            transaction.hide(mVideoFragment);
        }
        if (mZhihuFragment != null) {
            transaction.hide(mZhihuFragment);
        }
        if (mDeveloperFragment != null) {
            transaction.hide(mDeveloperFragment);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    SnackBarUtils.showSnackBar(mActivityMain, this.getString(R.string.back_app)).show();
                    firstTime = secondTime;
                    return true;
                } else {
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(0);
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
