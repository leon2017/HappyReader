package com.leonwang.app.chinashop.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.leonwang.app.chinashop.iml.SwipeItemCallback;


/**
 * Author :LeonWang
 * <p>
 * Created  2016/9/26.15:03
 * <p>
 * 描述:一种ViewType基类
 */

public abstract class SwipeAdapter1<E, UVH extends RecyclerView.ViewHolder> extends SwipeAdapter<E, UVH> {

    public SwipeAdapter1(Context context, SwipeItemCallback<E> swipeItemCallback) {
        super(context, swipeItemCallback);
    }

    /**
     * 用户item布局id
     */
    @LayoutRes
    protected abstract int userLayoutResId();

    /**
     * 创建用户ViewHolder
     */
    protected abstract UVH createUserViewHolder(View view);

    @Override
    public UVH userViewHolder(ViewGroup parent, int viewType) {
        return createUserViewHolder(mLayoutInflater.inflate(userLayoutResId(), parent, false));
    }
}
