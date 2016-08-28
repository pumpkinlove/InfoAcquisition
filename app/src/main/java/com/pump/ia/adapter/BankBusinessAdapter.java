package com.pump.ia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.domain.sheetContent.BankBusiness;
import com.pump.ia.domain.web.MyBankBussiness;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by xu.nan on 2016/8/23.
 */
public class BankBusinessAdapter extends RecyclerView.Adapter<BankBusinessAdapter.BankBusinessViewHolder> {

    private List<MyBankBussiness> bankBusinessList;
    private Context context;
    private BankBusinessDelClickListener listener;

    public BankBusinessAdapter(List<MyBankBussiness> bankBusinessList, Context context){
        this.bankBusinessList = bankBusinessList;
        this.context = context;
    }

    @Override
    public BankBusinessViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BankBusinessViewHolder(LayoutInflater.from(context).inflate(R.layout.item_bank_business, parent, false), listener, bankBusinessList);
    }

    @Override
    public void onBindViewHolder(BankBusinessViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return bankBusinessList.size();
    }

    static class BankBusinessViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private BankBusinessDelClickListener listener;
        private List<MyBankBussiness> bankBusinessList;

        @ViewInject(R.id.tv_del_bank_business)
        private TextView tv_del_bank_business;

        @ViewInject(R.id.tv_save_bank_business)
        private TextView tv_save_bank_business;

        @ViewInject(R.id.bb_money)
        private EditText bb_money;
        @ViewInject(R.id.bb_start)
        private TextView bb_start;
        @ViewInject(R.id.bb_end)
        private TextView bb_end;


        public BankBusinessViewHolder(View itemView, BankBusinessDelClickListener listener, List<MyBankBussiness> bankBusinessList) {
            super(itemView);
            x.view().inject(this, itemView);
            this.listener = listener;
            this.bankBusinessList = bankBusinessList;
            tv_del_bank_business.setOnClickListener(this);
            tv_save_bank_business.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                bankBusinessList.get(getPosition()).setBeginDate(bb_start.getText().toString());
                bankBusinessList.get(getPosition()).setEndDate(bb_end.getText().toString());
                try {
                    bankBusinessList.get(getPosition()).setBusVal(Float.valueOf(bb_money.getText().toString()));
                } catch (Exception e) {
                    bankBusinessList.get(getPosition()).setBusVal(0);
                }
                listener.onItemClick(view,getPosition());
            }
        }
    }

    public interface BankBusinessDelClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(BankBusinessDelClickListener listener){
        this.listener = listener;
    }
}