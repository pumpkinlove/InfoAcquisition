package com.pump.ia.fragment.form.share;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.pump.ia.R;
import com.pump.ia.domain.sheetContent.PersonInfo;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonInfoFragment extends Fragment {


    private PersonInfo personInfo = new PersonInfo();

    @ViewInject(R.id.sp_marry_status)
    private Spinner sp_marry_status;
    @ViewInject(R.id.sp_cetificate_type)
    private Spinner sp_cetificate_type;

    public PersonInfo getPersonInfo() {
        return personInfo;
    }



    public PersonInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_person_info, container, false);
        x.view().inject(this, v);

        initData();
        initView();

        return v;
    }

    private void initData(){

    }

    private void initView(){

        String[] marry_status = getResources().getStringArray(R.array.marry_status);
        sp_marry_status.setAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, marry_status));
        String[] cetificate_status = getResources().getStringArray(R.array.certificateType);
        sp_cetificate_type.setAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, cetificate_status));


    }

}
