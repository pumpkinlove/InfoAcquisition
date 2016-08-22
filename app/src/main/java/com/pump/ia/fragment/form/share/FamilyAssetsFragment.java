package com.pump.ia.fragment.form.share;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pump.ia.R;
import com.pump.ia.domain.sheetContent.FamilyAssets;

import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyAssetsFragment extends Fragment {

    private FamilyAssets familyAssets;

    public FamilyAssets getFamilyAssets(){

        return familyAssets;
    }

    public FamilyAssetsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_family_assets, container, false);
        x.view().inject(this, v);
        return v;
    }

}
