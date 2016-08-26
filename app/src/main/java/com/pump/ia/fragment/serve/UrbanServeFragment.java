package com.pump.ia.fragment.serve;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baoyz.widget.PullRefreshLayout;
import com.pump.ia.R;
import com.pump.ia.adapter.CustomerAdapter;
import com.pump.ia.domain.SimpleCustomer;

import org.xutils.common.task.AbsTask;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class UrbanServeFragment extends Fragment {

    @ViewInject(R.id.pr_urban)
    private PullRefreshLayout pr_urban;

    @ViewInject(R.id.rv_urban)
    private RecyclerView rv_urban;

    private List<SimpleCustomer> customerList;

    private CustomerAdapter adapter;

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

    private void initData(){
        customerList = new ArrayList<>();
        adapter = new CustomerAdapter(customerList ,getContext());
        adapter.setOnItemClickListener(new CustomerAdapter.CustomerClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("---------","open----------------");
                SimpleCustomer customer = customerList.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("customer",customer);
                CustomerServeFragment fragment = new CustomerServeFragment();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("urban_list");
                ft.add(R.id.fl_urban_serve, fragment);
                ft.commit();
            }
        });
    }

    private void initView(){

        rv_urban.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_urban.setAdapter(adapter);

        pr_urban.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                x.task().start(new AbsTask<String>() {
                    @Override
                    protected String doBackground() throws Throwable {
                        Thread.sleep(3000);
                        SimpleCustomer customer = new SimpleCustomer();
                        customer.setName("测试" + new Random().nextInt(100));
                        customer.setFollow("未关注");
                        customerList.add(customer);

                        return "ok";
                    }

                    @Override
                    protected void onSuccess(String result) {
                        adapter.notifyDataSetChanged();
                        pr_urban.setRefreshing(false);
                    }

                    @Override
                    protected void onError(Throwable ex, boolean isCallbackError) {

                    }
                });
            }
        });
    }

}
