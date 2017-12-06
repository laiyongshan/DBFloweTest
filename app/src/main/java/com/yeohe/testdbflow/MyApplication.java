package com.yeohe.testdbflow;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by Administrator on 2017/12/4.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(getApplicationContext());
    }
}
