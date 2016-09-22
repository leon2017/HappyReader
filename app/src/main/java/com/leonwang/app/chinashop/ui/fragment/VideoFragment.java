package com.leonwang.app.chinashop.ui.fragment;

import android.os.Bundle;

import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.base.RxLazyBaseFragment;

/**
 * 当前类注释：视频
 * Author :LeonWang
 * Created  2016/9/22.13:17
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class VideoFragment extends RxLazyBaseFragment {

    public static VideoFragment newInstance(String param2) {
        VideoFragment videoFragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putString("args2",param2);
        videoFragment.setArguments(args);
        return videoFragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void finishCreateView(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }
}
