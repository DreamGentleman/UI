package com.dream.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author 孙康
 * @date 2018/3/14
 */

public class BaseActivity extends AppCompatActivity {

    private App app;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (App) getApplication();
        app.bindActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        app.unbindActivity(this);
    }
}
