package com.pump.ia.fragment.form.urban;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.pump.ia.R;
import com.pump.ia.activity.form.UrbanFormActivity;
import com.pump.ia.domain.Config;
import com.pump.ia.domain.ResponseEntity;
import com.pump.ia.domain.web.Citizen;
import com.pump.ia.domain.web.Worker;
import com.pump.ia.utils.CommonUtil;
import com.pump.ia.utils.XUtil;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class CareerFragment extends Fragment {

    @ViewInject(R.id.f_career)
    private EditText f_career;
    @ViewInject(R.id.f_work)
    private EditText f_work;
    @ViewInject(R.id.f_job)
    private EditText f_job;
    @ViewInject(R.id.f_industry)
    private EditText f_industry;
    @ViewInject(R.id.f_department)
    private EditText f_department;
    @ViewInject(R.id.f_isOrg)
    private EditText f_isOrg;

    private Citizen citizen;

    public CareerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_career, container, false);
        x.view().inject(this, v);

        initData();

        return v;
    }

    private void initData(){
        citizen = ((UrbanFormActivity)getActivity()).getCitizen();
        if(citizen == null){
            Log.e("---------","citizen is null");
            citizen = new Citizen();
        }
    }

    @Event(value = R.id.tv_form_save)
    private void saveForm(View view){
        Config config = CommonUtil.getConfig();
        Worker worker = CommonUtil.geWorker();
        if(config == null || worker == null){
            return;
        }
        citizen.setProfession("1");
        citizen.setUnit(f_work.getText().toString());
        citizen.setPost("1");
        citizen.setUnitIndustry("1");
        citizen.setDept(f_department.getText().toString());
        citizen.setFormally("1");

        String url  = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/citizen/updateBaseInfo";
        Log.e("---------",url);
        Map<String, Object> params = new HashMap<>();
        params.put("cardNo", citizen.getCardNo());
        params.put("profession", citizen.getProfession());
        params.put("unit", citizen.getUnit());
        params.put("post", citizen.getPost());
        params.put("unitIndustry", citizen.getUnitIndustry());
        params.put("dept", citizen.getDept());
        params.put("formally", citizen.getFormally());

        XUtil.Post(url, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    Log.e("-----2----",result);
                    ResponseEntity<Citizen> resp = JSON.parseObject(
                            result,
                            new TypeReference<ResponseEntity<Citizen>>() {}
                    );

                    if(!"200".equals(resp.getCode())){
                        CommonUtil.MyAlert(resp.getMessage(),getActivity().getFragmentManager(),"career_error");
                        return;
                    }else{
                        Toast.makeText(getContext(),"保存成功",Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e){
                    Log.e("----e-----",e.toString());
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                CommonUtil.MyAlert(" >_< 网络开小差~", getActivity().getFragmentManager(),"notice_list_error");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
            }
        });
    }

}
