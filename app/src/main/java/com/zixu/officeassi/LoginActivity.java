package com.zixu.officeassi;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import com.zhy.autolayout.AutoLayoutActivity;
import com.zixu.officeassi.bean.LoginBean;
import com.zixu.officeassi.utils.ACallOkHttp;
import com.zixu.officeassi.utils.HttpOH;
import com.zixu.officeassi.utils.SharedPreferencesUtils;


public class LoginActivity extends AutoLayoutActivity {

    private EditText et_login_name;
    private EditText et_login_pwd;
    private String name;
    private String pwd;
    private String imei;
    private Button bt_login;
    private boolean isoncl = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //扎控件
        et_login_name = (EditText) findViewById(R.id.et_login_name);
        et_login_pwd = (EditText) findViewById(R.id.et_login_pwd);
        bt_login = (Button) findViewById(R.id.bt_login);

        getImei();

        //设置点击事件
        bt_login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                if (isoncl) {
                    //你要运行的方法
                    isoncl = false; //点击一次后就改成false，这样就实现只点击一次了
                }
            }
        });

    }


    //获取设备识别号
    private void getImei() {
        TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        imei = TelephonyMgr.getDeviceId();
        Log.i("我是设备识别号码", imei);
        SharedPreferencesUtils.saveStringData(getApplicationContext(), "imei", imei);

    }

    //登录操作
    private void login() {

        //获取账号密码
        name = et_login_name.getText().toString().trim();
        pwd = et_login_pwd.getText().toString().trim();


        //验证
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(getApplicationContext(), "用户名密码不能为空", Toast.LENGTH_SHORT).show();
        }
        //服务器获取数据

        RequestBody formBody = new FormEncodingBuilder()
                .add("loginname", name).add("loginpwd", pwd).add("imei", imei)
                .build();

        HttpOH.postData(getString(R.string.loginPort), formBody, new ACallOkHttp() {
            @Override
            public void onBeforeRequest(int tag) {

            }

            @Override
            public void onResultRequest(int tag, Object bean) {
                Log.i("访问成功", "======");
                LoginBean loginrBean = (LoginBean) bean;
                //int i = ((LoginBean) bean).getUserid();

                if (loginrBean.getMsg().equals("true")) {
                    Gson gson = new Gson();
                    SharedPreferencesUtils.saveStringData(getApplicationContext(), "user", gson.toJson(loginrBean));

                    Myapplication.getLogin();

                    Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ApproveActivity.class);

                    startActivity(intent);
                } else {
                    if (imei.length() < 15) {
                        Toast.makeText(getApplicationContext(), "设备识别码少于15位", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onErrorRequest(int tag, String e) {
                Log.i("登录失败-----", "======");

            }
        }, LoginBean.class, 1);

    }

}




