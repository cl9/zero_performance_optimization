package com.zero.leakmemory.singleton;

import android.content.Context;
import android.widget.Toast;

/**
 * ============================================================
 *
 * @author : zero
 * @version ： 1.0
 * @date 2018/1/18 10:06
 * @desc 单例引起的内存泄露
 * ============================================================
 */

public class ToastManager {
    private static ToastManager sInstance;
    private Context mContext;

    public static ToastManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ToastManager(context);
        }
        return sInstance;
    }

    private ToastManager(Context context) {
        mContext = context;
    }

    public void showToast() {
        Toast.makeText(mContext, "单例引起的内存泄露", Toast.LENGTH_SHORT).show();
    }
}
