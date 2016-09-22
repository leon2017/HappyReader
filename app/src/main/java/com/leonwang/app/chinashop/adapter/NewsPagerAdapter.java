package com.leonwang.app.chinashop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.leonwang.app.chinashop.config.FragmentFactory;
import com.leonwang.app.chinashop.ui.fragment.itemFragment.NewsItemFragment;
import com.leonwang.app.chinashop.utils.ConstantUtils;

import java.util.List;

/**
 * 当前类注释：首页新闻模块
 * Author :LeonWang
 * Created  2016/9/22.15:04
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class NewsPagerAdapter extends FragmentPagerAdapter{
    private List<String> mTabTitleList;

    public NewsPagerAdapter(FragmentManager fm,List<String> list) {
        super(fm);
        mTabTitleList = list;
    }

    @Override
    public Fragment getItem(int position) {
        NewsItemFragment fragment =
                (NewsItemFragment) FragmentFactory.creatNewsFragment(mTabTitleList.get(position));
        ConstantUtils.ENewsType[] newsTypes = ConstantUtils.ENewsType.values();
        fragment.setNewsType(newsTypes[position]);
        return fragment;
    }

    @Override
    public int getCount() {
        return mTabTitleList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitleList.get(position);
    }
}
