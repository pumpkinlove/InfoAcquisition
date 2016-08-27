package com.pump.ia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.domain.Remind;
import com.pump.ia.domain.web.MyBankBussiness;
import com.pump.ia.domain.web.Person;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class BirthdayAdapter extends RecyclerView.Adapter<BirthdayAdapter.BirthdayViewHolder> {

    private List<Person> remindList;
    private Context context;
    private BirthdayListener listener;

    public BirthdayAdapter(List<Person> remindList, Context context) {
        this.remindList = remindList;
        this.context = context;
    }

    @Override
    public BirthdayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BirthdayViewHolder(LayoutInflater.from(context).inflate(R.layout.item_birthday, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(BirthdayViewHolder holder, int position) {
        holder.tv_name.setText(remindList.get(position).getName());
        holder.tv_type.setText(remindList.get(position).getCustTypeVal());
        holder.tv_birthday.setText(remindList.get(position).getBirthday()+"");
        holder.tv_phone_num.setText(remindList.get(position).getMobile());
    }

    @Override
    public int getItemCount() {
        return remindList.size();
    }

    static class BirthdayViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @ViewInject(R.id.tv_name)
        private TextView tv_name;
        @ViewInject(R.id.tv_type)
        private TextView tv_type;
        @ViewInject(R.id.tv_birthday)
        private TextView tv_birthday;
        @ViewInject(R.id.tv_phone_num)
        private TextView tv_phone_num;

        private BirthdayListener listener;

        public BirthdayViewHolder(View itemView, BirthdayListener listener) {
            super(itemView);
            x.view().inject(this, itemView);
            this.listener = listener;
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());
        }
    }

    interface BirthdayListener{
        void onItemClick(View view, int position);
    }
}
