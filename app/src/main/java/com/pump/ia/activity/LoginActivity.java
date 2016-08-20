package com.pump.ia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.activity.form.FormActivity;
import com.pump.ia.domain.Version;
import com.pump.ia.utils.CommonUtil;
import com.pump.ia.utils.XUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity {

    @ViewInject(R.id.tv_version)
    private TextView tv_version;

    private Version curVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        super.onCreate(savedInstanceState);

        initData();
        initView();
    }

    @Override
    protected void initData() {

        curVersion = CommonUtil.getCurVersion(this);

    }

    @Override
    protected void initView() {
        x.view().inject(this);
        if(curVersion != null){
            tv_version.setText("版本号： V "+curVersion.getVersionName());
        }
    }

    @Event(value={R.id.tv_login},type=View.OnClickListener.class)
    private void login(View view) {

        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }


}
