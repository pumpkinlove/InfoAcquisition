package com.pump.ia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.domain.SimpleCustomer;
import com.pump.ia.domain.web.Person;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private List<Person> customerList;
    private Context context;
    private CustomerClickListener listener;

    public CustomerAdapter(List<Person> customerList, Context context) {
        this.customerList = customerList;
        this.context = context;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_customer, parent, false),listener);
    }

    @Override
    public void onBindViewHolder(CustomerViewHolder holder, int position) {

        holder.tv_customer_name.setText(customerList.get(position).getName());
        holder.tv_gender.setText(customerList.get(position).getSex());
        holder.tv_certificate.setText(customerList.get(position).getCardNo());
        holder.tv_mobile.setText(customerList.get(position).getMobile());

    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    static class CustomerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CustomerClickListener listener;
        @ViewInject(R.id.tv_customer_name)
        private TextView tv_customer_name;
        @ViewInject(R.id.tv_gender)
        private TextView tv_gender;
        @ViewInject(R.id.tv_certificate)
        private TextView tv_certificate;
        @ViewInject(R.id.tv_mobile)
        private TextView tv_mobile;
        @ViewInject(R.id.ll_customer)
        private LinearLayout ll_customer;

        public CustomerViewHolder(View itemView, CustomerClickListener listener) {
            super(itemView);
            x.view().inject(this, itemView);
            ll_customer.setOnClickListener(this);
            this.listener = listener;
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onItemClick(view, getPosition());
            }
        }
    }

    public interface CustomerClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(CustomerClickListener listener){
        this.listener = listener;
    }
}
