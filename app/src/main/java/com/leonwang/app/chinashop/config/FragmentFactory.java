package com.leonwang.app.chinashop.config;

import com.leonwang.app.chinashop.base.RxLazyBaseFragment;
import com.leonwang.app.chinashop.ui.fragment.itemFragment.NewsItemFragment;
import com.leonwang.app.chinashop.ui.fragment.itemFragment.VideoItemFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * 当前类注释：缓存fragment工厂类
 * Author :LeonWang
 * Created  2016/9/22.15:08
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class FragmentFactory {

    private static Map<String, RxLazyBaseFragment> mCache = new HashMap<>();

    //新闻fragment
    public static RxLazyBaseFragment creatNewsFragment(String tag) {
        RxLazyBaseFragment fragment = mCache.get(tag);
        if (fragment == null) {
            fragment = new NewsItemFragment();
            mCache.put(tag, fragment);
        }
        return fragment;
    }

    //视频fragment
    public static RxLazyBaseFragment creatVedioFragment(String tag) {
        RxLazyBaseFragment fragment = mCache.get(tag);
        if (fragment == null) {
            fragment = new VideoItemFragment();
            mCache.put(tag, fragment);
        }
        return fragment;
    }
}
