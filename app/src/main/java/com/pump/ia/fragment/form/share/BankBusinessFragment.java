package com.pump.ia.fragment.form.share;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pump.ia.R;
import com.pump.ia.adapter.BankBusinessAdapter;
import com.pump.ia.domain.sheetContent.BankBusiness;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BankBusinessFragment extends Fragment {

    private List<BankBusiness> depositBankBusinessList;

    private List<BankBusiness> loanBankBusinessList;

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
                depositBankBusinessList.remove(position);
                depositAdapter.notifyDataSetChanged();
            }
        });

        rv_bank_business_loan.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_bank_business_loan.setAdapter(loanAdapter);
        loanAdapter.setOnItemClickListener(new BankBusinessAdapter.BankBusinessDelClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                loanBankBusinessList.remove(position);
                loanAdapter.notifyDataSetChanged();
            }
        });
    }

    @Event(value = R.id.tv_add_bank_business_deposit)
    private void addBankBusinessDeposit(View view){
        depositBankBusinessList.add(new BankBusiness());
        depositAdapter.notifyDataSetChanged();

    }

    @Event(value = R.id.tv_add_bank_business_loan)
    private void addBankBusinessLoan(View view){
        loanBankBusinessList.add(new BankBusiness());
        loanAdapter.notifyDataSetChanged();
    }

}
