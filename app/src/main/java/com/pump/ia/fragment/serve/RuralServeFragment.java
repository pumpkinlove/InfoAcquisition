package com.pump.ia.fragment.serve;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baoyz.widget.PullRefreshLayout;
import com.pump.ia.R;
import com.pump.ia.adapter.CustomerAdapter;
import com.pump.ia.domain.SimpleCustomer;
import com.pump.ia.domain.web.Person;

import org.xutils.common.task.AbsTask;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class RuralServeFragment extends Fragment {

    @ViewInject(R.id.pr_rural)
    private PullRefreshLayout pr_rural;

    @ViewInject(R.id.rv_rural)
    private RecyclerView rv_rural;

    private List<Person> customerList;

    private CustomerAdapter adapter;

    public RuralServeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rural_serve, container, false);
        x.view().inject(this, v);

        initData();
        initView();

        return v;
    }

    private void initData(){
        customerList = new ArrayList<>();
//        adapter = new CustomerAdapter(customerList ,getContext());

    }

    private void initView(){

        rv_rural.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_rural.setAdapter(adapter);

        pr_rural.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                x.task().start(new AbsTask<String>() {
                    @Override
                    protected String doBackground() throws Throwable {
                        Thread.sleep(3000);
                        Person customer = new Person();
                        customer.setName("测试" + new Random().nextInt(100));
                        customerList.add(customer);

                        return "ok";
                    }

                    @Override
                    protected void onSuccess(String result) {
                        adapter.notifyDataSetChanged();
                        pr_rural.setRefreshing(false);
                    }

                    @Override
                    protected void onError(Throwable ex, boolean isCallbackError) {

                    }
                });
            }
        });
    }

}
