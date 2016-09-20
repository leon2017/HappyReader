package com.leonwang.app.chinashop.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;

import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.config.AppManager;
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
    protected ProgressDialog mProgressDialog;

    /**
     * UI Handler
     */
    protected MainHandler mHandler = new MainHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        //activity压栈管理
        AppManager.getInstance().addActivity(this);
        //初始化黄油刀控件绑定框架
        ButterKnife.bind(this);
        //初始化控件
        initViews(savedInstanceState);
        //初始化toolbar
        initToolBar();
        //加载数据
        initData();
    }


    //沉浸式状态栏
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.setTranslucentStatus(true);
        this.mTintManager = new SystemBarTintManager(this);
        this.mTintManager.setStatusBarTintEnabled(true);
        this.mTintManager.setTintColor(this.getResources().getColor(R.color.colorPrimaryDark));
    }


    /**
     * 兼容4.4系统状态栏
     *
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
        AppManager.getInstance().finishActivity(this);
    }

    /**
     * 显示dialog
     *
     * @param msg
     */
    protected void showProgressDialog(String msg) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
        }
        if (TextUtils.isEmpty(msg)) {
            mProgressDialog.setMessage(getString(R.string.progressdiaog));
        } else {
            mProgressDialog.setMessage(msg);
        }
        mProgressDialog.show();
    }

    /**
     * 隐藏progressdialog
     */
    protected void hideProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }



    public class MainHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }

    /**
     * 发送空消息
     * @param msgId
     */
    public void sendEmptyMessages(int msgId) {
        mHandler.sendEmptyMessage(msgId);
    }

    /**
     * 发送消息
     * @param msg
     */
    public void sendMessages(Message msg) {
        mHandler.sendMessage(msg);
    }


    protected abstract int getLayoutId();

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract void initToolBar();

    protected abstract void initData();

    /**
     * 处理UI Handler消息
     * @param msg
     */
    protected abstract void onHandlerMessage(Message msg);
}
