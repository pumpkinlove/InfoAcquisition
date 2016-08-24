package com.pump.ia.application;

import android.app.Application;
import android.util.Log;

import org.xutils.x;

import static com.amap.api.location.AMapLocationClient.setApiKey;

/**
 * Created by xu.nan on 2016/8/17.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        Log.e("initXutils","----------------");
        x.Ext.init(this);
        super.onCreate();
    }
}
