package com.pump.ia.fragment.form.share;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pump.ia.R;

import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyLiabilitiesFragment extends Fragment {


    public FamilyLiabilitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_family_liabilities, container, false);
        x.view().inject(this, v);
        return v;
    }

}
