package com.pump.ia.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Window;

import com.pump.ia.R;
import com.pump.ia.adapter.MyFragmentAdapter;
import com.pump.ia.fragment.form.FormFragment;
import com.pump.ia.fragment.home.HomeFragment;
import com.pump.ia.fragment.index.IndexFragment;
import com.pump.ia.fragment.serve.ServeFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.tl_main)
    private TabLayout tl_main;
    @ViewInject(R.id.vp_main)
    private ViewPager vp_main;

    private MyFragmentAdapter adapter;
    private List<Fragment> fragmentList;
    private IndexFragment indexFragment;
    private FormFragment formFragment;
    private HomeFragment homeFragment;
    private ServeFragment serveFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        initView();
        initTabLayout();

    }

    @Override
    protected void initData() {

        indexFragment = new IndexFragment();
        formFragment = new FormFragment();
        homeFragment = new HomeFragment();
        serveFragment = new ServeFragment();


        fragmentList = new ArrayList<>();
        fragmentList.add(indexFragment);
        fragmentList.add(formFragment);
        fragmentList.add(serveFragment);
        fragmentList.add(homeFragment);

        adapter = new MyFragmentAdapter(getSupportFragmentManager(),fragmentList);


    }

    @Override
    protected void initView() {
        x.view().inject(this);
        vp_main.setAdapter(adapter);
        vp_main.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl_main));
        tl_main.setupWithViewPager(vp_main);
        vp_main.setOffscreenPageLimit(20);

    }

    private void initTabLayout(){

        String[] titles = {"首页","表单","服务","我"};

        List<Drawable> drawableList = new ArrayList<>();
        Drawable tab_drawable = getResources().getDrawable(R.drawable.tab1_n);
        tab_drawable.setTint(getResources().getColor(R.color.gray_dark));
        drawableList.add(tab_drawable);
        tab_drawable = getResources().getDrawable(R.drawable.tab2_n);
        tab_drawable.setTint(getResources().getColor(R.color.gray_dark));
        drawableList.add(tab_drawable);
        tab_drawable = getResources().getDrawable(R.drawable.tab3_n);
        tab_drawable.setTint(getResources().getColor(R.color.gray_dark));
        drawableList.add(tab_drawable);
        tab_drawable = getResources().getDrawable(R.drawable.tab4_n);
        tab_drawable.setTint(getResources().getColor(R.color.gray_dark));
        drawableList.add(tab_drawable);

        for(int i=0; i< tl_main.getTabCount(); i++){
            TabLayout.Tab tab = tl_main.getTabAt(i);
            if(tab != null){
                tab.setText(titles[i]);
                tab.setIcon(drawableList.get(i));
            }
        }
    }
}
