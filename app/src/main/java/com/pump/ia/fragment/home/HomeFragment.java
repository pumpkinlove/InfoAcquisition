package com.pump.ia.fragment.home;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.pump.ia.R;
import com.pump.ia.activity.home.ConfigActivity;
import com.pump.ia.domain.Version;
import com.pump.ia.utils.XUtil;
import com.pump.ia.view.JoshuaDialog;
import com.pump.ia.view.JoshuaUpdateDialog;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @ViewInject(R.id.title_middle)
    private TextView tv_middleContent;

    private JoshuaDialog logoutDialog;
    private JoshuaUpdateDialog updateDialog;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home, container, false);
        x.view().inject(this, v);

        initData();
        initView();

        return v;
    }

    private void initData() {
        logoutDialog = new JoshuaDialog();
        updateDialog = new JoshuaUpdateDialog();
    }

    private void initView() {
        tv_middleContent.setText("我");
    }

    @Event(value = R.id.ll_config)
    private void toConfig(View view){
        startActivity(new Intent(getActivity(), ConfigActivity.class));
    }

    @Event(value = R.id.ll_logout)
    private void logout(View view) {
        logoutDialog.setContent("您确定退出吗?");
        logoutDialog.setTitle("退出");
        logoutDialog.setConfirmListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        logoutDialog.setCancelListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutDialog.dismiss();
            }
        });
        logoutDialog.show(getActivity().getFragmentManager(), "JoshuaDialog");
    }

    @Event(value = R.id.ll_update)
    private void checkVersion(View view){
        Log.e("---------","checkVersion");
        String urlDemo = "http://192.168.5.123:8080/CIIPS_A/version/lastVersion.action";
        XUtil.Post(urlDemo, null, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("---------","onSuccess");
                Gson g = new Gson();
                Version lastVersion = g.fromJson(result, Version.class);
                try {
                    PackageManager manager = getActivity().getPackageManager();
                    PackageInfo info = manager.getPackageInfo(getActivity().getPackageName(), 0);
                    Version curVersion = new Version(info.versionName, info.versionCode);
                    if(lastVersion.getVersionCode() > curVersion.getVersionCode() ){
                        updateDialog.setLastVersion(lastVersion);
                        updateDialog.show(getActivity().getFragmentManager(),"update_dialog");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("---------","onError"+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("---------","onCancelled");
            }

            @Override
            public void onFinished() {
                Log.e("---------","onFinished");
            }
        });
    }

}
