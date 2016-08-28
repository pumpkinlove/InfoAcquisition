package com.pump.ia.activity.form;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.pump.ia.R;
import com.pump.ia.activity.BaseActivity;
import com.pump.ia.adapter.PersonListAdapter;
import com.pump.ia.domain.Config;
import com.pump.ia.domain.ResponseEntity;
import com.pump.ia.domain.web.Citizen;
import com.pump.ia.domain.web.Page;
import com.pump.ia.domain.web.Person;
import com.pump.ia.domain.web.Worker;
import com.pump.ia.utils.CommonUtil;
import com.pump.ia.utils.XUtil;
import com.pump.ia.view.XListView;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContentView(R.layout.activity_urban_list)
public class UrbanListActivity extends BaseActivity implements XListView.IXListViewListener {

    @ViewInject(R.id.pv_urban_list)
    private XListView pv_urban_list;

    @ViewInject(R.id.title_middle)
    private TextView title_middle;

    @ViewInject(R.id.title_left)
    private TextView title_left;

    private List<Person> personList;
    private int start = 1;
    private int total = 0;
    private boolean isClear;

    private PersonListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        initData();
        initView();
        loadCitizenList();
    }

    @Override
    protected void initData() {
        personList = new ArrayList<>();
        listAdapter = new PersonListAdapter(this);
        listAdapter.setPersonList(personList);
    }

    @Override
    protected void initView() {
        title_left.setVisibility(View.VISIBLE);
        title_middle.setText("城镇客户");
        pv_urban_list.setPullLoadEnable(true);
        pv_urban_list.setPullRefreshEnable(true);
        pv_urban_list.setXListViewListener(this);
        pv_urban_list.setAdapter(listAdapter);
    }


    private void loadCitizenList(){
        Log.e("---------","loadCitizenList" + start);
        Config config = CommonUtil.getConfig();
        Worker worker = CommonUtil.geWorker();
        if(config == null || worker == null){
            return;
        }
        String url  = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/citizen/findCitizensByOrgCode";
        Log.e("---------",url);
        Map<String, Object> params = new HashMap<>();
        params.put("page", start);
        params.put("orgCode", worker.getOrgCode());

        XUtil.Post(url, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    Log.e("-----2----",result);
                    ResponseEntity<Citizen> resp = JSON.parseObject(
                            result,
                            new TypeReference<ResponseEntity<Citizen>>() {}
                    );

                    if(!"200".equals(resp.getCode())){
                        CommonUtil.MyAlert(resp.getMessage(),getFragmentManager(),"notice_list_error");
                        return;
                    }
                    if(isClear){
                        personList.clear();
                    }
                    Page<Citizen> personPage = resp.getPageData();
                    total = personPage.getTotal();
                    if(start > total){
                        Toast.makeText(UrbanListActivity.this, "已经加载到最后一条", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    personList.addAll(personPage.getRows());
                    listAdapter.setPersonList(personList);
                    listAdapter.notifyDataSetChanged();

                    Log.e("---------","onSuccess" + start +"total" + total);
                }catch (Exception e){
                    Log.e("----3-----",e.toString());
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                CommonUtil.MyAlert(" >_< 网络开小差~",getFragmentManager(),"notice_list_error");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                onLoad();
            }
        });
    }

    @Override
    public void onRefresh() {
        start = 1;
        isClear = true;
        loadCitizenList();
    }

    @Override
    public void onLoadMore() {
        isClear = false;
        start ++;
        loadCitizenList();
    }

    private void onLoad(){
        pv_urban_list.stopRefresh();
        pv_urban_list.stopLoadMore();
        pv_urban_list.setRefreshTime("刚刚");
    }

    @Event(value = R.id.fab_submit_form_urban)
    private void urban_form_submit(View view){
        startActivity(new Intent(UrbanListActivity.this, UrbanFormActivity.class));
    }

    @Event(value = R.id.title_left)
    private void goBack(View view){
        finish();
    }

}
