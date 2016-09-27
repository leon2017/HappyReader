package com.leonwang.app.chinashop.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.adapter.VedioPagerAdapter;
import com.leonwang.app.chinashop.base.RxLazyBaseFragment;
import com.leonwang.app.chinashop.utils.ConstantUtils;
import com.leonwang.app.chinashop.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 当前类注释：视频
 * Author :LeonWang
 * Created  2016/9/22.13:17
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class VideoFragment extends RxLazyBaseFragment {


    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabs;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private List<String> mTabTitleList;
    private VedioPagerAdapter mVedioPagerAdapter;

    public static VideoFragment newInstance(String param2) {
        VideoFragment videoFragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putString("args2", param2);
        videoFragment.setArguments(args);
        return videoFragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_video;
    }

    @SuppressLint({"NewApi", "ClickableViewAccessibility"})
    @Override
    protected void finishCreateView(Bundle savedInstanceState) {
        if (mTabTitleList == null || mTabTitleList.isEmpty()) {
            mTabTitleList = new ArrayList<>();
            ConstantUtils.LolType[] lolTypes = ConstantUtils.LolType.values();
            if (lolTypes.length > 0) {
                for (int i = 0; i < lolTypes.length; i++) {
                    mTabTitleList.add(lolTypes[i].getTitle());
                    LogUtils.d("-----------视频tab集合---------"+mTabTitleList.get(i));
                }
            }
        }
        mVedioPagerAdapter = new VedioPagerAdapter(getChildFragmentManager(),mTabTitleList);
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(mVedioPagerAdapter);
        mSlidingTabs.setViewPager(mViewPager);
    }

    @Override
    protected void lazyLoad() {

    }

}
