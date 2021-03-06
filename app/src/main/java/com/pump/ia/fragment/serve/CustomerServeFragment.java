package com.pump.ia.fragment.serve;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baoyz.widget.PullRefreshLayout;
import com.pump.ia.R;
import com.pump.ia.adapter.ServeAdapter;
import com.pump.ia.domain.SimpleCustomer;
import com.pump.ia.domain.serve.Serve;

import org.xutils.common.task.AbsTask;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerServeFragment extends Fragment {

    @ViewInject(R.id.title_left)
    private TextView title_left;

    @ViewInject(R.id.title_middle)
    private TextView title_middle;

    private List<Serve> serveList;
    private ServeAdapter serveAdapter;

    @ViewInject(R.id.pr_customer_serve_list)
    private PullRefreshLayout pr_customer_serve_list;

    @ViewInject(R.id.rv_customer_serve_list)
    private RecyclerView rv_customer_serve_list;

    private FragmentManager fm;
    private FragmentTransaction ft;

    private SimpleCustomer customer;

    public CustomerServeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_customer_serve, container, false);
        x.view().inject(this, v);

        initData();
        initView();

        return v;
    }

    private void initData(){


        serveList = new ArrayList<>();
        Serve s1 = new Serve();
        s1.setName("徐一楠");
        s1.setContent("lalalalalalalala撒发射点发生广泛大概vbafgasfasfasfsd撒大沙发飞洒冯绍峰如繁花暖暖");
        s1.setTime("2016-05-55");
        s1.setType("电话回访");
        s1.setAddress("啊暑假放假啊可是");
        s1.setCommentNum("回复： 12");
        Serve s2 = new Serve();
        s2.setName("徐一楠");
        s2.setContent("lalalalalalalala撒发射点发生广泛大概vbafgasfasfasfsd撒大沙发飞洒冯绍峰如繁花暖暖");
        s2.setTime("2016-05-55");
        s2.setType("电话回访");
        s2.setAddress("啊暑假放假啊可是");
        s1.setCommentNum("回复： 12");
        Serve s3 = new Serve();
        s3.setName("徐一楠");
        s3.setContent("lalalalalalalala撒发射点发生广泛大概vbafgasfasfasfsd撒大沙发飞洒冯绍峰如繁花暖暖");
        s3.setTime("2016-05-55");
        s3.setType("电话回访");
        s3.setAddress("啊暑假放假啊可是");
        s1.setCommentNum("回复： 12");
        serveList.add(s1);
        serveList.add(s2);
        serveList.add(s3);
        serveList.add(s1);
        serveList.add(s2);
        serveList.add(s3);
        serveList.add(s1);
        serveList.add(s2);
        serveList.add(s3);
        serveList.add(s1);
        serveList.add(s2);
        serveList.add(s3);
        serveList.add(s1);
        serveList.add(s2);
        serveList.add(s3);


        serveAdapter = new ServeAdapter(serveList, getContext());
        fm = getFragmentManager();


    }

    private void initView(){

        rv_customer_serve_list.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_customer_serve_list.setAdapter(serveAdapter);
        serveAdapter.setOnItemClickListener(new ServeAdapter.ServeListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("------","itemclick");
                ft = fm.beginTransaction();
                ft.addToBackStack("fragment_customer_serve");
                CommentFragment commentFragment = new CommentFragment();
                ft.replace(R.id.fl_customer_serve, commentFragment);
                ft.commit();
            }
        });

        pr_customer_serve_list.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                x.task().start(new AbsTask<String>() {
                    @Override
                    protected String doBackground() throws Throwable {
                        Thread.sleep(3000);
                        return "ok";
                    }

                    @Override
                    protected void onSuccess(String result) {
                        pr_customer_serve_list.setRefreshing(false);
                    }

                    @Override
                    protected void onError(Throwable ex, boolean isCallbackError) {

                    }
                });
            }
        });


//        title_left.setVisibility(View.VISIBLE);


    }

    @Event(R.id.title_left)
    private void goBack(View view){
        ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.remove(this);
        ft.commit();
    }

}
