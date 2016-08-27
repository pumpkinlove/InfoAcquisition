package com.pump.ia.utils;

import android.os.Environment;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * Created by xu.nan on 2016/7/27.
 */
public class DbUtil {
    static DbManager.DaoConfig daoConfig;
    public static DbManager.DaoConfig getDaoConfig(){
        File file = new File(Environment.getExternalStorageDirectory().getPath());
        if(daoConfig == null){
            daoConfig = new DbManager.DaoConfig()
                    .setDbName("IA.db")
                    .setDbDir(file)
                    .setDbVersion(1)
                    .setAllowTransaction(true)
                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                        @Override
                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                        }
                    });
        }
        return daoConfig;
    }

}
