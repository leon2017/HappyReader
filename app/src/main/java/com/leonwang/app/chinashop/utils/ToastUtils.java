package com.leonwang.app.chinashop.utils;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * 当前类注释：toast工具类
 * Author :LeonWang
 * Created  2016/9/27.10:50
 * Description:
 * 问题：同时显示多个Toast信息提示框，会放在队列中，等前一个Toast关闭后才会显示下一个Toast。
 * 原因：Toast是Android用来显示信息的一种机制，跟Dialog不一样的是没有焦点，过一定的时间会自动消失
 * 解决方案：为了解决解决Toast重复显示问题，每次创建Toast我们先做下判断，如果有Toast显示，直接改变Toast里面的文字即可
 * <p></p>
 * E-mail:lijiawangjun@gmail.com
 */

public class ToastUtils {
    private static Toast mToast;
    private static Handler mHandler = new Handler();


    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(mToast!=null) {
                mToast.cancel();
            }
        }
    };

    /**
     *
     * @param context 上下文对象
     * @param text 提示信息
     * @param duration 显示时间
     */
    public synchronized static void showToast(Context context, String text, int duration){
        mHandler.removeCallbacks(runnable);
        if(mToast == null){//Toast第一次使用，初始化
            //你也可以自定义Toast的布局
            mToast = Toast.makeText(context,text,duration);
            mToast.show();
        }else{
            mToast.setText(text);
        }
        mHandler.postDelayed(runnable,1000);
    }

    public static void showToast(Context context,String text){
        showToast(context, text, Toast.LENGTH_LONG);
    }

    public static void showToast(Context context,int resId){
        String text = context.getResources().getString(resId);
        showToast(context,text,Toast.LENGTH_LONG);
    }

    public static void showToast(Context context,int resId,int duration){
        String text = context.getResources().getString(resId);
        showToast(context,text,duration);
    }
}

