package com.leonwang.app.chinashop.utils;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leonwang.app.chinashop.R;

/**
 * 当前类注释：SnackBar工具类
 * Author :LeonWang
 * Created  2016/9/27.9:34
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class SnackBarUtils {

    public static final int INFO    = 1;
    public static final int CONFIRM = 2;
    public static final int WARNING = 3;
    public static final int ALERT   = 4;

    public static int red    = 0xfff44336;
    public static int green  = 0xff4caf50;
    public static int blue   = 0xff2195f3;
    public static int orange = 0xffffc107;


    /**
     * 普通的snackbar
     * @param view
     * @param message
     * @return
     */
    public static Snackbar showSnackBar(View view ,String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        return snackbar;
    }
    /**
     * Snackbar：自定义颜色的短显示
     *
     * @param view
     * @param message
     * @param messageColor
     * @param backgroundColor
     * @return
     */
    public static Snackbar shortSnackbar(View view, String message, int messageColor, int backgroundColor) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        setSnackBarColor(snackbar, messageColor, backgroundColor);
        return snackbar;
    }

    /**
     * Snackbar：自定义颜色的长显示
     *
     * @param view
     * @param message
     * @param messageColor
     * @param backgroundColor
     * @return
     */
    public static Snackbar longSnackbar(View view, String message, int messageColor, int backgroundColor) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        setSnackBarColor(snackbar, messageColor, backgroundColor);
        return snackbar;
    }


    /**
     * 短显示Snackbar，可选预设类型
     *
     * @param view
     * @param message
     * @param type
     * @return
     */
    public static Snackbar shortSnackbar(View view, String message, int type) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        switchType(snackbar, type);
        return snackbar;
    }

    /**
     * 长显示Snackbar，可选预设类型
     *
     * @param view
     * @param message
     * @param type
     * @return
     */
    public static Snackbar longSnackbar(View view, String message, int type) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        switchType(snackbar, type);
        return snackbar;
    }


    /**
     * 自定义时常显示Snackbar，自定义颜色
     *
     * @param view
     * @param message
     * @param messageColor
     * @param backgroundColor
     * @return
     */
    public static Snackbar IndefiniteSnackbar(View view, String message, int duration,
                                              int messageColor, int backgroundColor) {
        Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_INDEFINITE)
                .setDuration(duration);
        setSnackBarColor(snackbar, messageColor, backgroundColor);
        return snackbar;
    }

    /**
     * 自定义时常显示Snackbar，可选预设类型
     *
     * @param view
     * @param message
     * @param type
     * @return
     */
    public static Snackbar IndefiniteSnackbar(View view, String message, int duration, int type) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE).setDuration(duration);
        switchType(snackbar, type);
        return snackbar;
    }

    /**
     * 设置Snackbar背景颜色
     *
     * @param snackbar
     * @param backgroundColor
     */
    public static void setSnackBarColor(Snackbar snackbar, int backgroundColor) {
        View view = snackbar.getView();
        if (view != null) {
            view.setBackgroundColor(backgroundColor);
        }
    }

    /**
     * 设置SnackBar消息的颜色
     *
     * @param snackbar
     * @param messageColor
     */
    public static void setSnackBarMsgColor(Snackbar snackbar, int messageColor) {
        View view = snackbar.getView();
        if (view != null) {
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(messageColor);
        }
    }

    /**
     * 设置Snackbar文字和背景颜色
     *
     * @param snackbar
     * @param messageColor
     * @param backgroundColor
     */
    public static void setSnackBarColor(Snackbar snackbar, int messageColor, int backgroundColor) {
        View view = snackbar.getView();
        if (view != null) {
            view.setBackgroundColor(backgroundColor);
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(messageColor);
        }
    }

    /**
     * 为SnackBar添加布局
     *
     * @param snackbar SnackBar实例
     * @param layoutId 布局文件
     * @param index    位置
     */
    public static void addView(Snackbar snackbar, int layoutId, int index) {
        /** 获取snackbar的View(其实就是SnackbarLayout) */
        View snackbarview = snackbar.getView();
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarview;

        View add_view = LayoutInflater.from(snackbarview.getContext())
                .inflate(layoutId, null);   //加载布局文件新建View
        // 设置新建布局参数
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置新建布局在Snackbar内垂直居中显示
        p.gravity = Gravity.CENTER_VERTICAL;
        // 将新建布局添加进snackbarLayout相应位置
        snackbarLayout.addView(add_view, index, p);
    }


    //选择预设类型
    private static void switchType(Snackbar snackbar, int type) {
        switch (type) {
            case INFO:
                setSnackBarColor(snackbar, blue);
                break;
            case CONFIRM:
                setSnackBarColor(snackbar, green);
                break;
            case WARNING:
                setSnackBarColor(snackbar, orange);
                break;
            case ALERT:
                setSnackBarColor(snackbar, Color.YELLOW, red);
                break;
        }
    }
}
