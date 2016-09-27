package com.leonwang.app.chinashop.adapter.vhs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.leonwang.app.chinashop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 当前类注释：
 * Author :LeonWang
 * Created  2016/9/27.16:23
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class LolVideoViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.ivNews)
    public ImageView mIvNews;
    @BindView(R.id.tvTitle)
    public TextView mTvTitle;
    @BindView(R.id.tvDesc)
    public TextView mTvDesc;

    public LolVideoViewHolder(View itemView) {
        super(itemView);
//        LayoutInflater.from(App.getInstance()).inflate(R.layout.item_videos, null);
        ButterKnife.bind(this, itemView);
    }
}
