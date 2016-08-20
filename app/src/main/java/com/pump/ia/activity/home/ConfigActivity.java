package com.pump.ia.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.activity.BaseActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initData();
        initView();

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        title_middle.setText("系统设置");
        title_left.setVisibility(View.VISIBLE);
    }

    @Event(value = R.id.title_left)
    private void goBack(View view){
        finish();
    }
}
