package com.pump.ia.fragment.serve;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class UrbanServeFragment extends Fragment {

    @ViewInject(R.id.tv_test)
    public TextView tv_test;

    public UrbanServeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_urban_serve, container, false);
        x.view().inject(this, v);

        return v;
    }

    @Event(value = R.id.tv_test)
    private void gotest(View view){
        testRecall t = (testRecall) getParentFragment();
        t.recall(view);
    }

    public interface testRecall{
        public void recall(View v);
    }

}
