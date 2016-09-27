package com.leonwang.app.chinashop.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.leonwang.app.chinashop.R;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

/**
 * Created by marno on 2016/6/7/11:23.
 */
public class LayoutHelper {

    public static LinearLayoutManager getLinearLayout(Context context) {
        return new LinearLayoutManager(context);
    }


    public static GridLayoutManager getGridLayout(Context context, int count) {
        return new GridLayoutManager(context, count);
    }

    public static StaggeredGridLayoutManager getVerticalStagLayout() {
        return new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    }


    public static HorizontalDividerItemDecoration getHorizontalDivider_5(Context context) {
        return new HorizontalDividerItemDecoration.Builder(context)
                .color(Color.WHITE)
                .sizeResId(R.dimen.five)
                .build();
    }

    public static HorizontalDividerItemDecoration getHorizontalDivider_6(Context context) {
        return new HorizontalDividerItemDecoration.Builder(context)
                .color(Color.parseColor("#f5f5f5"))
                .sizeResId(R.dimen.eight)
                .build();
    }

    public static HorizontalDividerItemDecoration getHorizontalDividerTranslate(Context context) {
        return new HorizontalDividerItemDecoration.Builder(context)
                .color(Color.TRANSPARENT)
                .sizeResId(R.dimen.nine)
                .build();
    }

}
