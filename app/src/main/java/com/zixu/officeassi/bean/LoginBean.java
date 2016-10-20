package com.zixu.officeassi.bean;


//登录界面账号密码
public class LoginBean {

    private String Msg;
    private String name;
    private int offid;
    private int user_dep;
    private int userid;
    private boolean is_agree;
    private boolean is_LZ;

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOffid() {
        return offid;
    }

    public void setOffid(int offid) {
        this.offid = offid;
    }

    public int getUser_dep() {
        return user_dep;
    }

    public void setUser_dep(int user_dep) {
        this.user_dep = user_dep;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public boolean isIs_agree() {
        return is_agree;
    }

    public void setIs_agree(boolean is_agree) {
        this.is_agree = is_agree;
    }

    public boolean isIs_LZ() {
        return is_LZ;
    }

    public void setIs_LZ(boolean is_LZ) {
        this.is_LZ = is_LZ;
    }
}
