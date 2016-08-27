package com.pump.ia.fragment.form.share;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.pump.ia.R;
import com.pump.ia.domain.Config;
import com.pump.ia.domain.ResponseEntity;
import com.pump.ia.domain.sheetContent.PersonInfo;
import com.pump.ia.domain.web.Citizen;
import com.pump.ia.domain.web.Page;
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
public class PersonInfoFragment extends Fragment {

    private Citizen citizen;

    private DatePickerDialog datePickerDialog;

    private PersonInfo personInfo = new PersonInfo();

    @ViewInject(R.id.sp_marry_status)
    private Spinner sp_marry_status;
    @ViewInject(R.id.sp_cetificate_type)
    private Spinner sp_cetificate_type;

    @ViewInject(R.id.f_birthday)
    private TextView f_birthday;

    @ViewInject(R.id.f_name)
    private EditText f_name;
    @ViewInject(R.id.f_gender)
    private EditText f_gender;
    @ViewInject(R.id.f_race)
    private EditText f_race;
    @ViewInject(R.id.f_certificate)
    private EditText f_certificate;
    @ViewInject(R.id.f_mobile)
    private EditText f_mobile;
    @ViewInject(R.id.f_address)
    private EditText f_address;

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
        citizen = new Citizen();
    }

    private void initView(){

        String[] marry_status = getResources().getStringArray(R.array.marry_status);
        sp_marry_status.setAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, marry_status));
        String[] cetificate_status = getResources().getStringArray(R.array.certificateType);
        sp_cetificate_type.setAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, cetificate_status));


    }


    @Event(value = R.id.tv_form_save)
    private void saveForm(View view){
        Config config = CommonUtil.getConfig();
        Worker worker = CommonUtil.geWorker();
        if(config == null || worker == null){
            return;
        }

        citizen.setName(f_name.getText().toString());
        citizen.setSex("1");
        citizen.setNation("1");
        citizen.setMarryStatus("1");
        citizen.setCardType("1");
        citizen.setCardNo(f_certificate.getText().toString());
        citizen.setBirthday(f_birthday.getText().toString());
        citizen.setMobile(f_mobile.getText().toString());
        citizen.setAddress(f_address.getText().toString());
        citizen.setOrgCode(worker.getOrgCode());
        citizen.setOrgNode(worker.getOrgNode());

        String url  = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/citizen/addCitizen";
        Log.e("---------",url);
        Map<String, Object> params = new HashMap<>();
        params.put("name", citizen.getName());
        params.put("sex", citizen.getSex());
        params.put("nation", citizen.getNation());
        params.put("marryStatus", citizen.getMarryStatus());
        params.put("cardType", citizen.getCardType());
        params.put("cardNo", citizen.getCardNo());
        params.put("birthday", citizen.getBirthday());
        params.put("mobile", citizen.getMobile());
        params.put("address", citizen.getAddress());
        params.put("orgCode", citizen.getOrgCode());
        params.put("orgNode", citizen.getOrgNode());

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
                        CommonUtil.MyAlert(resp.getMessage(),getActivity().getFragmentManager(),"notice_list_error");
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
