package com.pump.ia.application;

import android.app.Application;
import android.util.Log;

import com.pump.ia.domain.Config;
import com.pump.ia.utils.DbUtil;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
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

        DbManager.DaoConfig daoConfig = DbUtil.getDaoConfig();
        DbManager dbManager = x.getDb(daoConfig);
        try {
            Config config = dbManager.findFirst(Config.class);
            if(config == null){
                Log.e("----------","config");
                config = new Config();
                config.setId(1);
                config.setIp("119.29.36.54");
                config.setPort("8081");
                dbManager.save(config);
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
        super.onCreate();
    }
}
