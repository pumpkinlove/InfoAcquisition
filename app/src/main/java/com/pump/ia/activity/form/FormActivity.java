package com.pump.ia.activity.form;

import android.os.Bundle;

import com.pump.ia.R;
import com.pump.ia.activity.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;
@ContentView(R.layout.activity_form)
public class FormActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        x.view().inject(this);

    }
}
