package com.pump.ia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.domain.web.FamilyMember;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

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
        return new FamilyMemberViewHolder(LayoutInflater.from(context).inflate(R.layout.item_family_member, parent, false), listener, familyMemberList);
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
        @ViewInject(R.id.tv_del_family_member)
        private TextView tv_del_family_member;

        @ViewInject(R.id.tv_save_family_member)
        private TextView tv_save_family_member;

        @ViewInject(R.id.f_family_name)
        private EditText f_family_name;

        @ViewInject(R.id.f_family_relationship)
        private Spinner f_family_relationship;

        @ViewInject(R.id.f_family_career)
        private EditText f_family_career;

        @ViewInject(R.id.f_family_annual_income)
        private EditText f_family_annual_income;

        @ViewInject(R.id.f_family_marry_state)
        private Spinner f_family_marry_state;

        @ViewInject(R.id.f_family_mobile)
        private EditText f_family_mobile;

        @ViewInject(R.id.f_family_certificate)
        private EditText f_family_certificate;

        private List<FamilyMember> familyMemberList;

        public FamilyMemberViewHolder(View itemView, FamilyMemberClickListener listener, List<FamilyMember> familyMemberList) {
            super(itemView);
            x.view().inject(this, itemView);
            this.listener = listener;
            this.familyMemberList = familyMemberList;
            tv_del_family_member.setOnClickListener(this);
            tv_save_family_member.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                FamilyMember f = familyMemberList.get(getPosition());
                f.setName(f_family_name.getText().toString());
                f.setRelationship("1");
                f.setProfession("1");
                f.setYearIncome(Float.valueOf(f_family_annual_income.getText().toString()));
                f.setMarryStatus("1");
                f.setMobile(f_family_mobile.getText().toString());
                f.setCardNo(f_family_certificate.getText().toString());
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
