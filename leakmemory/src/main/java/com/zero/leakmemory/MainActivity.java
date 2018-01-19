package com.zero.leakmemory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zero.leakmemory.handler.HandlerActivity;
import com.zero.leakmemory.handler.SolutionHandlerActivity;
import com.zero.leakmemory.set.SetActivity1;
import com.zero.leakmemory.singleton.SingletonActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.tv_to_set, R.id.tv_to_singleton, R.id.tv_to_handler})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_to_set:
                startActivity(new Intent(this, SetActivity1.class));
                break;
            case R.id.tv_to_singleton:
                startActivity(new Intent(this, SingletonActivity.class));
                break;
            case R.id.tv_to_handler:
                startActivity(new Intent(this, SolutionHandlerActivity.class));
                break;
            default:
                break;
        }
    }

}
