package com.zixu.officeassi;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zixu.officeassi.bean.DetailBean;
import com.zixu.officeassi.bean.UserBean;
import com.zixu.officeassi.utils.ACallOkHttp;
import com.zixu.officeassi.utils.HttpOH;
import com.zixu.officeassi.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;


public class Contract1Activity extends AutoLayoutActivity implements View.OnClickListener {

    private TextView tv_party;
    private TextView tv_is_newuser;
    private TextView tv_is_xk;
    private TextView tv_needYh;
    private TextView tv_mthy;
    private TextView tv_cmon_mon;
    private TextView tv_cmon_monbig;
    private TextView tv_isWhite;
    private TextView tv_contr_stime;
    private TextView tv_contr_etime;
    private TextView tv_st_da;
    private TextView tv_end_da;
    private TextView tv_cj_policy;
    private TextView tv_cj_policymemo;
    private TextView tv_gskh_policy;
    private TextView tv_gskh_policymemo;
    private ImageView iv_approvefanhui;
    private TextView tv_num;
    private TextView tv_username;
    private TextView tv_userdep;
    private TextView tv_createtime;
    private TextView tv_ys_gstype;
    private TextView tv_ys_gs;
    private TextView tv_big_cagegory;
    private TextView tv_small_category;
    private TextView tv_detail_category;
    private TextView tv_khzc;
    private TextView tv_khzcCA;
    private TextView tv_khzcTYMD;
    private TextView tv_khje;
    private TextView tv_khjeYMD;
    private TextView tv_con_vq;
    private TextView tv_agent;
    private TextView tv_agentYMD;
    private TextView tv_cmon_cost;
    private TextView tv_mtgsname;
    private TextView tv_istui;
    private TextView tv_ps;
    private TextView tv_dlname;
    private TextView tv_dlfan;
    private TextView tv_maoDanger1;
    private TextView tv_maoDanger2;
    private TextView tv_maoDanger3;
    private TextView tv_plinfo;
    private TextView tv_plMemo;
    private TextView tv_xyTotalMomey;
    private TextView tv_baseMoneyR;
    private TextView tv_basePer;
    private TextView tv_baseMoney;
    private TextView tv_overBy;
    private TextView tv_goodTo;
    private TextView tv_changePer;
    private TextView tv_changeReason;
    private TextView tv_otherXyBz;
    private TextView tv_sfwp;
    private TextView tv_sfMoney;
    private TextView tv_userDay;
    private TextView tv_userDayDMY;
    private TextView tv_userMoney;
    private TextView tv_adMoney;
    private TextView tv_yhPerson;
    private TextView tv_appAPP;
    private TextView tv_otherConMemo;
    private TextView tv_otherConMemo1;
    private TextView tv_bank;
    private TextView tv_accountName;
    private TextView tv_cardNum;
    private TextView tv_fpType;
    private TextView tv_fpCont;
    private TextView tv_fpOther;
    private TextView tv_fpTitler;
    private TextView tv_fPmemo;
    private TextView tv_con_bg;
    private TextView tv_specialNeed;
    private TextView tv_teamSay;
    private TextView tv_addSay;
    private TextView tv_maoli_hs;
    private TextView tv_maoli_hs1;
    private TextView tv_maoli_hs_jg;
    private TextView tv_js_qd;
    private TextView tv_js_qd1;
    private TextView tv_js_qd_jg;
    private TextView tv_js_hh;
    private TextView tv_auditInfo;
    private TextView tv_waitPer;
    private int sys_id;
    private TextView tv_fuht;
    private TextView tv_mainht;
    private DetailBean dataBean;
    private int agreeType;
    private String ratifyremark;
    private String checkId;
    private TextView tv_huiqian;
    private String mainUrl;
    private String fuUrl;
    private List<UserBean.DataListBean> userBean = new ArrayList<UserBean.DataListBean>();
    private int is_hq;
    private boolean isoncl = true;
    private String maoli_hs;
    private LinearLayout ll_button;
    private TextView tv1_maoli_hs;
    private TextView tv1_maoli_hs1;
    private TextView tv1_maoli_hs_jg;
    private TextView tv1_js_hh;
    private TextView tv1_js_qd;
    private TextView tv1_js_qd1;
    private TextView tv1_js_qd_jg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract1);
        sys_id = getIntent().getIntExtra("sys_id", 0);
        is_hq = getIntent().getIntExtra("is_hq", 0);
        findViews();
        postData();
        iv_approvefanhui.setOnClickListener(this);


    }


    private void postData() {

        RequestBody formBody = new FormEncodingBuilder()
                .add("id", sys_id + "").add("uid", Myapplication.loginBean.getUserid() + "")
                .add("oid", Myapplication.loginBean.getOffid() + "")
                .add("imei", SharedPreferencesUtils.getStringData(getApplicationContext(), "imei", ""))
                .build();

        HttpOH.postData(getString(R.string.detailsPort), formBody, new ACallOkHttp() {


            @Override
            public void onBeforeRequest(int tag) {

            }

            //###2.给字段设置参数
            @Override
            public void onResultRequest(int tag, Object bean) {
                //从服务器活取得数据设置给具体字段
                dataBean = (DetailBean) bean;
                if (dataBean != null) {
                    tv_num.setText(dataBean.getNum());
                    tv_party.setText(dataBean.getParty());
                    tv_username.setText(dataBean.getUsername());
                    tv_userdep.setText(dataBean.getUserdep());
                    tv_createtime.setText(dataBean.getCreatetime());
                    //我司盖章主体
                    if (TextUtils.isEmpty(dataBean.getYs_gstype())) {
                        tv_ys_gstype.setVisibility(View.GONE);
                    } else {
                        tv_ys_gstype.setText(dataBean.getYs_gstype());
                    }
                    //我司盖章主体
                    if (TextUtils.isEmpty(dataBean.getYs_gs())) {
                        tv_ys_gs.setVisibility(View.GONE);
                    } else {
                        tv_ys_gs.setText(dataBean.getYs_gs());
                    }

                    //业务大类
                    tv_big_cagegory.setText(dataBean.getBig_cagegory());
                    //业务小类
                    tv_small_category.setText(dataBean.getSmall_category());
                    //业务明细
                    tv_detail_category.setText(dataBean.getDetail_category());
                    //是否为新开客户
                    if (TextUtils.isEmpty(dataBean.getIs_newuser())) {
                        tv_is_newuser.setVisibility(View.GONE);
                    } else {
                        tv_is_newuser.setText(dataBean.getIs_newuser());
                    }
                    //是否为新开
                    if (TextUtils.isEmpty(dataBean.getIs_xk())) {
                        tv_is_xk.setVisibility(View.GONE);
                    } else {
                        tv_is_xk.setText(dataBean.getIs_xk());
                    }
                    //是否需要优化服务
                    if (TextUtils.isEmpty(dataBean.getNeedYh())) {
                        tv_needYh.setVisibility(View.GONE);
                    } else {
                        tv_needYh.setText(dataBean.getNeedYh());
                    }
                    //媒体行业
                    tv_mthy.setText(dataBean.getMTHY());
                    //合同金额
                    tv_cmon_mon.setText(dataBean.getCmon_mon() + "");
                    //合同金额大写
                    tv_cmon_monbig.setText(dataBean.getCmon_monbig());
                    //是否为白单
                    tv_isWhite.setText(dataBean.getIsWhite());
                    //合同开始时间
                    tv_contr_stime.setText(dataBean.getContr_stime());
                    //合同结束时间
                    tv_contr_etime.setText(dataBean.getContr_etime());

                    //投放时间
                    if (TextUtils.isEmpty(dataBean.getSt_da())) {
                        tv_st_da.setVisibility(View.GONE);
                    } else {
                        tv_st_da.setText(dataBean.getSt_da());
                    }

                    //投放时间段结束
                    if (TextUtils.isEmpty(dataBean.getEnd_da())) {
                        tv_end_da.setVisibility(View.GONE);
                    } else {
                        tv_end_da.setText(dataBean.getEnd_da());
                    }

                    //媒体政策
                    if (dataBean.getCj_policy() == 0) {
                        tv_cj_policy.setVisibility(View.GONE);
                    } else {
                        tv_cj_policy.setText(dataBean.getCj_policy() + "");
                    }

                    //媒体政策备注
                    if (TextUtils.isEmpty(dataBean.getCj_policymemo())) {
                        tv_cj_policymemo.setVisibility(View.GONE);
                    } else {
                        tv_cj_policymemo.setText(dataBean.getCj_policymemo());
                    }

                    //公司政策
                    if (dataBean.getGskh_policy() == 0) {
                        tv_gskh_policy.setVisibility(View.GONE);
                    } else {
                        tv_gskh_policy.setText(dataBean.getGskh_policy() + "");
                    }
                    //公司政策备注
                    if (TextUtils.isEmpty(dataBean.getGskh_policymemo())) {
                        tv_gskh_policymemo.setVisibility(View.GONE);
                    } else {
                        tv_gskh_policymemo.setText(dataBean.getGskh_policymemo());
                    }

                    //客户政策
                    if (dataBean.getKhzc() == 0) {
                        tv_khzc.setVisibility(View.GONE);
                    } else {
                        tv_khzc.setText(dataBean.getKhzc() + "");
                    }
                    //选择C或者A
                    if (TextUtils.isEmpty(dataBean.getKhzcCA())) {
                        tv_khzcCA.setVisibility(View.GONE);
                    } else {
                        tv_khzcCA.setText(dataBean.getKhzcCA());
                    }
                    //选择年月日
                    if (TextUtils.isEmpty(dataBean.getKhjeYMD())) {
                        tv_khzcTYMD.setVisibility(View.GONE);
                    } else {
                        tv_khzcTYMD.setText(dataBean.getKhzcTYMD());
                    }
                    //客户金额
                    if (dataBean.getKhje() == 0) {
                        tv_khje.setVisibility(View.GONE);
                    } else {
                        tv_khje.setText(dataBean.getKhje() + "");
                    }
                    //客户金额时间
                    if (TextUtils.isEmpty(dataBean.getKhjeYMD())) {
                        tv_khjeYMD.setVisibility(View.GONE);
                    } else {
                        tv_khjeYMD.setText(dataBean.getKhjeYMD());
                    }
                    //账期
                    if (TextUtils.isEmpty(dataBean.getCon_vq())) {
                        tv_con_vq.setVisibility(View.GONE);
                    } else {
                        tv_con_vq.setText(dataBean.getCon_vq());

                    }
                    //收客户
                    if (dataBean.getAgent() == 0) {
                        tv_agent.setVisibility(View.GONE);
                    } else {
                        tv_agent.setText(dataBean.getAgent() + "");
                    }
                    //收客户年月季
                    if (TextUtils.isEmpty(dataBean.getAgentYMD())) {
                        tv_agentYMD.setVisibility(View.GONE);
                    } else {
                        tv_agentYMD.setText(dataBean.getAgentYMD());
                    }
                    //付媒体
                    if (dataBean.getCmon_cost() == 0) {
                        tv_cmon_cost.setVisibility(View.GONE);
                    } else {
                        tv_cmon_cost.setText(dataBean.getCmon_cost() + "");

                    }
                    //媒体名称
                    if (TextUtils.isEmpty(dataBean.getMtgsname())) {
                        tv_mtgsname.setVisibility(View.GONE);
                    } else {
                        tv_mtgsname.setText(dataBean.getMtgsname());
                    }
                    //推广政策配送表
                    if (dataBean.getIstui() == 0) {
                        tv_istui.setVisibility(View.GONE);
                    } else {
                        tv_istui.setText(dataBean.getIstui() + "");
                    }
                    //配送
                    if (dataBean.getPs() == 0) {
                        tv_ps.setVisibility(View.GONE);
                    } else {
                        tv_ps.setText(dataBean.getPs() + "");
                    }
                    //代理名称
                    if (TextUtils.isEmpty(dataBean.getDlname())) {
                        tv_dlname.setVisibility(View.GONE);
                    } else {
                        tv_dlname.setText(dataBean.getDlname());
                    }
                    //代理商反
                    if (dataBean.getDlfan() == 0) {
                        tv_dlfan.setVisibility(View.GONE);
                    } else {
                        tv_dlfan.setText(dataBean.getDlfan() + "");
                    }


                    //毛利偏低的风险
                    if (TextUtils.isEmpty(dataBean.getMaoDanger1())) {
                        tv_maoDanger1.setVisibility(View.GONE);
                    } else {
                        tv_maoDanger1.setText(dataBean.getMaoDanger1());

                    }

                    if (TextUtils.isEmpty(dataBean.getMaoDanger2())) {
                        tv_maoDanger2.setVisibility(View.GONE);
                    } else {
                        tv_maoDanger2.setText(dataBean.getMaoDanger1());

                    }

                    if (TextUtils.isEmpty(dataBean.getMaoDanger3())) {
                        tv_maoDanger3.setVisibility(View.GONE);
                    } else {
                        tv_maoDanger3.setText(dataBean.getMaoDanger1());

                    }

                    //++++++++品专类信息传过来的数据有问题
                    //ll_plinfo.setVisibility(View.GONE);


                    if (TextUtils.isEmpty(dataBean.getPLMemo())) {
                        tv_plMemo.setVisibility(View.GONE);
                    } else {
                        tv_plMemo.setText(dataBean.getPLMemo());
                    }

                    if (dataBean.getXyTotalMomey() == 0) {
                        tv_xyTotalMomey.setVisibility(View.GONE);
                    } else {
                        tv_xyTotalMomey.setText(dataBean.getXyTotalMomey() + "");
                    }

                    if (TextUtils.isEmpty(dataBean.getBaseMoneyR())) {
                        tv_baseMoneyR.setVisibility(View.GONE);
                    } else {
                        tv_baseMoneyR.setText(dataBean.getBaseMoneyR() + "");
                    }

                    if (dataBean.getBasePer() == 0) {
                        tv_basePer.setVisibility(View.GONE);
                    } else {
                        tv_basePer.setText(dataBean.getBasePer() + "");
                    }

                    if (dataBean.getBaseMoney() == 0) {
                        tv_baseMoney.setVisibility(View.GONE);
                    } else {
                        tv_baseMoney.setText(dataBean.getBaseMoney() + "");
                    }

                    if (dataBean.getOverBy() == 0) {
                        tv_overBy.setVisibility(View.GONE);
                    } else {
                        tv_overBy.setText(dataBean.getOverBy() + "");
                    }

                    if (TextUtils.isEmpty(dataBean.getGoodTo())) {
                        tv_goodTo.setVisibility(View.GONE);
                    } else {
                        tv_goodTo.setText(dataBean.getGoodTo());

                    }

                    if (dataBean.getChangePer() == 0) {
                        tv_changePer.setVisibility(View.GONE);
                    } else {
                        tv_changePer.setText(dataBean.getChangePer() + "");
                    }

                    if (TextUtils.isEmpty(dataBean.getChangeReason())) {
                        tv_changeReason.setVisibility(View.GONE);
                    } else {
                        tv_changeReason.setText(dataBean.getChangeReason());
                    }

                    if (TextUtils.isEmpty(dataBean.getOtherXyBz())) {
                        tv_otherXyBz.setVisibility(View.GONE);
                    } else {
                        tv_otherXyBz.setText(dataBean.getOtherXyBz());
                    }

                    if (dataBean.getSFWP() == 0) {
                        tv_sfwp.setVisibility(View.GONE);
                    } else {
                        tv_sfwp.setText(dataBean.getSFWP() + "");
                    }

                    if (dataBean.getSFMoney() == 0) {
                        tv_sfMoney.setVisibility(View.GONE);
                    } else {
                        tv_sfMoney.setText(dataBean.getSFMoney() + "");

                    }

                    if (dataBean.getUserDay() == 0) {
                        tv_userDay.setVisibility(View.GONE);
                    } else {
                        tv_userDay.setText(dataBean.getUserDay() + "");
                    }

                    if (TextUtils.isEmpty(dataBean.getUserDayDMY())) {
                        tv_userDayDMY.setVisibility(View.GONE);
                    } else {
                        tv_userDayDMY.setText(dataBean.getUserDayDMY());
                    }

                    if (dataBean.getUserMoney() == 0) {
                        tv_userMoney.setVisibility(View.GONE);
                    } else {
                        tv_userMoney.setText(dataBean.getUserMoney() + "");
                    }

                    if (dataBean.getADMoney() == 0) {
                        tv_adMoney.setVisibility(View.GONE);
                    } else {
                        tv_adMoney.setText(dataBean.getADMoney() + "");
                    }

                    if (TextUtils.isEmpty(dataBean.getYhPerson())) {
                        tv_yhPerson.setVisibility(View.GONE);
                    } else {
                        tv_yhPerson.setText(dataBean.getYhPerson());
                    }

                    if (TextUtils.isEmpty(dataBean.getApp())) {
                        tv_appAPP.setVisibility(View.GONE);
                    } else {
                        tv_appAPP.setText(dataBean.getApp());
                    }
                    //+++++++++++其他情况备注数据有问题
                    //ll_otherConMemo.setVisibility(View.GONE);

                    if (TextUtils.isEmpty(dataBean.getBank())) {
                        tv_bank.setVisibility(View.GONE);
                    } else {
                        tv_bank.setText(dataBean.getBank());
                    }

                    if (TextUtils.isEmpty(dataBean.getAccountName())) {
                        tv_accountName.setVisibility(View.GONE);
                    } else {
                        tv_accountName.setText(dataBean.getAccountName());
                    }

                    if (TextUtils.isEmpty(dataBean.getCardNum())) {
                        tv_cardNum.setVisibility(View.GONE);
                    } else {
                        tv_cardNum.setText(dataBean.getCardNum());
                    }

                    if (TextUtils.isEmpty(dataBean.getFPType())) {
                        tv_fpType.setVisibility(View.GONE);
                    } else {
                        tv_fpType.setText(dataBean.getFPType() + "");
                    }

                    if (TextUtils.isEmpty(dataBean.getFPCont())) {
                        tv_fpCont.setVisibility(View.GONE);
                    } else {
                        tv_fpCont.setText(dataBean.getFPCont());
                    }

                    if (TextUtils.isEmpty(dataBean.getFPOther())) {
                        tv_fpOther.setVisibility(View.GONE);
                    } else {
                        tv_fpOther.setText(dataBean.getFPOther());
                    }

                    if (TextUtils.isEmpty(dataBean.getFPTitle())) {
                        tv_fpTitler.setVisibility(View.GONE);
                    } else {
                        tv_fpTitler.setText(dataBean.getFPTitle());

                    }

                    if (TextUtils.isEmpty(dataBean.getFPmemo())) {
                        tv_fPmemo.setVisibility(View.GONE);
                    } else {
                        tv_fPmemo.setText(dataBean.getFPmemo());
                    }

                    if (TextUtils.isEmpty(dataBean.getCon_bg())) {
                        tv_con_bg.setVisibility(View.GONE);
                    } else {
                        tv_con_bg.setText(dataBean.getCon_bg());
                    }

                    if (TextUtils.isEmpty(dataBean.getSpecialNeed())) {
                        tv_specialNeed.setVisibility(View.GONE);
                    } else {
                        tv_specialNeed.setText(dataBean.getSpecialNeed());

                    }

                    if (TextUtils.isEmpty(dataBean.getTeamSay())) {
                        tv_teamSay.setVisibility(View.GONE);
                    } else {
                        tv_teamSay.setText(dataBean.getTeamSay());
                    }

                    if (TextUtils.isEmpty(dataBean.getAddSay())) {
                        tv_addSay.setVisibility(View.GONE);
                    } else {
                        tv_addSay.setText(dataBean.getAddSay());
                    }
                    //maoli的数据
                    tv_maoli_hs.setText(dataBean.getMaoli_hs());
                    tv_maoli_hs1.setText(dataBean.getMaoli_hs1());
                    tv_maoli_hs_jg.setText(dataBean.getMaoli_hs_jg());
                    tv_js_qd.setText(dataBean.getJs_qd());
                    tv_js_qd1.setText(dataBean.getJs_qd1());
                    tv_js_qd_jg.setText(dataBean.getJs_qd_jg());
                    tv_js_hh.setText(dataBean.getJs_hh());
                    tv_auditInfo.setText((dataBean.getAuditInfo() + "").replace("<br/>", "\n").replace(",", "").replace("[", "").replace("]", ""));//这里需要改变展现形式
                    tv_waitPer.setText(dataBean.getWaitPer());

                    //###合同展现
                    mainUrl = dataBean.getMainrul();
                    tv_mainht.setText((dataBean.getMainname()));//这里需要展现这个url

                    fuUrl = dataBean.getHetongurl();
                    tv_fuht.setText(dataBean.getFujianname().replace(",", "\n\n"));//这里需要展现这个url


                }
            }

            @Override
            public void onErrorRequest(int tag, String e) {
            }
        }, DetailBean.class, 1);//详情列表bean
    }

    //###1.找控件
    private void findViews() {
        iv_approvefanhui = (ImageView) findViewById(R.id.iv_approvefanhui);
        tv_num = (TextView) findViewById(R.id.tv_num);
        tv_party = (TextView) findViewById(R.id.tv_party);
        tv_username = (TextView) findViewById(R.id.tv_username);
        tv_userdep = (TextView) findViewById(R.id.tv_userdep);
        tv_createtime = (TextView) findViewById(R.id.tv_createtime);
        tv_ys_gstype = (TextView) findViewById(R.id.tv_ys_gstype);
        tv_ys_gs = (TextView) findViewById(R.id.tv_ys_gs);
        tv_big_cagegory = (TextView) findViewById(R.id.tv_big_cagegory);
        tv_small_category = (TextView) findViewById(R.id.tv_small_category);
        tv_detail_category = (TextView) findViewById(R.id.tv_detail_category);
        tv_is_newuser = (TextView) findViewById(R.id.tv_is_newuser);
        tv_is_xk = (TextView) findViewById(R.id.tv_is_xk);
        tv_needYh = (TextView) findViewById(R.id.tv_NeedYh);
        tv_mthy = (TextView) findViewById(R.id.tv_MTHY);
        tv_cmon_mon = (TextView) findViewById(R.id.tv_cmon_mon);
        tv_cmon_monbig = (TextView) findViewById(R.id.tv_cmon_monbig);
        tv_isWhite = (TextView) findViewById(R.id.tv_IsWhite);
        tv_contr_stime = (TextView) findViewById(R.id.tv_contr_stime);
        tv_contr_etime = (TextView) findViewById(R.id.tv_contr_etime);
        tv_st_da = (TextView) findViewById(R.id.tv_st_da);
        tv_end_da = (TextView) findViewById(R.id.tv_end_da);
        tv_cj_policy = (TextView) findViewById(R.id.tv_cj_policy);
        tv_cj_policymemo = (TextView) findViewById(R.id.tv_cj_policymemo);
        tv_gskh_policy = (TextView) findViewById(R.id.tv_gskh_policy);
        tv_gskh_policymemo = (TextView) findViewById(R.id.tv_gskh_policymemo);
        tv_khzc = (TextView) findViewById(R.id.tv_khzc);
        tv_khzcCA = (TextView) findViewById(R.id.tv_khzcCA);
        tv_khzcTYMD = (TextView) findViewById(R.id.tv_khzcTYMD);
        tv_khje = (TextView) findViewById(R.id.tv_khje);
        tv_khjeYMD = (TextView) findViewById(R.id.tv_khjeYMD);
        tv_con_vq = (TextView) findViewById(R.id.tv_con_vq);
        tv_agent = (TextView) findViewById(R.id.tv_agent);
        tv_agentYMD = (TextView) findViewById(R.id.tv_agentYMD);
        tv_cmon_cost = (TextView) findViewById(R.id.tv_cmon_cost);
        tv_mtgsname = (TextView) findViewById(R.id.tv_mtgsname);
        tv_istui = (TextView) findViewById(R.id.tv_istui);
        tv_ps = (TextView) findViewById(R.id.tv_ps);
        tv_dlname = (TextView) findViewById(R.id.tv_dlname);
        tv_dlfan = (TextView) findViewById(R.id.tv_dlfan);
        tv_maoDanger1 = (TextView) findViewById(R.id.tv_maoDanger1);
        tv_maoDanger2 = (TextView) findViewById(R.id.tv_maoDanger2);
        tv_maoDanger3 = (TextView) findViewById(R.id.tv_maoDanger3);
        tv_plinfo = (TextView) findViewById(R.id.tv_plinfo);
        tv_plMemo = (TextView) findViewById(R.id.tv_PLMemo);
        tv_xyTotalMomey = (TextView) findViewById(R.id.tv_xyTotalMomey);
        tv_baseMoneyR = (TextView) findViewById(R.id.tv_baseMoneyR);
        tv_basePer = (TextView) findViewById(R.id.tv_basePer);
        tv_baseMoney = (TextView) findViewById(R.id.tv_baseMoney);
        tv_overBy = (TextView) findViewById(R.id.tv_overBy);
        tv_goodTo = (TextView) findViewById(R.id.tv_GoodTo);
        tv_changePer = (TextView) findViewById(R.id.tv_ChangePer);
        tv_changeReason = (TextView) findViewById(R.id.tv_ChangeReason);
        tv_otherXyBz = (TextView) findViewById(R.id.tv_otherXyBz);
        tv_sfwp = (TextView) findViewById(R.id.tv_SFWP);
        tv_sfMoney = (TextView) findViewById(R.id.tv_SFMoney);
        tv_userDay = (TextView) findViewById(R.id.tv_UserDay);
        tv_userDayDMY = (TextView) findViewById(R.id.tv_UserDayDMY);
        tv_userMoney = (TextView) findViewById(R.id.tv_UserMoney);
        tv_adMoney = (TextView) findViewById(R.id.tv_ADMoney);
        tv_yhPerson = (TextView) findViewById(R.id.tv_yhPerson);
        tv_appAPP = (TextView) findViewById(R.id.tv_AppAPP);
        tv_otherConMemo1 = (TextView) findViewById(R.id.tv_otherConMemo);
        tv_bank = (TextView) findViewById(R.id.tv_bank);
        tv_accountName = (TextView) findViewById(R.id.tv_accountName);
        tv_cardNum = (TextView) findViewById(R.id.tv_cardNum);
        tv_fpType = (TextView) findViewById(R.id.tv_FPType);
        tv_fpCont = (TextView) findViewById(R.id.tv_FPCont);
        tv_fpOther = (TextView) findViewById(R.id.tv_FPOther);
        tv_fpTitler = (TextView) findViewById(R.id.tv_FPTitler);
        tv_fPmemo = (TextView) findViewById(R.id.tv_FPmemo);
        tv_con_bg = (TextView) findViewById(R.id.tv_con_bg);
        tv_specialNeed = (TextView) findViewById(R.id.tv_specialNeed);
        tv_teamSay = (TextView) findViewById(R.id.tv_TeamSay);
        tv_addSay = (TextView) findViewById(R.id.tv_AddSay);
        tv_maoli_hs = (TextView) findViewById(R.id.tv_maoli_hs);
        tv_maoli_hs1 = (TextView) findViewById(R.id.tv_maoli_hs1);
        tv_maoli_hs_jg = (TextView) findViewById(R.id.tv_maoli_hs_jg);
        tv_js_qd = (TextView) findViewById(R.id.tv_js_qd);
        tv_js_qd1 = (TextView) findViewById(R.id.tv_js_qd1);
        tv_js_qd_jg = (TextView) findViewById(R.id.tv_js_qd_jg);
        tv_js_hh = (TextView) findViewById(R.id.tv_js_hh);
        tv_auditInfo = (TextView) findViewById(R.id.tv_auditInfo);
        tv_waitPer = (TextView) findViewById(R.id.tv_waitPer);
        tv_huiqian = (TextView) findViewById(R.id.tv_huiqian);
        tv_mainht = (TextView) findViewById(R.id.tv_mainht);
        tv_fuht = (TextView) findViewById(R.id.tv_fuht);
        tv1_maoli_hs = (TextView) findViewById(R.id.tv1_maoli_hs);
        tv1_maoli_hs1 = (TextView) findViewById(R.id.tv1_maoli_hs1);
        tv1_maoli_hs_jg = (TextView) findViewById(R.id.tv1_maoli_hs_jg);
        tv1_js_hh = (TextView) findViewById(R.id.tv1_js_hh);
        tv1_js_qd = (TextView) findViewById(R.id.tv1_js_qd);
        tv1_js_qd1 = (TextView) findViewById(R.id.tv1_js_qd1);
        tv1_js_qd_jg = (TextView) findViewById(R.id.tv1_js_qd_jg);
        ll_button = (LinearLayout) findViewById(R.id.ll_button);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_approvefanhui:
                finish();
                break;
            default:
                break;
        }
    }
}
