package com.leonwang.app.chinashop.widget;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.adapter.RefreshCallback;
import com.leonwang.app.chinashop.adapter.SwipeAdapter;
import com.leonwang.app.chinashop.iml.SwipeRefreshCallback;


/**
 * Author :LeonWang
 * <p>
 * Created  2016/9/26.15:03
 * <p>
 * 描述:
 */

public class SwipeRecyclerView extends FrameLayout implements SwipeRefreshLayout.OnRefreshListener {

    private MSwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RefreshCallback mRefreshCallback;
    private SwipeRefreshCallback mSwipeRefreshCallback;
    private SwipeAdapter mSwipeAdapter;

    public SwipeRecyclerView(Context context) {
        this(context, null);
    }

    public SwipeRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.swiperecyclerview, this);
        mSwipeRefreshLayout = (MSwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        init();
    }

    private void init() {
        int colorSchemeResources = colorSchemeResources();
        mSwipeRefreshLayout.setColorSchemeResources(
                colorSchemeResources,
                colorSchemeResources,
                colorSchemeResources,
                colorSchemeResources);

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int loadStatus = mSwipeAdapter.getLoadStatus();
                if (loadStatus == 0 &&
                        mSwipeAdapter.isHasMore() &&
                        mSwipeAdapter.userDataCount() == mLinearLayoutManager.findLastCompletelyVisibleItemPosition()) {
                    mSwipeAdapter.setLoadStatus(2);
                    mRefreshCallback.upRefresh(mSwipeAdapter.userDataCount());
                }
            }
        });

        mSwipeRefreshCallback = new SwipeRefreshCallback() {
            @Override
            public void downRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                mRefreshCallback.downRefresh();
            }

            @Override
            public void upRefresh(int count) {
                mRefreshCallback.upRefresh(count);
            }

            @Override
            public void refreshComplete() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        };
    }

    @ColorRes
    protected int colorSchemeResources() {
        return R.color.colorAccent;
    }

    @Override
    public void onRefresh() {
        mSwipeAdapter.setLoadStatus(1);
        mRefreshCallback.downRefresh();
    }

    /**
     * 刷新回调
     */
    public void setRefreshCallback(RefreshCallback refreshCallback) {
        mRefreshCallback = refreshCallback;
    }

    /**
     * 开启下拉刷新
     */
    public void startDownRefresh() {
        mSwipeAdapter.setLoadStatus(1);
        mSwipeRefreshLayout.setRefreshing(true);
        mRecyclerView.smoothScrollToPosition(0);
        mRefreshCallback.downRefresh();
    }

    /**
     * 设置Adapter
     */
    public void setAdapter(SwipeAdapter swipeAdapter) {
        mSwipeAdapter = swipeAdapter;
        mSwipeAdapter.setSwipeRefreshCallback(mSwipeRefreshCallback);
        mRecyclerView.setAdapter(mSwipeAdapter);
    }

    /**
     * 获取RecyclerView
     */
    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    /**
     * 页面异常状态
     * @param state  加载状态-1:初始化;0:普通状态;1:下拉刷新;2:加载更多;3:加载出错
     */
    public void downRefreshComplete(int state) {
        mSwipeAdapter.setLoadStatus(state);
        mSwipeAdapter.notifyDataSetChanged();
        mSwipeRefreshCallback.refreshComplete();
    }
}
