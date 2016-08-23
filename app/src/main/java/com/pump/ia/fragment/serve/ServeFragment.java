package com.pump.ia.fragment.serve;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.activity.serve.SearchActivity;
import com.pump.ia.adapter.MyFragmentAdapter;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServeFragment extends Fragment implements UrbanServeFragment.testRecall {

    private MyFragmentAdapter adapter;
    private List<Fragment> fragmentList;
    private BusinessServeFragment businessServeFragment;
    private PublicServeFragment publicServeFragment;
    private RuralServeFragment ruralServeFragment;
    private UrbanServeFragment urbanServeFragment;

    @ViewInject(R.id.tl_serve)
    private TabLayout tl_serve;
    @ViewInject(R.id.vp_serve)
    private ViewPager vp_serve;

    @ViewInject(R.id.title_middle)
    private TextView tv_middleContent;
    @ViewInject(R.id.title_right)
    private TextView tv_rightContent;
    @ViewInject(R.id.title_right_icon)
    private TextView tv_rightIcon;

    public ServeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_serve, container, false);
        x.view().inject(this,v);

        initData();
        initView();

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initData(){
        businessServeFragment = new BusinessServeFragment();
        publicServeFragment = new PublicServeFragment();
        ruralServeFragment = new RuralServeFragment();
        urbanServeFragment = new UrbanServeFragment();

        fragmentList = new ArrayList<>();
        fragmentList.add(urbanServeFragment);
        fragmentList.add(ruralServeFragment);
        fragmentList.add(businessServeFragment);
        fragmentList.add(publicServeFragment);
        adapter = new MyFragmentAdapter(getChildFragmentManager(),fragmentList);

    }

    private void initView(){
        vp_serve.setOffscreenPageLimit(20);
        vp_serve.setAdapter(adapter);
        vp_serve.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl_serve));
        tl_serve.setupWithViewPager(vp_serve);
        String[] titles = {"城镇客户","农村客户","个体工商户","对公"};
        for(int i=0; i< tl_serve.getTabCount(); i++){
            TabLayout.Tab tab = tl_serve.getTabAt(i);
            if(tab != null){
                tab.setText(titles[i]);
            }
        }

        tv_rightContent.setVisibility(View.GONE);
        tv_rightIcon.setVisibility(View.VISIBLE);
        tv_middleContent.setText("客户服务");

    }

    @Event(value = {R.id.title_right_icon}, type = View.OnClickListener.class)
    private void toSearch(View view) {
        startActivity(new Intent(getActivity(), SearchActivity.class));
    }

    @Override
    public void recall(View v) {
        Snackbar.make(v,"--------"+urbanServeFragment.tv_test.getText(),Snackbar.LENGTH_LONG).show();

        getFragmentManager().beginTransaction().add(R.id.fl_serve, new CustomerServeFragment()).commit();

    }
}
