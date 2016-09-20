package com.leonwang.app.chinashop.base;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * 当前类注释：Fragment基类
 * Author :LeonWang
 * Created  2016/9/20.11:49
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public abstract class RxLazyBaseFragment extends RxFragment {

    private LayoutInflater mInflater;
    private View mParentView;
    private FragmentActivity mActivity;

    //标志位  标志已经初始化完成
    protected boolean isPrepared;
    //标志位  fragent是否可见
    protected boolean isVisible;

    protected String TAG = this.getClass().getSimpleName();

    public abstract
    @LayoutRes
    int getLayoutResId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mParentView == null) {
            this.mInflater = inflater;
            mParentView = inflater.inflate(getLayoutResId(), container, false);
        } else {
            ViewGroup parent = (ViewGroup) mParentView.getParent();
            if (parent != null) {
                parent.removeView(mParentView);
            }
        }
        mActivity = getSupportActivity();
        Log.d(TAG, ":onCreateView");
        return mParentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        finishCreateView(savedInstanceState);
    }

    protected abstract void finishCreateView(Bundle savedInstanceState);

    public FragmentActivity getSupportActivity() {
        return super.getActivity();
    }

    public ActionBar getSupportActionBar() {
        return getSupportActivity().getActionBar();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (FragmentActivity) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mActivity = null;
    }

    public Context getApplicationContext() {
        return this.mActivity == null ? (getActivity() == null ? null :
                getActivity().getApplicationContext()) : this.mActivity.getApplicationContext();
    }

    protected LayoutInflater getLayoutInflater() {
        return mInflater;
    }

    protected View getParentView() {
        return mParentView;
    }


    /**
     * Fragment数据懒加载
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisble();
        }
    }

    protected void onVisible() {
        lazyLoad();
    }

    protected abstract void lazyLoad();

    protected void onInvisble() {

    }

    public <T extends View> T $(int id) {
        return (T) mParentView.findViewById(id);
    }
}
