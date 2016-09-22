package com.leonwang.app.chinashop.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.adapter.NewsPagerAdapter;
import com.leonwang.app.chinashop.base.RxLazyBaseFragment;
import com.leonwang.app.chinashop.utils.ConstantUtils;
import com.leonwang.app.chinashop.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 当前类注释：资讯
 * Author :LeonWang
 * Created  2016/9/22.13:16
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class NewsFragment extends RxLazyBaseFragment {


    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabs;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private List<String> mTabTitleList;
    private NewsPagerAdapter mNewsPagerAdapter;

    public static NewsFragment newInstance(String param1) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString("args1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_news;
    }

    @SuppressLint({"NewApi", "ClickableViewAccessibility"})
    @Override
    protected void finishCreateView(Bundle savedInstanceState) {
        if (mTabTitleList == null || mTabTitleList.isEmpty()) {
            mTabTitleList = new ArrayList<>();
            ConstantUtils.ENewsType[] eNewsTypes = ConstantUtils.ENewsType.values();
            if (eNewsTypes.length > 0) {
                for (int i = 0; i < eNewsTypes.length; i++) {
                    mTabTitleList.add(eNewsTypes[i].getTitle());
                    LogUtils.d("-----------顶部tab集合---------------"+mTabTitleList.get(i));
                }
            }
        }

       /* if (mNewsPagerAdapter == null) {
            mNewsPagerAdapter = new NewsPagerAdapter(getChildFragmentManager(),mTabTitleList);
        }*/

        mNewsPagerAdapter = new NewsPagerAdapter(getChildFragmentManager(),mTabTitleList);
        mViewPager.setAdapter(mNewsPagerAdapter);
        mSlidingTabs.setViewPager(mViewPager);
    }

    @Override
    protected void lazyLoad() {

    }

}
