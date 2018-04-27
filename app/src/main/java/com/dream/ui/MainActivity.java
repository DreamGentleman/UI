package com.dream.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dream.ui.activity.BaseActivity;
import com.dream.ui.activity.SelectorPhotoActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    protected Button btnRecycle;
    protected Button btnPhoto;
    protected Button btnSelectorDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_recycle) {

        } else if (view.getId() == R.id.btn_photo) {
            SelectorPhotoActivity.start(this);
        } else if (view.getId() == R.id.btn_selector_date) {

        }
    }

    private void initView() {
        btnRecycle = (Button) findViewById(R.id.btn_recycle);
        btnRecycle.setOnClickListener(MainActivity.this);
        btnPhoto = (Button) findViewById(R.id.btn_photo);
        btnPhoto.setOnClickListener(MainActivity.this);
        btnSelectorDate = (Button) findViewById(R.id.btn_selector_date);
        btnSelectorDate.setOnClickListener(MainActivity.this);
    }
}
