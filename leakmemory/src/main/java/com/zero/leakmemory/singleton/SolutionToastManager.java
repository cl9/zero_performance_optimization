package com.zero.leakmemory.singleton;

import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * ============================================================
 * @author : zero
 * @version ： 1.0
 * @date  2018/1/18 11:21
 * @desc  使用弱引用解决单例引起的内存泄露
 * ============================================================
 */

public class SolutionToastManager {
    private static SolutionToastManager sInstance;
    private WeakReference<Context> wrContext;

    public static SolutionToastManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SolutionToastManager(context);
        }
        return sInstance;
    }

    private SolutionToastManager(Context context) {
        wrContext = new WeakReference<>(context);
    }

    public void showToast() {
        Context context = wrContext.get();
        if (context != null) {
            Toast.makeText(context, "单例引起的内存泄露", Toast.LENGTH_SHORT).show();
        }
    }
}