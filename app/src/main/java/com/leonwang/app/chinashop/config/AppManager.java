package com.leonwang.app.chinashop.config;

import android.app.Activity;

import java.util.Iterator;
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

    /**
     * 将activity添加到管理栈中
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        mActivityStack.add(activity);
    }

    /**
     * 获取当前栈顶的activity
     *
     * @return
     */
    public Activity currentActivity() {
        return mActivityStack.lastElement();
    }

    /**
     * 销毁指定的activity
     *
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null && mActivityStack.contains(activity)) {
            mActivityStack.remove(activity);
            activity.finish();
        }

    }

    /**
     * 移除activity管理栈中指定的activity
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null && mActivityStack.contains(activity)) {
            mActivityStack.remove(activity);
        }
    }

    /**
     * 销毁指定类名的activity
     *
     * @param clazz
     */
    public void finishClassActivity(Class<? extends Activity> clazz) {
        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(clazz)) {
                finishActivity(activity);
                break;
            }
        }
    }


    /**
     * 销毁当前栈中所有的activity
     */
    public void finishAllActivity() {
        Iterator<Activity> iterator = mActivityStack.iterator();
        while (iterator.hasNext()) {
            Activity activity = iterator.next();
            finishActivity(activity);
        }
        mActivityStack.clear();
    }


    /**
     * 退出应用
     */
    public void exitApp() {
        finishAllActivity();
    }
}
