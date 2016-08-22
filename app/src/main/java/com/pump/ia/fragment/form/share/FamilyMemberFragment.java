package com.pump.ia.fragment.form.share;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pump.ia.R;
import com.pump.ia.adapter.FamilyMemberAdapter;
import com.pump.ia.domain.sheetContent.FamilyMember;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyMemberFragment extends Fragment {

    private List<FamilyMember> familyMemberList;

    @ViewInject(R.id.rv_family_member)
    private RecyclerView rv_family_member;

    private FamilyMemberAdapter familyMemberAdapter;

    public FamilyMemberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_family_member, container, false);
        x.view().inject(this, v);

        initData();
        initView();

        return  v;
    }

    private void initData(){
        familyMemberList = new ArrayList<>();
        familyMemberList.add(new FamilyMember());
        familyMemberAdapter = new FamilyMemberAdapter(familyMemberList, this.getContext());
    }

    private void initView(){
        rv_family_member.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_family_member.setAdapter(familyMemberAdapter);
        familyMemberAdapter.setOnItemClickListener(new FamilyMemberAdapter.FamilyMemberClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                familyMemberList.remove(position);
                familyMemberAdapter.notifyDataSetChanged();
            }
        });
    }

    @Event(value = R.id.tv_add_family_member)
    private void addFamilyMember(View view){
        familyMemberList.add(new FamilyMember());
        familyMemberAdapter.notifyDataSetChanged();
    }

}
