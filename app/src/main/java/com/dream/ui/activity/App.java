package com.dream.ui.activity;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

/**
 * @author 孙康
 * @date 2018/3/14
 */

public class App extends Application {
    private ArrayList<Activity> activities = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void bindActivity(Activity activity) {
        activities.add(activity);
    }

    public void unbindActivity(Activity activity) {
        activities.remove(activity);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
