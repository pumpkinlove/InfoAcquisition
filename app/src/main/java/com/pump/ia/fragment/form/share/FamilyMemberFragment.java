package com.pump.ia.fragment.form.share;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pump.ia.R;
import com.pump.ia.domain.sheetContent.FamilyMember;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyMemberFragment extends Fragment {

    private List<FamilyMember> familyMemberList;

    public FamilyMemberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_family_member, container, false);
        x.view().inject(this, v);

        return  v;
    }

    private void initData(){
        familyMemberList = new ArrayList<>();
    }

}
