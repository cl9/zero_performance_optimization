package com.zero.leakmemory.set;

import android.app.Activity;

import java.util.Stack;

/**
 * ============================================================
 * @author : zero
 * @version ： 1.0
 * @date  2018/1/17 16:39
 * @desc  应用程序Activity管理类：用于Activity管理和应用程序退出
 * ============================================================
 */
public class ActivityStackManager {
	private Stack<Activity> activityStack;
	private static ActivityStackManager instance;

	/** 锁定退出 */
	public static boolean isForcedExit;

	private ActivityStackManager() {
		activityStack = new Stack<Activity>();
	}

	/**
	 * 获取单一实例
	 *
	 * @return
	 */
	public static ActivityStackManager getAppManager() {
		if (instance == null) {
			instance = new ActivityStackManager();
		}
		return instance;
	}

	/**
	 * 获取集合中Activity的数量
	 *
	 * @return
	 */
	public int getSize() {
		return activityStack.size();
	}

	/**
	 * 添加Activity
	 *
	 * @param activity
	 *            需添加的Activity
	 */
	public void addActivity(Activity activity) {
		activityStack.add(activity);
	}

	/**
	 * 移除Activity
	 *
	 * @param activity
	 *            需移除的Activity
	 */
	public void removeActivity(Activity activity) {
		activityStack.remove(activity);
	}

	/**
	 * 获取当前Activity（堆栈中最后一个压入的）
	 *
	 * @return
	 */
	public Activity currentActivity() {
		Activity activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * 结束指定的Activity
	 *
	 * @param activity
	 *            需要结束的Activity对象
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 结束指定类名的Activity
	 *
	 * @param cls
	 *            需要结束的Activity的class对象
	 */
	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	/**
	 * 结束所有Activity
	 *
	 */
	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}

	/**
	 * 除了指定的Activity，结束所有Other Activity
	 *
	 * @param activity
	 *            指定不结束的Activity对象
	 */
	public void finishAllOtherActivity(Activity activity) {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)
					&& !activityStack.get(i).getClass().getName()
							.equals(activity.getClass().getName())) {
				activityStack.get(i).finish();
			}
		}
	}

	/**
	 * 除了指定的Activity，结束所有Other Activity
	 *
	 * @param clazz
	 *            指定不结束的Activity的class
	 */
	public void finishAllOtherActivity(Class clazz) {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)
					&& !activityStack.get(i).getClass().getName()
							.equals(clazz.getName())) {
				activityStack.get(i).finish();
			}
		}
	}

	/**
	 * 退出程序
	 *
	 */
	public void appExit() {
		isForcedExit = true;
		// 关闭所有activity
		finishAllActivity();
		isForcedExit = false;
	}
}
