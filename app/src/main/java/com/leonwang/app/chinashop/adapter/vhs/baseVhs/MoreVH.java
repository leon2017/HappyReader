package com.leonwang.app.chinashop.adapter.vhs.baseVhs;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.leonwang.app.chinashop.R;


/**
 * Author :LeonWang
 * <p>
 * Created  2016/9/26.15:03
 * <p>
 * 描述:更多VH
 */

public class MoreVH extends RecyclerView.ViewHolder {

    public AppCompatTextView mAtvSwipeMore;
    public ProgressBar mPbSwipeMore;

    public MoreVH(View itemView) {
        super(itemView);
        mAtvSwipeMore = (AppCompatTextView) itemView.findViewById(R.id.atv_swipe_more);
        mPbSwipeMore = (ProgressBar) itemView.findViewById(R.id.pb_swipe_more);
    }
}
