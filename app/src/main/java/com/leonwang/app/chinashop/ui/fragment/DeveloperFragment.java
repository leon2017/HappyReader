package com.leonwang.app.chinashop.ui.fragment;

import android.os.Bundle;

import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.base.RxLazyBaseFragment;

/**
 * 当前类注释：开发
 * Author :LeonWang
 * Created  2016/9/22.13:18
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class DeveloperFragment extends RxLazyBaseFragment {

    public static DeveloperFragment newInstance(String param4) {
        DeveloperFragment developerFragment = new DeveloperFragment();
        Bundle args = new Bundle();
        args.putString("args4", param4);
        developerFragment.setArguments(args);
        return developerFragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_developer;
    }

    @Override
    protected void finishCreateView(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }
}
