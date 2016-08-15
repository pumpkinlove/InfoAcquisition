package com.pump.ia.fragment.serve;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pump.ia.R;
import com.pump.ia.adapter.MyFragmentAdapter;
import com.pump.ia.fragment.BaseFragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServeFragment extends Fragment {

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

    public ServeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_serve, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        x.view().inject(view);
        init();
    }

    private void init(){

        if(tl_serve == null || vp_serve == null){
            Log.e("=============","null");
            tl_serve = (TabLayout) getActivity().findViewById(R.id.tl_serve);
            vp_serve = (ViewPager) getActivity().findViewById(R.id.vp_serve);
            if(tl_serve == null || vp_serve == null){
                Log.e("=============","null");
                return;
            }
        }

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
        vp_serve.setAdapter(adapter);
        vp_serve.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl_serve));
        tl_serve.setupWithViewPager(vp_serve);

    }

}
