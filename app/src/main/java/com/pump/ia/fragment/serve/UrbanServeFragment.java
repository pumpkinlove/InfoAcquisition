package com.pump.ia.fragment.serve;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baoyz.widget.PullRefreshLayout;
import com.pump.ia.R;
import com.pump.ia.adapter.CustomerAdapter;
import com.pump.ia.adapter.CustomerServeAdapter;
import com.pump.ia.adapter.PersonListAdapter;
import com.pump.ia.domain.Config;
import com.pump.ia.domain.ResponseEntity;
import com.pump.ia.domain.SimpleCustomer;
import com.pump.ia.domain.web.Citizen;
import com.pump.ia.domain.web.Page;
import com.pump.ia.domain.web.Person;
import com.pump.ia.domain.web.Worker;
import com.pump.ia.utils.CommonUtil;
import com.pump.ia.utils.XUtil;
import com.pump.ia.view.XListView;

import org.xutils.common.Callback;
import org.xutils.common.task.AbsTask;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class UrbanServeFragment extends Fragment implements XListView.IXListViewListener {

    private int page = 1;
    private boolean isClear;
    private int total = 0;

    private Worker worker;

    @ViewInject(R.id.xlv_serve_urban)
    private XListView xlv_serve_urban;

    private List<Person> citizenList;

    private CustomerServeAdapter adapter;

    public UrbanServeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_urban_serve, container, false);
        x.view().inject(this, v);

        initData();
        initView();

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadCitizenList();
    }

    private void initData(){
        worker = CommonUtil.geWorker();
        citizenList = new ArrayList<>();
        adapter = new CustomerServeAdapter(getContext());
        adapter.setPersonList(citizenList);
    }

    private void initView(){
        xlv_serve_urban.setPullLoadEnable(true);
        xlv_serve_urban.setPullRefreshEnable(true);
        xlv_serve_urban.setXListViewListener(this);
        xlv_serve_urban.setAdapter(adapter);
        xlv_serve_urban.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("--------","onItemClick");
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                CustomerServeFragment fragment = new CustomerServeFragment();
                ft.replace(R.id.fl_urban_serve, fragment);
                ft.commit();
            }
        });
    }

    private void loadCitizenList(){
        Log.e("---------","loadCitizenList" + page);
        Config config = CommonUtil.getConfig();
        Worker worker = CommonUtil.geWorker();
        if(config == null || worker == null){
            return;
        }
        String url  = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/citizen/findBbsCitizens";
        Log.e("---------",url);
        Map<String, Object> params = new HashMap<>();

        params.put("id", worker.getId());
        params.put("page", page);
        params.put("custName", "");
        params.put("orgNode", worker.getOrgNode());

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
                        CommonUtil.MyAlert(resp.getMessage(),getActivity().getFragmentManager(),"notice_list_error");
                        return;
                    }
                    if(isClear){
                        citizenList.clear();
                    }
                    Page<Citizen> personPage = resp.getPageData();
                    total = personPage.getTotal();
                    if(page > total){
                        Toast.makeText(getActivity(), "已经加载到最后一条", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    citizenList.addAll(personPage.getRows());
                    adapter.setPersonList(citizenList);
                    adapter.notifyDataSetChanged();

                }catch (Exception e){
                    Log.e("----3-----",e.toString());
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                CommonUtil.MyAlert(" >_< 网络开小差~",getActivity().getFragmentManager(),"notice_list_error");
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
        page = 1;
        isClear = true;
        loadCitizenList();
    }

    @Override
    public void onLoadMore() {
        isClear = false;
        page ++;
        loadCitizenList();
    }

    private void onLoad(){
        xlv_serve_urban.stopRefresh();
        xlv_serve_urban.stopLoadMore();
        xlv_serve_urban.setRefreshTime("刚刚");
    }
}
