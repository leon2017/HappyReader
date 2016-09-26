package com.leonwang.app.chinashop.adapter.vhs.baseVhs;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.leonwang.app.chinashop.R;


/**
 * Author :LeonWang
 * <p>
 * Created  2016/9/26.15:03
 * <p>
 * 描述:默认VH
 */
@SuppressWarnings("all")
public class DefVH extends RecyclerView.ViewHolder {

    public ImageView mImgSwipeDef;
    public AppCompatTextView mAtvSwipeDef;

    public DefVH(View itemView) {
        super(itemView);
        mImgSwipeDef = (ImageView) itemView.findViewById(R.id.img_swipe_def);
        mAtvSwipeDef = (AppCompatTextView) itemView.findViewById(R.id.atv_swipe_def);
    }
}
