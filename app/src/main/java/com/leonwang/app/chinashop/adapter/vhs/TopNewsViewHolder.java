package com.leonwang.app.chinashop.adapter.vhs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.leonwang.app.chinashop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 当前类注释：新闻
 * Author :LeonWang
 * Created  2016/9/23.14:37
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class TopNewsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_tab)
    public TextView mTvTab;
    @BindView(R.id.tv_tab2)
    public TextView mTvTab2;
    @BindView(R.id.tv_title)
    public TextView mTvTitle;
    @BindView(R.id.tv_desc)
    public TextView mTvDesc;
    @BindView(R.id.iv_item)
    public ImageView mImageView;
    @BindView(R.id.tv_time)
    public TextView mTvTime;

    public TopNewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
