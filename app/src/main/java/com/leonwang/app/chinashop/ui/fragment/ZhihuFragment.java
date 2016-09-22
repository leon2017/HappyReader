package com.leonwang.app.chinashop.ui.fragment;

import android.os.Bundle;

import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.base.RxLazyBaseFragment;

/**
 * 当前类注释：知乎
 * Author :LeonWang
 * Created  2016/9/22.13:17
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class ZhihuFragment extends RxLazyBaseFragment {

    public static ZhihuFragment newInstance(String param3) {
        ZhihuFragment zhihuFragment = new ZhihuFragment();
        Bundle args = new Bundle();
        args.putString("args3",param3);
        zhihuFragment.setArguments(args);
        return zhihuFragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_zhihu;
    }

    @Override
    protected void finishCreateView(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }
}
