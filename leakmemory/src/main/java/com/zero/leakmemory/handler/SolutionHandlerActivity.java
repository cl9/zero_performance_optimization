package com.zero.leakmemory.handler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.zero.leakmemory.BaseActivity;
import com.zero.leakmemory.R;

import java.lang.ref.WeakReference;

import butterknife.OnClick;

/**
 * ============================================================
 *
 * @author : zero
 * @version ： 1.0
 * @date 2018/1/18 15:03
 * @desc 解决由于Handler引发的内存泄露
 * ============================================================
 */
public class SolutionHandlerActivity extends BaseActivity {
    private Handler mHandler = new MyHandler(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
    }

    @OnClick(R.id.tv_get_from_net)
    public void onClick() {
        loadData();
    }

    private void loadData() {
        Message message = Message.obtain();
        mHandler.sendMessageDelayed(message, 1000 * 60 * 5);
    }

    public static class MyHandler extends Handler {
        WeakReference<Context> wrContext;

        public MyHandler(Context context) {
            this.wrContext = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Context context = wrContext.get();
            if (context != null) {
                Toast.makeText(context, "成功获取到数据", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
