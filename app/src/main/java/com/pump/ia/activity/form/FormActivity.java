package com.pump.ia.activity.form;

import android.os.Bundle;
import android.transition.Fade;
import android.view.Window;

import com.pump.ia.R;
import com.pump.ia.activity.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;
@ContentView(R.layout.activity_form)
public class FormActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Fade().setDuration(1000));
        getWindow().setExitTransition(new Fade().setDuration(1000));
        super.onCreate(savedInstanceState);

        initData();
        initView();

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        x.view().inject(this);

    }
}
