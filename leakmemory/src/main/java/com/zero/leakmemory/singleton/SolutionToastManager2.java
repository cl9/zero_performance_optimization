package com.zero.leakmemory.singleton;

import android.content.Context;
import android.widget.Toast;

/**
 * ============================================================
 *
 * @author : zero
 * @version ： 1.0
 * @date 2018/1/18 10:06
 * @desc 使用getApplicationContext解决单例引起的内存泄露
 * ============================================================
 */

public class SolutionToastManager2 {
    private static SolutionToastManager2 sInstance;
    private Context mContext;

    public static SolutionToastManager2 getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SolutionToastManager2(context);
        }
        return sInstance;
    }

    private SolutionToastManager2(Context context) {
        mContext = context.getApplicationContext();
    }

    public void showToast() {
        Toast.makeText(mContext, "单例引起的内存泄露", Toast.LENGTH_SHORT).show();
    }
}
