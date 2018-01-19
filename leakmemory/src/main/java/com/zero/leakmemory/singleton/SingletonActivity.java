package com.zero.leakmemory.singleton;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zero.leakmemory.BaseActivity;
import com.zero.leakmemory.R;

import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/18.
 */

public class SingletonActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);
    }

    @OnClick(R.id.tv_show_toast)
    public void onClick() {
        SolutionToastManager2.getInstance(this).showToast();
    }
}
