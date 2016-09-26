package com.leonwang.app.chinashop.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

/**
 * Author :LeonWang
 * <p>
 * Created  2016/9/26.15:03
 * <p>
 * 描述:继承{@link SwipeRefreshLayout},解决页面初始化立即刷新问题
 */

public class MSwipeRefreshLayout extends SwipeRefreshLayout {

    private boolean mMeasured;
    private boolean mPreMeasureRefreshing;

    public MSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public MSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!mMeasured) {
            mMeasured = true;
            setRefreshing(mPreMeasureRefreshing);
        }
    }

    @Override
    public void setRefreshing(boolean refreshing) {
        if (mMeasured) {
            super.setRefreshing(refreshing);
        } else {
            mPreMeasureRefreshing = refreshing;
        }
    }
}
