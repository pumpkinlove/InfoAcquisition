package com.pump.ia.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.pump.ia.R;
import com.pump.ia.domain.Version;
import com.pump.ia.utils.CommonUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements AMapLocationListener {

    @ViewInject(R.id.tv_version)
    private TextView tv_version;

    private Version curVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        super.onCreate(savedInstanceState);

        initData();
        initView();
    }

    @Override
    protected void initData() {

        curVersion = CommonUtil.getCurVersion(this);

    }

    @Override
    protected void initView() {
        x.view().inject(this);
        if(curVersion != null){
            tv_version.setText("版本号： V "+curVersion.getVersionName());
        }
    }

    @Event(value={R.id.tv_login},type=View.OnClickListener.class)
    private void login(View view) {

        startActivity(new Intent(LoginActivity.this, MainActivity.class));
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



    }

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
}
