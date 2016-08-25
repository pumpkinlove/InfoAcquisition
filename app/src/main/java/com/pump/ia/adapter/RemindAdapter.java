package com.pump.ia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.domain.Remind;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class RemindAdapter extends RecyclerView.Adapter<RemindAdapter.RemindViewHolder> {

    private List<Remind> remindList;
    private Context context;
    private RemindListener listener;

    public RemindAdapter(List<Remind> remindList, Context context) {
        this.remindList = remindList;
        this.context = context;
    }

    @Override
    public RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RemindViewHolder(LayoutInflater.from(context).inflate(R.layout.item_remind, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(RemindViewHolder holder, int position) {
        holder.tv_name.setText(remindList.get(position).getCustomerName());
        holder.tv_type.setText(remindList.get(position).getCustomerType());
        holder.tv_money.setText(remindList.get(position).getDeposit());
        holder.tv_time.setText(remindList.get(position).getExpire());
    }

    @Override
    public int getItemCount() {
        return remindList.size();
    }

    static class RemindViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @ViewInject(R.id.tv_remind_name)
        private TextView tv_name;
        @ViewInject(R.id.tv_remind_type)
        private TextView tv_type;
        @ViewInject(R.id.tv_remind_money)
        private TextView tv_money;
        @ViewInject(R.id.tv_remind_time)
        private TextView tv_time;

        private RemindListener listener;

        public RemindViewHolder(View itemView, RemindListener listener) {
            super(itemView);
            x.view().inject(this, itemView);
            this.listener = listener;
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());
        }
    }

    interface RemindListener{
        void onItemClick(View view, int position);
    }
}
