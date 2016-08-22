package com.pump.ia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.domain.sheetContent.FamilyMember;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public class FamilyMemberAdapter extends RecyclerView.Adapter<FamilyMemberAdapter.FamilyMemberViewHolder> {

    private List<FamilyMember> familyMemberList;
    private Context context;
    private FamilyMemberClickListener listener;

    public FamilyMemberAdapter(List<FamilyMember> familyMemberList, Context context){
        this.familyMemberList = familyMemberList;
        this.context = context;
    }

    @Override
    public FamilyMemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FamilyMemberViewHolder(LayoutInflater.from(context).inflate(R.layout.item_family_member, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(FamilyMemberViewHolder holder, int position) {
        
    }

    @Override
    public int getItemCount() {
        return familyMemberList.size();
    }


    static class FamilyMemberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private FamilyMemberClickListener listener;
        @ViewInject(R.id.tv_add_family_member)
        private TextView tv_add_family_member;

        public FamilyMemberViewHolder(View itemView, FamilyMemberClickListener listener) {
            super(itemView);
            x.view().inject(this, itemView);
            this.listener = listener;
            tv_add_family_member.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onItemClick(view,getPosition());
            }
        }
    }

    public interface FamilyMemberClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(FamilyMemberClickListener listener){
        this.listener = listener;
    }
}
