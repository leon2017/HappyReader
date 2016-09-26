package com.leonwang.app.chinashop.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.adapter.vhs.TopNewsViewHolder;
import com.leonwang.app.chinashop.config.App;
import com.leonwang.app.chinashop.entity.TopNewsEntity.ResultEntity.DataEntity;
import com.leonwang.app.chinashop.iml.SwipeItemCallback;

import java.util.Random;

/**
 * 当前类注释：新闻
 * Author :LeonWang
 * Created  2016/9/23.14:36
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class TopNewsAdapter extends SwipeAdapter1<DataEntity,TopNewsViewHolder> {

    private Context mContext;
    public TopNewsAdapter(Context context, SwipeItemCallback<DataEntity> swipeItemCallback) {
        super(context, swipeItemCallback);
    }

    @Override
    protected int userLayoutResId() {
        return R.layout.top_news_item;
    }

    @Override
    protected TopNewsViewHolder createUserViewHolder(View view) {
        return new TopNewsViewHolder(view);
    }

    @Override
    protected TopNewsViewHolder castVH(RecyclerView.ViewHolder holder) {
        return (TopNewsViewHolder) holder;
    }

    @Override
    public void bindUserViewHolder(TopNewsViewHolder holder, int position) {
        mList.size();
        DataEntity dataEntity = mList.get(position);
        holder.mTvTab.setText(dataEntity.getAuthor_name());
        try {
            changeColor(holder.mTvTab);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.mTvTitle.setText(dataEntity.getTitle());
        holder.mTvDesc.setText(dataEntity.getTitle()+dataEntity.getUrl()+dataEntity.getThumbnail_pic_s()+dataEntity.getThumbnail_pic_s02());
        String id = dataEntity.getUniquekey();//wechat_20150402028462
        if (null !=id && id.length()==21){
            String[] idArray = id.split("_", 0);
            String subTime = idArray[1].substring(0, 9);//20150402
            holder.mTvTime.setText("时间轴："+subTime.substring(0,4)+"年"+subTime.substring(4,6)+"月"+subTime.substring(6,subTime.length()-1)+"日");
        }

        holder.mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        App.getInstance().displayImage(dataEntity.getThumbnail_pic_s(),holder.mImageView,0,true, DiskCacheStrategy.ALL);
        holder.mTvTab2.setText("『"+dataEntity.getType()+"』");
    }


    public void changeColor(TextView view) {
        Random x = new Random();
        int red = x.nextInt(256);
        int green = x.nextInt(256);
        int blue = x.nextInt(256);
        if (red == 0 && green == 0 && blue == 0) {//防止背景色为白色
            changeColor(view);
        }else {
            view.setBackgroundColor(Color.rgb(red, green, blue));
        }
    }

}
