package com.leonwang.app.chinashop.rx;

import org.greenrobot.eventbus.EventBus;

/**
 *eventbus工具类
 */
public class EventBusUtils {

	private EventBusUtils() {
	}

	/**
	 * 注册EventBus
	 */
	public static void register(Object subscriber) {
		if (!EventBus.getDefault().isRegistered(subscriber))
			EventBus.getDefault().register(subscriber);
	}

	/**
	 * 取消注册EventBus
	 */
	public static void unregister(Object subscriber) {
		EventBus.getDefault().unregister(subscriber);
	}

	/**
	 * 发布订阅事件
	 */
	public static void post(Object subscriber) {
		EventBus.getDefault().post(subscriber);
	}

	/**
	 * 发布粘性订阅事件
	 */
	public static void postSticky(Object subscriber) {
		EventBus.getDefault().postSticky(subscriber);
	}

	/**
	 * 移除指定的粘性订阅事件
	 * @param eventType class的字节码，例如：String.class
	 */
	public static <T> void removeStickyEvent(Class<T> eventType) {
		T stickyEvent = EventBus.getDefault().getStickyEvent(eventType);
		if (stickyEvent != null) {
			EventBus.getDefault().removeStickyEvent((T) stickyEvent);
		}
	}

	/**
	 * 移除所有的粘性订阅事件
	 */
	public static void removeAllStickyEvents() {
		EventBus.getDefault().removeAllStickyEvents();
	}

}
