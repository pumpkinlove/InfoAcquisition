package com.pump.ia.fragment.serve;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pump.ia.R;

import org.xutils.view.annotation.Event;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerServeFragment extends Fragment {


    public CustomerServeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_serve, container, false);
    }

    @Event(value = R.id.tv_test2)
    private void gotest2(View view){
        
    }

}
