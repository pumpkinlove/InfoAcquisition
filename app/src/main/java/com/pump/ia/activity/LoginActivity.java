package com.pump.ia.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.utils.L;
import com.pump.ia.R;
import com.pump.ia.domain.Config;
import com.pump.ia.domain.ResponseEntity;
import com.pump.ia.domain.Version;
import com.pump.ia.domain.web.Notice;
import com.pump.ia.domain.web.Worker;
import com.pump.ia.utils.CommonUtil;
import com.pump.ia.utils.DbUtil;
import com.pump.ia.utils.XUtil;

import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements AMapLocationListener {

    @ViewInject(R.id.tv_version)
    private TextView tv_version;

    private Version curVersion;

    @ViewInject(R.id.et_workercode)
    private TextView tv_workercode;
    @ViewInject(R.id.et_password)
    private TextView tv_password;

    private Worker worker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        super.onCreate(savedInstanceState);

        initData();
        initView();
    }

    @Override
    protected void initData() {
        try {
            worker = x.getDb(DbUtil.getDaoConfig()).findFirst(Worker.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        curVersion = CommonUtil.getCurVersion(this);

    }

    @Override
    protected void initView() {
        x.view().inject(this);
        if(curVersion != null){
            tv_version.setText("版本号： V "+curVersion.getVersionName());
        }
    }


//    private void login(View view) {
//        getSHA1(view);
//        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        //声明mLocationOption对象
//        AMapLocationClientOption mLocationOption = null;
//        AMapLocationClient mlocationClient = new AMapLocationClient(this);
//        //初始化定位参数
//        mLocationOption = new AMapLocationClientOption();
//        //设置返回地址信息，默认为true
//        mLocationOption.setNeedAddress(true);
//        //设置定位监听
//        mlocationClient.setLocationListener(this);
//        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
//        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//        //设置定位间隔,单位毫秒,默认为2000ms
//        mLocationOption.setInterval(5000);
//        //设置定位参数
//        mlocationClient.setLocationOption(mLocationOption);
//        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
//        // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
//        // 在定位结束后，在合适的生命周期调用onDestroy()方法
//        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
//        // 启动定位
//        mlocationClient.startLocation();


//    }

    private void getSHA1(View view){
        Log.e("==========",getSHA1(getApplicationContext()));
    }

    public static String getSHA1(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);

            byte[] cert = info.signatures[0].toByteArray();

            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0XFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1)
                    hexString.append("0");
                hexString.append(appendString);
                hexString.append(":");
            }
            return hexString.toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                amapLocation.getLatitude();//获取纬度
                amapLocation.getLongitude();//获取经度
                amapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(amapLocation.getTime());
                df.format(date);//定位时间
                amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                amapLocation.getCountry();//国家信息
                amapLocation.getProvince();//省信息
                amapLocation.getCity();//城市信息
                amapLocation.getDistrict();//城区信息
                amapLocation.getStreet();//街道信息
                amapLocation.getStreetNum();//街道门牌号信息
                amapLocation.getCityCode();//城市编码
                amapLocation.getAdCode();//地区编码
                Log.e("国家信息",amapLocation.getCountry());
                Log.e("省信息",amapLocation.getProvince());
                Log.e("城市信息",amapLocation.getCity());
                Log.e("城区信息",amapLocation.getDistrict());
                Log.e("街道信息",amapLocation.getStreet());
                Log.e("街道门牌号信息",amapLocation.getStreetNum());
//                amapLocation.getAOIName();//获取当前定位点的AOI信息
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError","location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
            }
        }
    }

    @Event(value={R.id.tv_login},type=View.OnClickListener.class)
    private void login(View view){
        if(tv_workercode.getText().length() == 0 || tv_password.getText().length() == 0){
            return;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("workerCode", tv_workercode.getText().toString());
        params.put("password", tv_password.getText().toString());
        Config config = CommonUtil.getConfig();
        String url = "http://"+config.getIp()+":"+config.getPort()+"/customer/mobile/worker/login";
        Log.e("----",url);
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("正在登录...");
        pd.setCanceledOnTouchOutside(false);
        pd.show();
        XUtil.Post(url, params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson g = new Gson();
                ResponseEntity<Worker> resp = JSON.parseObject(
                        result,
                        new TypeReference<ResponseEntity<Worker>>() {}
                );

                Log.e("---------",resp.getCode());
                Log.e("---------",resp.getMessage());

                if(!"200".equals(resp.getCode())){
                    CommonUtil.MyAlert(resp.getMessage(),getFragmentManager(),"login_error");
                    return;
                }

                try {
                    if(worker == null){
                        worker = resp.getData();
                        if(worker == null){
                            Log.e("---------","null");
                            return;
                        }
                        Log.e("---------",worker.getId()+"");
                        x.getDb(DbUtil.getDaoConfig()).save(worker);
                    }else{
                        worker = resp.getData();
                        if(worker == null){
                            Log.e("---------","null");
                            return;
                        }
                        x.getDb(DbUtil.getDaoConfig()).saveOrUpdate(worker);
                    }
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } catch (Exception e) {
                    Log.e("-----eee----",e.getMessage());
                    e.printStackTrace();
                }
                Log.e("----","onSuccess");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                CommonUtil.MyAlert(" >_< 网络开小差啦 ~",getFragmentManager(),"network_error");
                Log.e("----","onError"+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("----","onCancelled");
            }

            @Override
            public void onFinished() {
                pd.dismiss();
                Log.e("----","onFinished");
            }
        });
    }


}
