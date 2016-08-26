package com.pump.ia.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.activity.BaseActivity;
import com.pump.ia.domain.Config;
import com.pump.ia.utils.DbUtil;

import org.xutils.DbManager;
import org.xutils.config.DbConfigs;
import org.xutils.ex.DbException;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_config)
public class ConfigActivity extends BaseActivity {

    @ViewInject(R.id.title_middle)
    private TextView title_middle;
    @ViewInject(R.id.title_left)
    private TextView title_left;

    @ViewInject(R.id.et_ip)
    private EditText et_ip;
    @ViewInject(R.id.et_port)
    private EditText et_port;

    private Config config;

    private DbManager dbManager;
    private DbManager.DaoConfig daoConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initData();
        initView();

    }

    @Override
    protected void initData() {
        daoConfig = DbUtil.getDaoConfig();
        dbManager = x.getDb(daoConfig);
        try {
            config = dbManager.findFirst(Config.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initView() {
        title_middle.setText("系统设置");
        title_left.setVisibility(View.VISIBLE);
        if(config != null){
            et_ip.setText(config.getIp());
            et_port.setText(config.getPort());
        }
    }

    @Event(value = R.id.title_left)
    private void goBack(View view) {
        finish();
    }

    @Event(value = R.id.tv_save)
    private void saveConfig(View view) {
        try {
            if(config != null){
                config.setId(1);
                config.setIp(et_ip.getText().toString());
                config.setPort(et_port.getText().toString());
                dbManager.saveOrUpdate(config);
            }
            finish();
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
