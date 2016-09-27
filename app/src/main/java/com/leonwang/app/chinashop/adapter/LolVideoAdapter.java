package com.leonwang.app.chinashop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.adapter.vhs.LolVideoViewHolder;
import com.leonwang.app.chinashop.config.App;
import com.leonwang.app.chinashop.entity.VideoEntity.DataEntity;
import com.leonwang.app.chinashop.iml.SwipeItemCallback;

/**
 * 当前类注释：
 * Author :LeonWang
 * Created  2016/9/27.16:27
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class LolVideoAdapter extends SwipeAdapter1<DataEntity,LolVideoViewHolder> {


    public LolVideoAdapter(Context context, SwipeItemCallback<DataEntity> swipeItemCallback) {
        super(context, swipeItemCallback);
    }

    @Override
    protected int userLayoutResId() {
        return R.layout.item_videos;
    }

    @Override
    protected LolVideoViewHolder createUserViewHolder(View view) {
        return new LolVideoViewHolder(view);
    }

    @Override
    protected LolVideoViewHolder castVH(RecyclerView.ViewHolder holder) {
        return (LolVideoViewHolder) holder;
    }

    @Override
    public void bindUserViewHolder(LolVideoViewHolder holder, int position) {
        mList.size();
        DataEntity dataEntity = mList.get(position);
        holder.mTvTitle.setText(dataEntity.getTitle());
        holder.mTvDesc.setText(dataEntity.getDesc());
        holder.mIvNews.setScaleType(ImageView.ScaleType.FIT_XY);
        App.getInstance().displayImage(dataEntity.getPic_url(),holder.mIvNews,0,true, DiskCacheStrategy.ALL);
    }
}
