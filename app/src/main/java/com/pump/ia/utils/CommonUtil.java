package com.pump.ia.utils;

import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.Gravity;
import android.view.View;

import com.pump.ia.R;
import com.pump.ia.domain.Config;
import com.pump.ia.domain.Version;
import com.pump.ia.domain.web.Worker;
import com.pump.ia.view.JoshuaDialog;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

/**
 * Created by xu.nan on 2016/8/17.
 */
public class CommonUtil {

    public static Version getCurVersion(Context context) {
        try {
            Version v = new Version();
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            v.setVersionCode(info.versionCode);
            v.setVersionName(info.versionName);
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JoshuaDialog MyAlert(String content, FragmentManager fragmentManager, String tag){
        JoshuaDialog dialog = new JoshuaDialog();
        dialog.setContent(content);
        dialog.setErrorFlag(true);
        dialog.show(fragmentManager, tag);
        return dialog;
    }

    public static Config getConfig(){
        DbManager.DaoConfig daoConfig = DbUtil.getDaoConfig();
        DbManager dbManager = x.getDb(daoConfig);
        try {
            Config config = dbManager.findFirst(Config.class);
            return config;
        } catch (DbException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Worker geWorker(){
        DbManager.DaoConfig daoConfig = DbUtil.getDaoConfig();
        DbManager dbManager = x.getDb(daoConfig);
        try {
            Worker worker = dbManager.findFirst(Worker.class);
            return worker;
        } catch (DbException e) {
            e.printStackTrace();
            return null;
        }
    }

}
