package com.pump.ia.fragment.form.share;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.pump.ia.R;
import com.pump.ia.activity.form.UrbanFormActivity;
import com.pump.ia.adapter.FamilyMemberAdapter;
import com.pump.ia.domain.Config;
import com.pump.ia.domain.ResponseEntity;
import com.pump.ia.domain.web.Citizen;
import com.pump.ia.domain.web.FamilyMember;
import com.pump.ia.domain.web.Worker;
import com.pump.ia.utils.CommonUtil;
import com.pump.ia.utils.XUtil;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyMemberFragment extends Fragment {

    private Citizen citizen;

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
        citizen = ((UrbanFormActivity)getActivity()).getCitizen();
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
                switch (view.getId()){
                    case R.id.tv_save_family_member:
                        saveFamilyMember(position);
                        break;
                    case R.id.tv_del_family_member:
                        delFamilyMember(position);
                        break;
                }

            }
        });
    }

    @Event(value = R.id.tv_add_family_member)
    private void addFamilyMember(View view) {
        familyMemberList.add(new FamilyMember());
        familyMemberAdapter.notifyDataSetChanged();
    }

    private void saveFamilyMember(final int position){
        Config config = CommonUtil.getConfig();
        Worker worker = CommonUtil.geWorker();
        if(config == null || worker == null){
            return;
        }
        final FamilyMember f = familyMemberList.get(position);
        Log.e("name","F_"+f.getName());
        Log.e("relationship","F_"+f.getRelationship());
        Log.e("profession","F_"+f.getProfession());
        Log.e("yearIncome","F_"+f.getYearIncome());
        Log.e("marryStatus","F_"+f.getMarryStatus());
        Log.e("mobile","F_"+f.getMobile());
        Log.e("cardNo","F_"+f.getCardNo());

        if(citizen == null){
            citizen = new Citizen();
        }

        String url  = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/familyMember/addMember";
        Log.e("---------",url);
        Map<String, Object> params = new HashMap<>();
        params.put("familyCode", citizen.getFamilyCode());
        params.put("name", f.getName());
        params.put("relationship", f.getRelationship());
        params.put("profession", f.getProfession());
        params.put("yearIncome", f.getYearIncome());
        params.put("marryStatus", f.getMarryStatus());
        params.put("mobile", f.getMobile());
        params.put("cardNo", f.getCardNo());

        XUtil.Post(url, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    Log.e("-----2----",result);
                    ResponseEntity<String> resp = JSON.parseObject(
                            result,
                            new TypeReference<ResponseEntity<String>>() {}
                    );

                    if(!"200".equals(resp.getCode())){
                        CommonUtil.MyAlert(resp.getMessage(),getActivity().getFragmentManager(),"notice_list_error");
                        return;
                    }else{
                        f.setId(Integer.valueOf(resp.getData()));
                        Toast.makeText(getContext(),resp.getMessage(),Toast.LENGTH_LONG).show();
                        ((UrbanFormActivity)getActivity()).setCitizen(citizen);
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

    private void delFamilyMember(final int position){
        Config config = CommonUtil.getConfig();
        Worker worker = CommonUtil.geWorker();
        if(config == null || worker == null){
            return;
        }
        FamilyMember f = familyMemberList.get(position);
        Log.e("-------------","F_"+f.getName());

        if(citizen == null){
            citizen = new Citizen();
        }

        String url  = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/familyMember/deleteMemberByid";
        Log.e("---------",url);
        Map<String, Object> params = new HashMap<>();
        params.put("familyCode", citizen.getFamilyCode());
        params.put("id", f.getId());
        XUtil.Post(url, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    Log.e("-----2----",result);
                    ResponseEntity<String> resp = JSON.parseObject(
                            result,
                            new TypeReference<ResponseEntity<String>>() {}
                    );

                    if(!"200".equals(resp.getCode())){
                        CommonUtil.MyAlert(resp.getMessage(),getActivity().getFragmentManager(),"notice_list_error");
                        return;
                    }else{
                        familyMemberList.remove(position);
                        familyMemberAdapter.notifyDataSetChanged();
                        Toast.makeText(getContext(),"保存成功",Toast.LENGTH_LONG).show();
                        ((UrbanFormActivity)getActivity()).setCitizen(citizen);
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
