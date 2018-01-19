package com.zero.leakmemory.set;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zero.leakmemory.R;

import butterknife.OnClick;

public class SetActivity1 extends SolutionBaseSetActivity {

    private static final int TIME_DELAY = 2000;
    private long backPressed;

    @OnClick(R.id.tv_set)
    public void onClick() {
        startActivity(new Intent(this, SetActivity2.class));
    }


    @Override
    public void onBackPressed() {
        if (backPressed + TIME_DELAY > System.currentTimeMillis()) {
            SolutionActivityStackManager.getAppManager().appExit();
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "再点一次退出所有集合Activity!",
                    Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }
}
