package com.zixu.officeassi.utils;


import com.zixu.officeassi.bean.LoginBean;

/**
 * Created by wenjie on 16/8/16.
 */
public class CheckUtils {
    public static LoginBean loginBean=new LoginBean();


    public static boolean isLogin(){
        if (loginBean==null){
            return false;
        }else {
            return true;
        }
    }
}
