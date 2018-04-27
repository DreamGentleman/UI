package com.dream.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dream.ui.R;
import com.dream.ui.adapter.PhotoAdapter;
import com.dream.ui.widget.GifSizeFilter;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;

import java.util.List;

import io.reactivex.functions.Consumer;

public class SelectorPhotoActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button btn;
    protected GridView gv;
    private PhotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_selector_photo);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn) {
            RxPermissions rxPermissions = new RxPermissions(this);
            rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Consumer<Boolean>() {
                @Override
                public void accept(Boolean aBoolean) throws Exception {
                    if (aBoolean) {
                        Matisse.from(SelectorPhotoActivity.this)
                                .choose(MimeType.allOf())
                                .countable(true)
                                .maxSelectable(9)
                                .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                                .thumbnailScale(0.85f)
                                .imageEngine(new GlideEngine())
                                .forResult(1);
                    }
                }
            });
        }
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(SelectorPhotoActivity.this);
        gv = (GridView) findViewById(R.id.gv);
        adapter = new PhotoAdapter(this);
        gv.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            List<Uri> uris = Matisse.obtainResult(data);
            adapter.setPhotos(Matisse.obtainResult(data));
        }
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, SelectorPhotoActivity.class);
        activity.startActivity(intent);
    }
}
