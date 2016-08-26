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

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private List<SimpleCustomer> customerList;
    private Context context;
    private CustomerClickListener listener;

    public CustomerAdapter(List<SimpleCustomer> customerList, Context context) {
        this.customerList = customerList;
        this.context = context;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_customer, parent, false),listener);
    }

    @Override
    public void onBindViewHolder(CustomerViewHolder holder, int position) {

        holder.tv_name.setText(customerList.get(position).getName());
        holder.tv_type.setText(customerList.get(position).getType());
        holder.tv_follow.setText(customerList.get(position).getFollow());
        if("关注".equals(customerList.get(position).getFollow())){
            holder.tv_follow.setTextColor(context.getResources().getColor(R.color.green));

        }else if("未关注".equals(customerList.get(position).getFollow())){
            holder.tv_follow.setTextColor(context.getResources().getColor(R.color.red_dark));

        }

    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    static class CustomerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CustomerClickListener listener;
        @ViewInject(R.id.tv_customer_name)
        private TextView tv_name;
        @ViewInject(R.id.tv_customer_type)
        private TextView tv_type;
        @ViewInject(R.id.tv_follow)
        private TextView tv_follow;
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
            listener.onItemClick(view, getPosition());
        }
    }

    public interface CustomerClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(CustomerClickListener listener){
        this.listener = listener;
    }
}
