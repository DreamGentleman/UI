package com.dream.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dream.ui.R;

/**
 * @author 孙康
 * @date 2018/3/14
 */

public class RecyclerActivity extends BaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_recycler);
    }
}
