package com.leonwang.app.chinashop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.leonwang.app.chinashop.config.FragmentFactory;
import com.leonwang.app.chinashop.ui.fragment.itemFragment.VideoItemFragment;
import com.leonwang.app.chinashop.utils.ConstantUtils;
import com.leonwang.app.chinashop.utils.LogUtils;

import java.util.List;

/**
 * 当前类注释：视频模块
 * Author :LeonWang
 * Created  2016/9/22.15:04
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class VedioPagerAdapter extends FragmentPagerAdapter{
    private List<String> mTabTitleList;

    public VedioPagerAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        mTabTitleList = list;
        LogUtils.d("----------------mTabTitleList长度--------------"+mTabTitleList.size());
    }

    @Override
    public Fragment getItem(int position) {
        VideoItemFragment fragment =
                (VideoItemFragment) FragmentFactory.creatVedioFragment(mTabTitleList.get(position));
        ConstantUtils.LolType[] lolTypes = ConstantUtils.LolType.values();
        fragment.setLolType(lolTypes[position]);
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
