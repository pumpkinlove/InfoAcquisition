package com.pump.ia.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10 0010.
 */
public class ActivityAdapter extends PagerAdapter {

    private String[] titles;

    private List<Activity> activityList;


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
