package com.zero.leakmemory.set;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zero.leakmemory.R;

import butterknife.OnClick;

public class SetActivity2 extends SolutionBaseSetActivity {
    @OnClick(R.id.tv_set)
    public void onClick() {
        startActivity(new Intent(this, SetActivity3.class));
    }
}
