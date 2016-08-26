package com.pump.ia.utils;

import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.Gravity;
import android.view.View;

import com.pump.ia.R;
import com.pump.ia.domain.Version;
import com.pump.ia.view.JoshuaDialog;

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

}
