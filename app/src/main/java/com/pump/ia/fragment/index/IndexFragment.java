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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baoyz.widget.PullRefreshLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pump.ia.R;
import com.pump.ia.adapter.BirthdayAdapter;
import com.pump.ia.adapter.NotificationAdapter;
import com.pump.ia.adapter.RemindAdapter;
import com.pump.ia.domain.Config;
import com.pump.ia.domain.Notification;
import com.pump.ia.domain.Remind;
import com.pump.ia.domain.ResponseEntity;
import com.pump.ia.domain.web.MyBankBussiness;
import com.pump.ia.domain.web.Notice;
import com.pump.ia.domain.web.Page;
import com.pump.ia.domain.web.Person;
import com.pump.ia.domain.web.Worker;
import com.pump.ia.utils.CommonUtil;
import com.pump.ia.utils.DateUtil;
import com.pump.ia.utils.XUtil;

import org.xutils.common.Callback;
import org.xutils.common.task.AbsTask;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ViewInject(R.id.rv_birthday)
    private RecyclerView rv_birthday;

    @ViewInject(R.id.pr_notification)
    private PullRefreshLayout pr_notification;

    @ViewInject(R.id.pr_remind)
    private PullRefreshLayout pr_remind;

    @ViewInject(R.id.pr_birthday)
    private PullRefreshLayout pr_birthday;

    private NotificationAdapter notificationAdapter;
    private RemindAdapter remindAdapter;
    private BirthdayAdapter birthdayAdapter;

//    private List<Notification> notificationList;
    private List<MyBankBussiness> remindList;
    private List<Notice> noticeList;
    private List<Person> birthdayList;

    private Worker worker;

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
        downLoadNotice();
        downLoadRemind();
        downLoadBirthday();
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void initData() {

        worker = CommonUtil.geWorker();

        noticeList = new ArrayList<>();
        remindList = new ArrayList<>();
        birthdayList = new ArrayList<>();

        notificationAdapter = new NotificationAdapter(noticeList, getContext());
        remindAdapter = new RemindAdapter(remindList, getContext());
        birthdayAdapter = new BirthdayAdapter(birthdayList, getContext());

    }

    private void initView() {
        title_middle.setText("首页");

        rv_notification.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_notification.setAdapter(notificationAdapter);
        pr_notification.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                downLoadNotice();
            }
        });

        rv_remind.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_remind.setAdapter(remindAdapter);
        pr_remind.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                downLoadRemind();
            }
        });

        rv_birthday.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_birthday.setAdapter(birthdayAdapter);
        pr_birthday.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                downLoadBirthday();
            }
        });

    }

    private void downLoadNotice(){
        Config config = CommonUtil.getConfig();
        if(config == null){
            return;
        }
        String url  = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/notice/findNewNotices";
        Log.e("---------",url);
        Map<String, Object> params = new HashMap<>();

        params.put("orgNode", worker.getOrgNode());
        XUtil.Post(url, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    Log.e("-----2----",result);
                    ResponseEntity<Notice> resp = JSON.parseObject(
                            result,
                            new TypeReference<ResponseEntity<Notice>>() {}
                    );
                    System.out.println(resp.getCode());
                    System.out.println(resp.getListData().get(0).getCreateUser());

                    Log.e("-----2----",resp.getCode());
                    Log.e("-----3----",resp.getMessage());

                    if(!"200".equals(resp.getCode())){
                        CommonUtil.MyAlert(resp.getMessage(),getActivity().getFragmentManager(),"notice_list_error");
                        return;
                    }
                    noticeList.clear();
                    noticeList.addAll(resp.getListData());

                    Log.e("------------", noticeList.size()+"---"+noticeList.get(0).getCreateDate());
                    notificationAdapter.notifyDataSetChanged();
                }catch (Exception e){
                    Log.e("----3-----",e.toString());
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                pr_notification.setRefreshing(false);
            }
        });

    }

    private void downLoadRemind(){
        Config config = CommonUtil.getConfig();
        if(config == null){
            return;
        }
        String url  = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/myBankBussiness/findExpiredMyBankBussiness";
        Log.e("---------",url);
        Map<String, Object> params = new HashMap<>();
        params.put("orgNode", worker.getOrgNode());
        params.put("exptype", "unexpired");
        params.put("page", 1);
        params.put("rows", 5);
        XUtil.Post(url, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    Log.e("-----2----",result);
                    ResponseEntity<MyBankBussiness> resp = JSON.parseObject(
                            result,
                            new TypeReference<ResponseEntity<MyBankBussiness>>() {}
                    );

                    Log.e("-----2----",resp.getCode());
                    Log.e("-----3----",resp.getMessage());

                    if(!"200".equals(resp.getCode())){
                        CommonUtil.MyAlert(resp.getMessage(),getActivity().getFragmentManager(),"notice_list_error");
                        return;
                    }

                    Page<MyBankBussiness> myBankBussinessPage = resp.getPageData();
                    Log.e("---------",""+resp.getPageData().getRows().size());
                    remindList.clear();
                    remindList.addAll(myBankBussinessPage.getRows());
                    remindAdapter.notifyDataSetChanged();

                }catch (Exception e){
                    Log.e("----3-----",e.toString());
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                pr_remind.setRefreshing(false);
            }
        });

    }

    private void downLoadBirthday(){
        Config config = CommonUtil.getConfig();
        if(config == null){
            return;
        }
        String url  = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/person/findPersonsByWeek";
        Log.e("---------",url);
        Map<String, Object> params = new HashMap<>();
        params.put("orgNode", worker.getOrgNode());
        params.put("page", 1);
        params.put("rows", 5);
        params.put("offset", 7);

        XUtil.Post(url, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    Log.e("-----2----",result);
                    ResponseEntity<Person> resp = JSON.parseObject(
                            result,
                            new TypeReference<ResponseEntity<Person>>() {}
                    );

                    Log.e("-----2----",resp.getCode());
                    Log.e("-----3----",resp.getMessage());

                    if(!"200".equals(resp.getCode())){
                        CommonUtil.MyAlert(resp.getMessage(),getActivity().getFragmentManager(),"notice_list_error");
                        return;
                    }

                    Page<Person> personPage = resp.getPageData();
                    birthdayList.clear();
                    birthdayList.addAll(personPage.getRows());
                    birthdayAdapter.notifyDataSetChanged();

                }catch (Exception e){
                    Log.e("----3-----",e.toString());
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                pr_birthday.setRefreshing(false);
            }
        });

    }

}
