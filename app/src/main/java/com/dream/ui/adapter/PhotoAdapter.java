package com.dream.ui.adapter;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dream.ui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙康
 * @date 2018/3/16
 */

public class PhotoAdapter extends BaseAdapter {
    private List<Uri> photos;
    Activity activity;
    public List<Uri> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Uri> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    public PhotoAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return photos == null ? 0 : photos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, null);
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Uri uri = photos.get(position);
        Log.e("getView: ", uri.toString());
        Glide.with(activity).load(uri).into(viewHolder.iv);
        return convertView;
    }

    public static class ViewHolder {
        ImageView iv;
    }
}
