package com.zixu.officeassi;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.zixu.officeassi.bean.LoginBean;
import com.zixu.officeassi.utils.SharedPreferencesUtils;


public class Myapplication extends Application {
    public static LoginBean loginBean = new LoginBean();
    public static Context context;

    public static void getLogin() {
        Gson gson = new Gson();
        String user = SharedPreferencesUtils.getStringData(context, "user", "");

        if (!TextUtils.isEmpty(user)) {
            loginBean = gson.fromJson(user, LoginBean.class);
        }

    }

    @Override
    public void onCreate() {
        context = getApplicationContext();
        super.onCreate();
    }
}

