package com.leonwang.app.chinashop.iml;

/**
 * Created by guilin on 16/7/15.
 * <p>
 * 描述:刷新回调
 */

public interface SwipeRefreshCallback {

    /**
     * 下拉刷新
     */
    void downRefresh();

    /**
     * 加载更多
     *
     * @param count 用户数据
     */
    void upRefresh(int count);

    /**
     * 刷新完成
     */
    void refreshComplete();
}
