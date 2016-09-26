package com.leonwang.app.chinashop.iml;

import android.view.View;

/**
 * Created by guilin on 16/7/15.
 * <p>
 * 描述:swipe列表点击回调
 */

public interface SwipeItemCallback<E> {

    void callback(View view, int position, E e);
}
