package com.leonwang.app.chinashop.config;

import android.app.Activity;

import java.util.Stack;

/**
 * 当前类注释：activity压栈管理
 * Author :LeonWang
 * Created  2016/9/19.18:04
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class AppManager {

    private static Stack<Activity> mActivityStack;

    private static AppManager instance_;

    private AppManager() {

    }

    public static AppManager getInstance() {

        if (instance_ == null) {
            instance_ = new AppManager();
        }

        if (mActivityStack == null) {
            mActivityStack = new Stack<>();
        }

        return instance_;
    }


    /**
     * 获取指定的activity
     *
     * @param clazz 字节码文件
     * @return activity
     */
    public static Activity getActivity(Class<? extends Activity> clazz) {
        if (mActivityStack != null) {
            for (Activity activity : mActivityStack) {
                if (activity.getClass().equals(clazz)) {
                    return activity;
                }
            }
        }

        return null;
    }
}
