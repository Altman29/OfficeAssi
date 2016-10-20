package com.zixu.officeassi.bean;


import java.util.List;
//用户登录后信息
public class UserBean {

    public List<DataListBean> data;

    public List<DataListBean> getData() {
        return data;
    }

    public void setData(List<DataListBean> data) {
        this.data = data;
    }

    public class DataListBean{

        private int sys_id;
        private String ApplyNum;
        private String mc_kem;
        private String big_cagegory;
        private int status;
        private Object username;
        private Object time;
        private int is_hq;

        public int getSys_id() {
            return sys_id;
        }

        public void setSys_id(int sys_id) {
            this.sys_id = sys_id;
        }

        public String getApplyNum() {
            return ApplyNum;
        }

        public void setApplyNum(String ApplyNum) {
            this.ApplyNum = ApplyNum;
        }

        public String getMc_kem() {
            return mc_kem;
        }

        public void setMc_kem(String mc_kem) {
            this.mc_kem = mc_kem;
        }

        public String getBig_cagegory() {
            return big_cagegory;
        }

        public void setBig_cagegory(String big_cagegory) {
            this.big_cagegory = big_cagegory;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
            this.username = username;
        }

        public Object getTime() {
            return time;
        }

        public void setTime(Object time) {
            this.time = time;
        }

        public int getIs_hq() {
            return is_hq;
        }

        public void setIs_hq(int is_hq) {
            this.is_hq = is_hq;
        }
    }


}

