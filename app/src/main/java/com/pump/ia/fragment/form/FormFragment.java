package com.pump.ia.fragment.form;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.activity.form.BusinessFormActivity;
import com.pump.ia.activity.form.RuralFormActivity;
import com.pump.ia.activity.form.ToPublicFormActivity;
import com.pump.ia.activity.form.UrbanFormActivity;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment {

    @ViewInject(R.id.title_middle)
    private TextView title_middle;

    public FormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form, container, false);
        x.view().inject(this, v);

        initData();
        initView();

        return v;

    }

    private void initData(){

    }

    private void initView(){
        title_middle.setText("表单");
    }

    @Event(value = {R.id.urbanForm,R.id.ruralForm,R.id.businessForm,R.id.toPublicForm})
    private void toFillForm(View view){
        switch (view.getId()){
            case R.id.urbanForm:
                startActivity(new Intent(getActivity(), UrbanFormActivity.class));
                break;
            case R.id.ruralForm:
                startActivity(new Intent(getActivity(), RuralFormActivity.class));
                break;
            case R.id.businessForm:
                startActivity(new Intent(getActivity(), BusinessFormActivity.class));
                break;
            case R.id.toPublicForm:
                startActivity(new Intent(getActivity(), ToPublicFormActivity.class));
                break;
        }
    }

}
