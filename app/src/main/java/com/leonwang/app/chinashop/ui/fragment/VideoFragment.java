package com.leonwang.app.chinashop.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.base.RxLazyBaseFragment;
import com.leonwang.app.chinashop.widget.LoadMoreRecyclerView;

import butterknife.BindView;

import static com.leonwang.app.chinashop.R.id.recyclerView;

/**
 * 当前类注释：视频
 * Author :LeonWang
 * Created  2016/9/22.13:17
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class VideoFragment extends RxLazyBaseFragment {

    @BindView(recyclerView)
    LoadMoreRecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    private int page = 0;
    private int mColumnCount = 1;

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

    @Override
    protected void finishCreateView(Bundle savedInstanceState) {
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) return;
        initData();
        isPrepared = false;
    }

    private void initData() {

    }
}
