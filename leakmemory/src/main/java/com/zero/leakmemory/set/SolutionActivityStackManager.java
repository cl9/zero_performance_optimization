package com.zero.leakmemory.set;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Stack;

/**
 * ============================================================
 *
 * @author : zero
 * @version ： 1.0
 * @date 2017/12/1 15:39
 * @desc 解决内存泄露的ActivityStackManager
 * ============================================================
 */
public class SolutionActivityStackManager {
    private Stack<WeakReference<Activity>> activityStack;
    private static SolutionActivityStackManager instance;

    /**
     * 锁定退出
     */
    public static boolean isForcedExit;

    private SolutionActivityStackManager() {
        activityStack = new Stack<>();
    }

    /**
     * 获取单一实例
     *
     * @return
     */
    public static SolutionActivityStackManager getAppManager() {
        if (instance == null) {
            instance = new SolutionActivityStackManager();
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
     * @param activity 需添加的Activity
     */
    public void addActivity(Activity activity) {
        activityStack.add(new WeakReference<>(activity));
    }

    /**
     * 移除Activity
     *
     * @param activity 需移除的Activity
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
        Activity activity = activityStack.lastElement().get();
        return activity;
    }

    /**
     * 结束指定的Activity
     *
     * @param activity 需要结束的Activity对象
     */
    public void finishActivity(Activity activity) {
        Iterator<WeakReference<Activity>> iterable = activityStack.iterator();
        while (iterable.hasNext()) {
            WeakReference<Activity> wrActivity = iterable.next();
            Activity curActivity = wrActivity.get();
            if (curActivity != null && curActivity.getClass().equals(activity.getClass())) {
                if (!curActivity.isFinishing()) {
                    curActivity.finish();
                }
                activityStack.remove(wrActivity);
            }
        }
    }

    /**
     * 结束指定类名的Activity
     *
     * @param cls 需要结束的Activity的class对象
     */
    public void finishActivity(Class<?> cls) {
        Iterator<WeakReference<Activity>> iterable = activityStack.iterator();
        while (iterable.hasNext()) {
            WeakReference<Activity> wrActivity = iterable.next();
            Activity curActivity = wrActivity.get();
            if (curActivity != null && curActivity.getClass().equals(cls)) {
                if (!curActivity.isFinishing()) {
                    curActivity.finish();
                }
                activityStack.remove(wrActivity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            Activity activity = activityStack.get(i).get();
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
        activityStack.clear();
    }


    /**
     * 退出程序
     */
    public void appExit() {
        isForcedExit = true;
        // 关闭所有activity
        finishAllActivity();
        isForcedExit = false;
    }
}
