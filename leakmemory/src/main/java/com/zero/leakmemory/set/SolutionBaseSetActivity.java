package com.zero.leakmemory.set;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.TextView;

import com.zero.leakmemory.BaseActivity;
import com.zero.leakmemory.R;
import com.zero.leakmemory.set.ActivityStackManager;

import java.util.Random;

import butterknife.BindView;

/**
 * ============================================================
 * @author : zero
 * @version ： 1.0
 * @date  2018/1/17 17:24
 * @desc  解决内存泄露的BaseSetActivity
 * ============================================================
 */
public class SolutionBaseSetActivity extends BaseActivity {
    @BindView(R.id.tv_set)
    TextView mTvSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SolutionActivityStackManager.getAppManager().addActivity(this);
        setContentView(R.layout.activity_set);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getClass().getSimpleName());
        }
        Random random = new Random();
        mTvSet.setBackgroundColor(Color.argb(255, 0, 0, random.nextInt(255)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SolutionActivityStackManager.getAppManager().finishActivity(this);
    }
}
