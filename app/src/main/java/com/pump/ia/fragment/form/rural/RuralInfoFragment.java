package com.pump.ia.fragment.form.rural;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pump.ia.R;
import com.pump.ia.adapter.RuralManageAdapter;
import com.pump.ia.domain.sheetContent.rural.BusinessProject;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RuralInfoFragment extends Fragment {

    @ViewInject(R.id.rv_zhongzhi)
    private RecyclerView rv_zhongzhi;
    @ViewInject(R.id.rv_yangzhi)
    private RecyclerView rv_yangzhi;
    @ViewInject(R.id.rv_jingshang)
    private RecyclerView rv_jingshang;
    @ViewInject(R.id.rv_dagong)
    private RecyclerView rv_dagong;

    private RuralManageAdapter zhongzhiAdapter;
    private RuralManageAdapter yangzhizhiAdapter;
    private RuralManageAdapter jingshangAdapter;
    private RuralManageAdapter dagongAdapter;

    private List<BusinessProject> zhongzhiList = new ArrayList<>();
    private List<BusinessProject> yangzhiList = new ArrayList<>();
    private List<BusinessProject> jingshangList = new ArrayList<>();
    private List<BusinessProject> dagongList = new ArrayList<>();

    public RuralInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rural_info, container, false);
        x.view().inject(this, v);

        initData();
        initView();

        return v;
    }

    private void initData(){
        zhongzhiAdapter = new RuralManageAdapter(zhongzhiList, getContext());
        yangzhizhiAdapter = new RuralManageAdapter(yangzhiList, getContext());
        jingshangAdapter = new RuralManageAdapter(jingshangList, getContext());
        dagongAdapter = new RuralManageAdapter(dagongList, getContext());

    }

    private void initView(){

        rv_zhongzhi.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_yangzhi.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_jingshang.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_dagong.setLayoutManager(new LinearLayoutManager(getContext()));

        rv_zhongzhi.setAdapter(zhongzhiAdapter);
        rv_yangzhi.setAdapter(yangzhizhiAdapter);
        rv_jingshang.setAdapter(jingshangAdapter);
        rv_dagong.setAdapter(dagongAdapter);

        zhongzhiAdapter.setOnItemClickListener(new RuralManageAdapter.RuralManageDelClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                zhongzhiList.remove(position);
                zhongzhiAdapter.notifyDataSetChanged();
            }
        });

        yangzhizhiAdapter.setOnItemClickListener(new RuralManageAdapter.RuralManageDelClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                yangzhiList.remove(position);
                yangzhizhiAdapter.notifyDataSetChanged();
            }
        });

        jingshangAdapter.setOnItemClickListener(new RuralManageAdapter.RuralManageDelClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                jingshangList.remove(position);
                jingshangAdapter.notifyDataSetChanged();
            }
        });

        dagongAdapter.setOnItemClickListener(new RuralManageAdapter.RuralManageDelClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                dagongList.remove(position);
                dagongAdapter.notifyDataSetChanged();
            }
        });

    }

    @Event(value = R.id.tv_add_zhongzhi)
    private void addZhongzhi(View view){
        zhongzhiList.add(new BusinessProject("种植"));
        zhongzhiAdapter.notifyDataSetChanged();
    }

    @Event(value = R.id.tv_add_yangzhi)
    private void addYangzhi(View view){
        yangzhiList.add(new BusinessProject("养殖"));
        yangzhizhiAdapter.notifyDataSetChanged();
    }

    @Event(value = R.id.tv_add_jingshang)
    private void addJingshang(View view){
        jingshangList.add(new BusinessProject("经商"));
        jingshangAdapter.notifyDataSetChanged();
    }

    @Event(value = R.id.tv_add_dagong)
    private void addDagong(View view){
        dagongList.add(new BusinessProject("打工"));
        dagongAdapter.notifyDataSetChanged();
    }

}
