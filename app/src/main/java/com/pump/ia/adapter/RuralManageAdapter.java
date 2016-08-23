package com.pump.ia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.domain.sheetContent.rural.BusinessProject;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by xu.nan on 2016/8/23.
 */
public class RuralManageAdapter extends RecyclerView.Adapter<RuralManageAdapter.RuralManageViewHolder> {

    private List<BusinessProject> businessProjectList;
    private Context context;
    private RuralManageDelClickListener listener;

    public RuralManageAdapter(List<BusinessProject> businessProjectList, Context context){
        this.businessProjectList = businessProjectList;
        this.context = context;
    }

    @Override
    public RuralManageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RuralManageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_rural_manage, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(RuralManageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return businessProjectList.size();
    }

    static class RuralManageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private RuralManageDelClickListener listener;
        @ViewInject(R.id.tv_del_rural_manage)
        private TextView tv_del_rural_manage;

        public RuralManageViewHolder(View itemView, RuralManageDelClickListener listener) {
            super(itemView);
            x.view().inject(this, itemView);
            this.listener = listener;
            tv_del_rural_manage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onItemClick(view,getPosition());
            }
        }
    }

    public interface RuralManageDelClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(RuralManageDelClickListener listener){
        this.listener = listener;
    }
}