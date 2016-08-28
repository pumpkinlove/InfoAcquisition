package com.pump.ia.fragment.form.share;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.pump.ia.R;
import com.pump.ia.activity.form.UrbanFormActivity;
import com.pump.ia.adapter.BankBusinessAdapter;
import com.pump.ia.domain.Config;
import com.pump.ia.domain.ResponseEntity;
import com.pump.ia.domain.sheetContent.BankBusiness;
import com.pump.ia.domain.web.Citizen;
import com.pump.ia.domain.web.FamilyMember;
import com.pump.ia.domain.web.MyBankBussiness;
import com.pump.ia.domain.web.Worker;
import com.pump.ia.utils.CommonUtil;
import com.pump.ia.utils.XUtil;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class BankBusinessFragment extends Fragment {

    private Citizen citizen;

    private List<MyBankBussiness> depositBankBusinessList;

    private List<MyBankBussiness> loanBankBusinessList;

    @ViewInject(R.id.rv_bank_business_deposit)
    private RecyclerView rv_bank_business_deposit;

    @ViewInject(R.id.rv_bank_business_loan)
    private RecyclerView rv_bank_business_loan;

    private BankBusinessAdapter depositAdapter;
    private BankBusinessAdapter loanAdapter;

    public BankBusinessFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bank_business, container, false);
        x.view().inject(this, v);

        initData();
        initView();

        return v;
    }

    private void initData(){
        citizen = ((UrbanFormActivity)getActivity()).getCitizen();
        depositBankBusinessList = new ArrayList<>();
        loanBankBusinessList = new ArrayList<>();
        depositAdapter = new BankBusinessAdapter(depositBankBusinessList, getContext());
        loanAdapter = new BankBusinessAdapter(loanBankBusinessList, getContext());
    }

    private void initView(){
        rv_bank_business_deposit.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_bank_business_deposit.setAdapter(depositAdapter);
        depositAdapter.setOnItemClickListener(new BankBusinessAdapter.BankBusinessDelClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (view.getId()){
                    case R.id.tv_save_bank_business:
                        saveBankBusiness(depositBankBusinessList, position);
                        break;
                    case R.id.tv_del_bank_business:
                        delBankBusiness(depositBankBusinessList, position);
                        break;
                }
            }
        });

        rv_bank_business_loan.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_bank_business_loan.setAdapter(loanAdapter);
        loanAdapter.setOnItemClickListener(new BankBusinessAdapter.BankBusinessDelClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (view.getId()){
                    case R.id.tv_save_bank_business:
                        saveBankBusiness(loanBankBusinessList, position);
                        break;
                    case R.id.tv_del_bank_business:
                        delBankBusiness(loanBankBusinessList, position);
                        break;
                }
            }
        });
    }

    @Event(value = R.id.tv_add_bank_business_deposit)
    private void addBankBusinessDeposit(View view){
        MyBankBussiness m = new MyBankBussiness();
        m.setBankBusType("deposit");
        depositBankBusinessList.add(m);
        depositAdapter.notifyDataSetChanged();

    }

    @Event(value = R.id.tv_add_bank_business_loan)
    private void addBankBusinessLoan(View view){
        MyBankBussiness m = new MyBankBussiness();
        m.setBankBusType("loan");
        loanBankBusinessList.add(m);
        loanAdapter.notifyDataSetChanged();
    }

    private void saveBankBusiness(List<MyBankBussiness> myBankBussinessList ,final int position){
        Config config = CommonUtil.getConfig();
        Worker worker = CommonUtil.geWorker();
        if(config == null || worker == null){
            return;
        }
        final MyBankBussiness m = myBankBussinessList.get(position);

        if(citizen == null){
            citizen = new Citizen();
        }

        String url  = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/myBankBussiness/addMyBankBussiness";
        Log.e("---------",url);
        Map<String, Object> params = new HashMap<>();
        params.put("id", m.getId());
        params.put("bankBusType", m.getBankBusType());
        params.put("beginDate", m.getBeginDate());
        params.put("endDate", m.getEndDate());
        params.put("busVal", m.getBusVal());
        params.put("cardNo", citizen.getCardNo());
        params.put("orgCode", citizen.getOrgCode());
        params.put("orgNode", citizen.getOrgNode());

        XUtil.Post(url, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    Log.e("-----2----",result);
                    ResponseEntity<String> resp = JSON.parseObject(
                            result,
                            new TypeReference<ResponseEntity<String>>() {}
                    );

                    if(!"200".equals(resp.getCode())){
                        CommonUtil.MyAlert(resp.getMessage(),getActivity().getFragmentManager(),"notice_list_error");
                        return;
                    }else{
                        m.setId(Integer.valueOf(resp.getData()));
                        Toast.makeText(getContext(),resp.getMessage(),Toast.LENGTH_LONG).show();
                        ((UrbanFormActivity)getActivity()).setCitizen(citizen);
                    }
                }catch (Exception e){
                    Log.e("----e-----",e.toString());
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("-------",ex.toString());
                CommonUtil.MyAlert(" >_< 网络开小差~", getActivity().getFragmentManager(),"notice_list_error");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
            }
        });
    }

    private void delBankBusiness(final List<MyBankBussiness> myBankBussinessList , final int position){
        Config config = CommonUtil.getConfig();
        Worker worker = CommonUtil.geWorker();
        if(config == null || worker == null){
            return;
        }
        MyBankBussiness m = myBankBussinessList.get(position);

        if(citizen == null){
            citizen = new Citizen();
        }

        String url  = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/myBankBussiness/deleteMyBankBussinessId";
        Log.e("---------",url);
        Map<String, Object> params = new HashMap<>();
        params.put("familyCode", citizen.getFamilyCode());
        params.put("id", m.getId());
        XUtil.Post(url, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    Log.e("-----2----",result);
                    ResponseEntity<String> resp = JSON.parseObject(
                            result,
                            new TypeReference<ResponseEntity<String>>() {}
                    );

                    if(!"200".equals(resp.getCode())){
                        CommonUtil.MyAlert(resp.getMessage(),getActivity().getFragmentManager(),"notice_list_error");
                        return;
                    }else{
                        myBankBussinessList.remove(position);
                        depositAdapter.notifyDataSetChanged();
                        loanAdapter.notifyDataSetChanged();
                        Toast.makeText(getContext(),"保存成功",Toast.LENGTH_LONG).show();
                        ((UrbanFormActivity)getActivity()).setCitizen(citizen);
                    }
                }catch (Exception e){
                    Log.e("----e-----",e.toString());
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                CommonUtil.MyAlert(" >_< 网络开小差~", getActivity().getFragmentManager(),"notice_list_error");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
            }
        });
    }

}
