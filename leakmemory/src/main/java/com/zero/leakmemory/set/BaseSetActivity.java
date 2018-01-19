package com.zero.leakmemory.set;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.TextView;

import com.zero.leakmemory.BaseActivity;
import com.zero.leakmemory.R;

import java.util.Random;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/17.
 */

public class BaseSetActivity extends BaseActivity {
    @BindView(R.id.tv_set)
    TextView mTvSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStackManager.getAppManager().addActivity(this);
        setContentView(R.layout.activity_set);
        mTvSet.setText(getClass().getSimpleName());
        Random random = new Random();
        mTvSet.setBackgroundColor(Color.argb(255, 0, 0, random.nextInt(255)));
    }

}
