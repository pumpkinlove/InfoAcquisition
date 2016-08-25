package com.pump.ia.fragment.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.activity.home.ConfigActivity;
import com.pump.ia.view.JoshuaDialog;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @ViewInject(R.id.title_middle)
    private TextView tv_middleContent;

    private JoshuaDialog dialog;

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
         dialog = new JoshuaDialog();
    }

    private void initView() {
        tv_middleContent.setText("我");
    }

    @Event(value = R.id.ll_config, type = View.OnClickListener.class)
    private void toConfig(View view){
        startActivity(new Intent(getActivity(), ConfigActivity.class));
    }

    @Event(value = R.id.ll_logout)
    private void logout(View view) {
        dialog.setContent("您确定退出吗?");
        dialog.setTitle("退出");
        dialog.setConfirmListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        dialog.setCancelListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show(getActivity().getFragmentManager(), "JoshuaDialog");
    }

}
