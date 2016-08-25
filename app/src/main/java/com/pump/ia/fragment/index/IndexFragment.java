package com.pump.ia.fragment.index;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.adapter.NotificationAdapter;
import com.pump.ia.adapter.RemindAdapter;
import com.pump.ia.domain.Notification;
import com.pump.ia.domain.Remind;
import com.pump.ia.utils.DateUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment {

    @ViewInject(R.id.title_middle)
    private TextView title_middle;

    @ViewInject(R.id.rv_notification)
    private RecyclerView rv_notification;

    @ViewInject(R.id.rv_remind)
    private RecyclerView rv_remind;

    private NotificationAdapter notificationAdapter;
    private RemindAdapter remindAdapter;

    private List<Notification> notificationList;
    private List<Remind> remindList;

    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_index, container, false);
        x.view().inject(this,v);

        initData();
        initView();
        
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void initData() {
        notificationList = new ArrayList<>();
        Notification n = new Notification();
        n.setContent("圣旨");
        n.setTime(DateUtil.toMonthDay(new Date()));
        notificationList.add(n);
        notificationList.add(n);
        notificationList.add(n);
        notificationList.add(n);

        remindList = new ArrayList<>();
        Remind r = new Remind();
        r.setCustomerName("习近平");
        r.setDeposit("10000000");
        r.setExpire(DateUtil.toMonthDay(new Date()));
        r.setCustomerType("农村客户");
        remindList.add(r);
        remindList.add(r);
        remindList.add(r);
        remindList.add(r);
        remindList.add(r);
        remindList.add(r);
        remindList.add(r);
        remindList.add(r);


        notificationAdapter = new NotificationAdapter(notificationList, getContext());
        remindAdapter = new RemindAdapter(remindList, getContext());


    }

    private void initView() {
        title_middle.setText("首页");

        rv_notification.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_notification.setAdapter(notificationAdapter);
        rv_remind.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_remind.setAdapter(remindAdapter);
    }
}
