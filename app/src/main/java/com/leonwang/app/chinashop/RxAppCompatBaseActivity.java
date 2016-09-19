package com.leonwang.app.chinashop;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * 当前类注释：activity基类
 * Author :LeonWang
 * Created  2016/9/19.17:05
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public abstract class RxAppCompatBaseActivity extends RxAppCompatActivity {

    protected SystemBarTintManager mTintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架
        ButterKnife.bind(this);
        //初始化控件
        initViews(savedInstanceState);
        //初始化toolbar
        initToolBar();

    }

    //沉浸式状态栏
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.setTranslucentStatus(true);
        this.mTintManager = new SystemBarTintManager(this);
        this.mTintManager.setStatusBarTintEnabled(true);
        this.mTintManager.setTintColor(this.getResources().getColor(R.color.colorPrimary));
    }


    /**
     * 兼容4.4系统状态栏
     * @param on
     */
    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window w = this.getWindow();
        WindowManager.LayoutParams params = w.getAttributes();
        if (on) {
            params.flags |= 67108864;
        } else {
            params.flags &= -67108865;
        }
        w.setAttributes(params);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    protected abstract void initToolBar();

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract int getLayoutId();
}
