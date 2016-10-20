package com.zixu.officeassi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import com.zhy.autolayout.AutoLayoutActivity;
import com.zixu.officeassi.bean.DetailBean;
import com.zixu.officeassi.bean.SureBean;
import com.zixu.officeassi.bean.UserBean;
import com.zixu.officeassi.utils.ACallOkHttp;
import com.zixu.officeassi.utils.HttpOH;
import com.zixu.officeassi.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;


public class ContractActivity extends AutoLayoutActivity implements View.OnClickListener {

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
    private EditText et_maoli_hs;
    private EditText et_maoli_hs1;
    private EditText et_maoli_hs_jg;
    private EditText et_js_qd;
    private EditText et_js_qd1;
    private EditText et_js_qd_jg;
    private EditText et_js_hh;
    private TextView tv_auditInfo;
    private TextView tv_waitPer;
    private int sys_id;
    private RadioButton rb_agree;
    private RadioButton rb_disagree;
    private RadioButton rb_ratify;
    private RadioGroup rg_button;
    private String agreeremark;
    private String disaagreeremark;
    private Button bt_agree;
    private Button bt_reelect;
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
    private String maoli_hs1;
    private String js_qd;
    private String js_qd1;
    private String js_qd_jg;
    private String js_hh;
    private String maoli_hs_jg;
    private String maoli_hs11;
    private TextView tv_maoli_hs;
    private TextView tv_maoli_hs1;
    private TextView tv_maoli_hs_jg;
    private TextView tv_js_hh;
    private TextView tv_js_qd;
    private TextView tv_js_qd1;
    private TextView tv_js_qd_jg;
    private TextView tv1_maoli_hs;
    private TextView tv1_maoli_hs1;
    private TextView tv1_maoli_hs_jg;
    private LinearLayout ll_cj_policymemo;
    private LinearLayout ll_gskh_policymemo;
    private LinearLayout ll_ys_gstype;
    private LinearLayout ll_ys_gs;
    private LinearLayout ll_is_newuser;
    private LinearLayout ll_is_xk;
    private LinearLayout ll_needYh;
    private LinearLayout ll_st_da;
    private LinearLayout ll_end_da;
    private LinearLayout ll_khzc;
    private LinearLayout ll_khzcCA;
    private LinearLayout ll_khzcTYMD;
    private LinearLayout ll_khje;
    private LinearLayout ll_khjeYMD;
    private LinearLayout ll_agent;
    private LinearLayout ll_agentYMD;
    private LinearLayout ll_cmon_cost;
    private LinearLayout ll_mtgsname;
    private LinearLayout ll_istui;
    private LinearLayout ll_ps;
    private LinearLayout ll_dlname;
    private LinearLayout ll_dlfan;
    private LinearLayout ll_button;
    private LinearLayout ll_maoDanger1;
    private LinearLayout ll_maoDanger2;
    private LinearLayout ll_maoDanger3;
    private LinearLayout ll_plinfo;
    private LinearLayout ll_plMemo;
    private LinearLayout ll_xyTotalMomey;
    private LinearLayout ll_baseMoneyR;
    private LinearLayout ll_basePer;
    private LinearLayout ll_baseMoney;
    private LinearLayout ll_overBy;
    private LinearLayout ll_goodTo;
    private LinearLayout ll_changePer;
    private LinearLayout ll_changeReason;
    private LinearLayout ll_otherXyBz;
    private LinearLayout ll_sfwp;
    private LinearLayout ll_sfMoney;
    private LinearLayout ll_userDay;
    private LinearLayout ll_userDayDMY;
    private LinearLayout ll_userMoney;
    private LinearLayout ll_adMoney;
    private LinearLayout ll_yhPerson;
    private LinearLayout ll_appAPP;
    private LinearLayout ll_otherConMemo;
    private LinearLayout ll_bank;
    private LinearLayout ll_accountName;
    private LinearLayout ll_cardNum;
    private LinearLayout ll_fpType;
    private LinearLayout ll_fpCont;
    private LinearLayout ll_fpOther;
    private LinearLayout ll_fpTitler;
    private LinearLayout ll_fPmemo;
    private LinearLayout ll_con_bg;
    private LinearLayout ll_specialNeed;
    private LinearLayout ll_teamSay;
    private LinearLayout ll_addSay;
    private TextView tv1_js_hh;
    private TextView tv1_js_qd;
    private TextView tv1_js_qd1;
    private TextView tv1_js_qd_jg;
    private LinearLayout ll_con_vq;
    private LinearLayout ll_gskh_policy;
    private LinearLayout ll_cj_policy;
    private int wenjie;
    private String fuName;
    private String downUrl;
    private boolean rbagree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);
        sys_id = getIntent().getIntExtra("sys_id", 0);
        is_hq = getIntent().getIntExtra("is_hq", 0);
        Log.i("======", Myapplication.loginBean.isIs_LZ() + "" + sys_id);
        findViews();
        postData();
        setListener();

    }

    private void setListener() {
        //启动 radigroup 点击事件
        bt_agree.setOnClickListener(this);
        bt_reelect.setOnClickListener(this);
        iv_approvefanhui.setOnClickListener(this);
        tv_mainht.setOnClickListener(this);
        tv_fuht.setOnClickListener(this);


        rg_button.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_agree:
                        Intent intent = new Intent(getApplicationContext(), AgreeActivity.class);
                        intent.putExtra("wenjie", wenjie);
                        startActivityForResult(intent, 999);
                        break;
                    case R.id.rb_disagree:
                        Intent intent1 = new Intent(getApplicationContext(), DisagreeActivity.class);
                        startActivityForResult(intent1, 777);
                        break;
                    case R.id.rb_ratify:
                        if (Myapplication.loginBean.getUserid() == 183) {
                            Intent intent3 = new Intent(getApplicationContext(), ZhratifyActivity.class);
                            startActivityForResult(intent3, 555);
                        } else {
                            Intent intent2 = new Intent(getApplicationContext(), RatifyActivity.class);
                            startActivityForResult(intent2, 888);
                        }
                    default:
                        break;
                }
            }
        });
    }


    private void postData() {

        RequestBody formBody = new FormEncodingBuilder()
                .add("id", sys_id + "")
                .add("uid", Myapplication.loginBean.getUserid() + "")
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
                    if (is_hq > 0) {

                        if (Myapplication.loginBean.isIs_agree() == true) {

                            rb_ratify.setVisibility(View.GONE);
                            tv_huiqian.setVisibility(View.GONE);
                        } else {
                            //rg_button.setVisibility(View.GONE);
                            ll_button.setVisibility(View.GONE);
                        }
                    }
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
                    //回款难度大或有坏账的风险
                    if (TextUtils.isEmpty(dataBean.getMaoDanger2())) {
                        tv_maoDanger2.setVisibility(View.GONE);
                    } else {
                        tv_maoDanger2.setText(dataBean.getMaoDanger1());
                    }

                    //其他风险或建议
                    if (TextUtils.isEmpty(dataBean.getMaoDanger3())) {
                        tv_maoDanger3.setVisibility(View.GONE);
                    } else {
                        tv_maoDanger3.setText(dataBean.getMaoDanger1());
                    }

                    // 品专类信息
                    tv_plinfo.setText((dataBean.getPlinfo() + "").replace("CreateTime", "品专合同分次").replace("Money", "金额(元)").replace("[", "").replace("]", "").replace("{", "").replace("},", "\n").replace("}", ""));

                    //品专备注
                    if (TextUtils.isEmpty(dataBean.getPLMemo())) {
                        tv_plMemo.setVisibility(View.GONE);
                    } else {
                        tv_plMemo.setText(dataBean.getPLMemo());
                    }

                    //框架总金额
                    if (dataBean.getXyTotalMomey() == 0) {
                        tv_xyTotalMomey.setVisibility(View.GONE);
                    } else {
                        tv_xyTotalMomey.setText(dataBean.getXyTotalMomey() + "");
                    }

                    //保证金概况

                    if (TextUtils.isEmpty(dataBean.getBaseMoneyR())) {
                        tv_baseMoneyR.setVisibility(View.GONE);
                    } else {
                        tv_baseMoneyR.setText(dataBean.getBaseMoneyR() + "");
                    }


                    //保证金详情
                    if (dataBean.getBasePer() == 0) {
                        tv_basePer.setVisibility(View.GONE);
                    } else {
                        tv_basePer.setText(dataBean.getBasePer() + "");
                    }

                    //自动计算
                    if (dataBean.getBaseMoney() == 0) {
                        tv_baseMoney.setVisibility(View.GONE);
                    } else {
                        tv_baseMoney.setText(dataBean.getBaseMoney() + "");
                    }

                    //超过框架增速部分按
                    if (dataBean.getOverBy() == 0) {
                        tv_overBy.setVisibility(View.GONE);
                    } else {
                        tv_overBy.setText(dataBean.getOverBy() + "");
                    }

                    //奖励至
                    if (TextUtils.isEmpty(dataBean.getGoodTo())) {
                        tv_goodTo.setVisibility(View.GONE);
                    } else {
                        tv_goodTo.setText(dataBean.getGoodTo());
                    }

                    //增加或下降
                    if (dataBean.getChangePer() == 0) {
                        tv_changePer.setVisibility(View.GONE);
                    } else {
                        tv_changePer.setText(dataBean.getChangePer() + "");
                    }
                    //增加或下降原因
                    if (TextUtils.isEmpty(dataBean.getChangeReason())) {
                        tv_changeReason.setVisibility(View.GONE);
                    } else {
                        tv_changeReason.setText(dataBean.getChangeReason());
                    }
                    //其他框架信息备注
                    if (TextUtils.isEmpty(dataBean.getOtherXyBz())) {
                        tv_otherXyBz.setVisibility(View.GONE);
                    } else {
                        tv_otherXyBz.setText(dataBean.getOtherXyBz());
                    }
                    //收取服务费比例
                    if (dataBean.getSFWP() == 0) {
                        tv_sfwp.setVisibility(View.GONE);
                    } else {
                        tv_sfwp.setText(dataBean.getSFWP() + "");
                    }
                    //收取服务费金额
                    if (dataBean.getSFMoney() == 0) {
                        tv_sfMoney.setVisibility(View.GONE);
                    } else {
                        tv_sfMoney.setText(dataBean.getSFMoney() + "");

                    }
                    //租期
                    if (dataBean.getUserDay() == 0) {
                        tv_userDay.setVisibility(View.GONE);
                    } else {
                        tv_userDay.setText(dataBean.getUserDay() + "");
                    }
                    //选择年月日
                    if (TextUtils.isEmpty(dataBean.getUserDayDMY())) {
                        tv_userDayDMY.setVisibility(View.GONE);
                    } else {
                        tv_userDayDMY.setText(dataBean.getUserDayDMY());
                    }
                    //租金
                    if (dataBean.getUserMoney() == 0) {
                        tv_userMoney.setVisibility(View.GONE);
                    } else {
                        tv_userMoney.setText(dataBean.getUserMoney() + "");
                    }
                    //广告费
                    if (dataBean.getADMoney() == 0) {
                        tv_adMoney.setVisibility(View.GONE);
                    } else {
                        tv_adMoney.setText(dataBean.getADMoney() + "");
                    }
                    //优化人员
                    if (TextUtils.isEmpty(dataBean.getYhPerson())) {
                        tv_yhPerson.setVisibility(View.GONE);
                    } else {
                        tv_yhPerson.setText(dataBean.getYhPerson());
                    }
                    //名称
                    if (TextUtils.isEmpty(dataBean.getApp())) {
                        tv_appAPP.setVisibility(View.GONE);
                    } else {
                        tv_appAPP.setText(dataBean.getApp());
                    }

                    //+++++++++++其他情况备注数据有问题
                    ll_otherConMemo.setVisibility(View.GONE);

                    //开户银行
                    if (TextUtils.isEmpty(dataBean.getBank())) {
                        tv_bank.setVisibility(View.GONE);
                    } else {
                        tv_bank.setText(dataBean.getBank());
                    }
                    //开户名
                    if (TextUtils.isEmpty(dataBean.getAccountName())) {
                        tv_accountName.setVisibility(View.GONE);
                    } else {
                        tv_accountName.setText(dataBean.getAccountName());
                    }
                    //银行账号
                    if (TextUtils.isEmpty(dataBean.getCardNum())) {
                        tv_cardNum.setVisibility(View.GONE);
                    } else {
                        tv_cardNum.setText(dataBean.getCardNum());
                    }
                    //发票类型
                    if (TextUtils.isEmpty(dataBean.getFPType())) {
                        tv_fpType.setVisibility(View.GONE);
                    } else {
                        tv_fpType.setText(dataBean.getFPType() + "");
                    }

                    //发票内容
                    if (TextUtils.isEmpty(dataBean.getFPCont())) {
                        tv_fpCont.setVisibility(View.GONE);
                    } else {
                        tv_fpCont.setText(dataBean.getFPCont());
                    }

                    //其他
                    if (TextUtils.isEmpty(dataBean.getFPOther())) {
                        tv_fpOther.setVisibility(View.GONE);
                    } else {
                        tv_fpOther.setText(dataBean.getFPOther());
                    }

                    //发票抬头名称
                    if (TextUtils.isEmpty(dataBean.getFPTitle())) {
                        tv_fpTitler.setVisibility(View.GONE);
                    } else {
                        tv_fpTitler.setText(dataBean.getFPTitle());
                    }

                    //备注
                    if (TextUtils.isEmpty(dataBean.getFPmemo())) {
                        tv_fPmemo.setVisibility(View.GONE);
                    } else {
                        tv_fPmemo.setText(dataBean.getFPmemo());
                    }

                    //背景说明
                    if (TextUtils.isEmpty(dataBean.getCon_bg())) {
                        tv_con_bg.setVisibility(View.GONE);
                    } else {
                        tv_con_bg.setText(dataBean.getCon_bg());
                    }

                    //客户特殊需求说明
                    if (TextUtils.isEmpty(dataBean.getSpecialNeed())) {
                        tv_specialNeed.setVisibility(View.GONE);
                    } else {
                        tv_specialNeed.setText(dataBean.getSpecialNeed());
                    }

                    //内部协作说明
                    if (TextUtils.isEmpty(dataBean.getTeamSay())) {
                        tv_teamSay.setVisibility(View.GONE);
                    } else {
                        tv_teamSay.setText(dataBean.getTeamSay());
                    }

                    //补充说明
                    if (TextUtils.isEmpty(dataBean.getAddSay())) {
                        tv_addSay.setVisibility(View.GONE);
                    } else {
                        tv_addSay.setText(dataBean.getAddSay());
                    }

                    et_maoli_hs.setText(dataBean.getMaoli_hs());

                    et_maoli_hs1.setText(dataBean.getMaoli_hs1());
                    et_maoli_hs_jg.setText(dataBean.getMaoli_hs_jg());
                    et_js_qd.setText(dataBean.getJs_qd());
                    et_js_qd1.setText(dataBean.getJs_qd1());
                    et_js_qd_jg.setText(dataBean.getJs_qd_jg());
                    et_js_hh.setText(dataBean.getJs_hh());

                    //毛利计算
                    if (Myapplication.loginBean.isIs_LZ() == true) {

                        tv1_maoli_hs.setVisibility(View.GONE);
                        tv1_maoli_hs1.setVisibility(View.GONE);
                        tv1_maoli_hs_jg.setVisibility(View.GONE);
                        tv1_js_qd.setVisibility(View.GONE);
                        tv1_js_hh.setVisibility(View.GONE);
                        tv1_js_qd1.setVisibility(View.GONE);
                        tv1_js_qd_jg.setVisibility(View.GONE);
                    } else {
                        //这里判断的是哪些人具有查看和操作毛利计算的权限
                        if (Myapplication.loginBean.getUserid() == 215 || Myapplication.loginBean.getUserid() == 216) {

                            tv_maoli_hs.setVisibility(View.VISIBLE);
                            tv1_maoli_hs.setText(dataBean.getMaoli_hs());

                            tv_maoli_hs_jg.setVisibility(View.VISIBLE);
                            tv_maoli_hs1.setVisibility(View.VISIBLE);

                            tv1_maoli_hs1.setText(dataBean.getMaoli_hs1());
                            tv1_maoli_hs_jg.setText(dataBean.getMaoli_hs_jg());


                            tv_js_hh.setVisibility(View.VISIBLE);
                            tv1_js_hh.setText(dataBean.getJs_hh());

                            tv_js_qd_jg.setVisibility(View.VISIBLE);
                            tv1_js_qd_jg.setText(dataBean.getJs_qd_jg());

                            tv_js_qd.setVisibility(View.VISIBLE);
                            tv1_js_qd.setText(dataBean.getJs_qd());

                            tv_js_qd1.setVisibility(View.VISIBLE);
                            tv1_js_qd1.setText(dataBean.getJs_qd1());

                        } else {
                            tv_maoli_hs.setVisibility(View.GONE);
                            tv_maoli_hs1.setVisibility(View.GONE);
                            tv_maoli_hs_jg.setVisibility(View.GONE);
                            tv_js_hh.setVisibility(View.GONE);
                            tv_js_qd_jg.setVisibility(View.GONE);
                            tv_js_qd.setVisibility(View.GONE);
                            tv_js_qd1.setVisibility(View.GONE);
                            tv1_maoli_hs.setVisibility(View.GONE);
                            tv1_maoli_hs1.setVisibility(View.GONE);
                            tv1_maoli_hs_jg.setVisibility(View.GONE);
                            tv1_js_hh.setVisibility(View.GONE);
                            tv1_js_qd_jg.setVisibility(View.GONE);
                            tv1_js_qd.setVisibility(View.GONE);
                            tv1_js_qd1.setVisibility(View.GONE);

                        }
                        et_maoli_hs.setVisibility(View.GONE);
                        et_maoli_hs1.setVisibility(View.GONE);
                        et_maoli_hs_jg.setVisibility(View.GONE);
                        et_js_hh.setVisibility(View.GONE);
                        et_js_qd_jg.setVisibility(View.GONE);
                        et_js_qd.setVisibility(View.GONE);
                        et_js_qd1.setVisibility(View.GONE);
                    }

                    tv_auditInfo.setText((dataBean.getAuditInfo() + "").replace("<br/>", "\n").replace(",", "").replace("[", "").replace("]", ""));//这里需要改变展现形式
                    tv_waitPer.setText(dataBean.getWaitPer());

                    //###合同展现
                    mainUrl = dataBean.getMainrul();
                    tv_mainht.setText((dataBean.getMainname()));//这里需要展现这个url


                    tv_fuht.setText(dataBean.getFujianname().replace(",", "\n"));//这里需要展现这个url


                    if (dataBean.isHQ() == true) {
                        rb_ratify.setVisibility(View.VISIBLE);
                        tv_huiqian.setVisibility(View.VISIBLE);
                    } else {

                    }

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
        tv_gskh_policymemo = (TextView) findViewById(R.id.tv_gskh_policymemo1);
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
        et_maoli_hs = (EditText) findViewById(R.id.et_maoli_hs);
        et_maoli_hs1 = (EditText) findViewById(R.id.et_maoli_hs1);
        et_maoli_hs_jg = (EditText) findViewById(R.id.et_maoli_hs_jg);
        et_js_qd = (EditText) findViewById(R.id.et_js_qd);
        et_js_qd1 = (EditText) findViewById(R.id.et_js_qd1);
        et_js_qd_jg = (EditText) findViewById(R.id.et_js_qd_jg);
        et_js_hh = (EditText) findViewById(R.id.et_js_hh);
        tv_auditInfo = (TextView) findViewById(R.id.tv_auditInfo);
        tv_waitPer = (TextView) findViewById(R.id.tv_waitPer);
        rb_agree = (RadioButton) findViewById(R.id.rb_agree);
        rb_disagree = (RadioButton) findViewById(R.id.rb_disagree);
        rb_ratify = (RadioButton) findViewById(R.id.rb_ratify);
        rg_button = (RadioGroup) findViewById(R.id.rg_button);
        bt_agree = (Button) findViewById(R.id.bt_agree);
        bt_reelect = (Button) findViewById(R.id.bt_reelect);
        tv_huiqian = (TextView) findViewById(R.id.tv_huiqian);
        tv_mainht = (TextView) findViewById(R.id.tv_mainht);
        tv_fuht = (TextView) findViewById(R.id.tv_fuht);
        tv_maoli_hs = (TextView) findViewById(R.id.tv_maoli_hs);
        tv_maoli_hs1 = (TextView) findViewById(R.id.tv_maoli_hs1);
        tv_maoli_hs_jg = (TextView) findViewById(R.id.tv_maoli_hs_jg);
        tv_js_hh = (TextView) findViewById(R.id.tv_js_hh);
        tv_js_qd = (TextView) findViewById(R.id.tv_js_qd);
        tv_js_qd1 = (TextView) findViewById(R.id.tv_js_qd1);
        tv_js_qd_jg = (TextView) findViewById(R.id.tv_js_qd_jg);
        tv1_maoli_hs = (TextView) findViewById(R.id.tv1_maoli_hs);
        tv1_maoli_hs1 = (TextView) findViewById(R.id.tv1_maoli_hs1);
        tv1_maoli_hs_jg = (TextView) findViewById(R.id.tv1_maoli_hs_jg);
        ll_cj_policymemo = (LinearLayout) findViewById(R.id.ll_cj_policymemo);
        ll_gskh_policymemo = (LinearLayout) findViewById(R.id.ll_gskh_policymemo);
        ll_ys_gstype = (LinearLayout) findViewById(R.id.ll_ys_gstype);
        ll_ys_gs = (LinearLayout) findViewById(R.id.ll_ys_gs);
        ll_is_newuser = (LinearLayout) findViewById(R.id.ll_is_newuser);
        ll_is_xk = (LinearLayout) findViewById(R.id.ll_is_xk);
        ll_needYh = (LinearLayout) findViewById(R.id.ll_NeedYh);
        ll_st_da = (LinearLayout) findViewById(R.id.ll_st_da);
        ll_end_da = (LinearLayout) findViewById(R.id.ll_end_da);
        ll_khzc = (LinearLayout) findViewById(R.id.ll_khzc);
        ll_khzcCA = (LinearLayout) findViewById(R.id.ll_khzcCA);
        ll_khzcTYMD = (LinearLayout) findViewById(R.id.ll_khzcTYMD);
        ll_khje = (LinearLayout) findViewById(R.id.ll_khje);
        ll_khjeYMD = (LinearLayout) findViewById(R.id.ll_khjeYMD);
        ll_agent = (LinearLayout) findViewById(R.id.ll_agent);
        ll_agentYMD = (LinearLayout) findViewById(R.id.ll_agentYMD);
        ll_cmon_cost = (LinearLayout) findViewById(R.id.ll_cmon_cost);
        ll_mtgsname = (LinearLayout) findViewById(R.id.ll_mtgsname);
        ll_istui = (LinearLayout) findViewById(R.id.ll_istui);
        ll_ps = (LinearLayout) findViewById(R.id.ll_ps);
        ll_dlname = (LinearLayout) findViewById(R.id.ll_dlname);
        ll_dlfan = (LinearLayout) findViewById(R.id.ll_dlfan);
        ll_button = (LinearLayout) findViewById(R.id.ll_button);
        ll_maoDanger1 = (LinearLayout) findViewById(R.id.ll_maoDanger1);
        ll_maoDanger2 = (LinearLayout) findViewById(R.id.ll_maoDanger2);
        ll_maoDanger3 = (LinearLayout) findViewById(R.id.ll_maoDanger3);
        ll_plinfo = (LinearLayout) findViewById(R.id.ll_plinfo);
        ll_plMemo = (LinearLayout) findViewById(R.id.ll_PLMemo);
        ll_xyTotalMomey = (LinearLayout) findViewById(R.id.ll_xyTotalMomey);
        ll_baseMoneyR = (LinearLayout) findViewById(R.id.ll_baseMoneyR);
        ll_basePer = (LinearLayout) findViewById(R.id.ll_basePer);
        ll_baseMoney = (LinearLayout) findViewById(R.id.ll_baseMoney);
        ll_overBy = (LinearLayout) findViewById(R.id.ll_overBy);
        ll_goodTo = (LinearLayout) findViewById(R.id.ll_GoodTo);
        ll_changePer = (LinearLayout) findViewById(R.id.ll_ChangePer);
        ll_changeReason = (LinearLayout) findViewById(R.id.ll_ChangeReason);
        ll_otherXyBz = (LinearLayout) findViewById(R.id.ll_otherXyBz);
        ll_sfwp = (LinearLayout) findViewById(R.id.ll_SFWP);
        ll_sfMoney = (LinearLayout) findViewById(R.id.ll_SFMoney);
        ll_userDay = (LinearLayout) findViewById(R.id.ll_UserDay);
        ll_userDayDMY = (LinearLayout) findViewById(R.id.ll_UserDayDMY);
        ll_userMoney = (LinearLayout) findViewById(R.id.ll_UserMoney);
        ll_adMoney = (LinearLayout) findViewById(R.id.ll_ADMoney);
        ll_yhPerson = (LinearLayout) findViewById(R.id.ll_yhPerson);
        ll_appAPP = (LinearLayout) findViewById(R.id.ll_AppAPP);
        ll_otherConMemo = (LinearLayout) findViewById(R.id.ll_otherConMemo);
        ll_bank = (LinearLayout) findViewById(R.id.ll_bank);
        ll_accountName = (LinearLayout) findViewById(R.id.ll_accountName);
        ll_cardNum = (LinearLayout) findViewById(R.id.ll_cardNum);
        ll_fpType = (LinearLayout) findViewById(R.id.ll_FPType);
        ll_fpCont = (LinearLayout) findViewById(R.id.ll_FPCont);
        ll_fpOther = (LinearLayout) findViewById(R.id.ll_FPOther);
        ll_fpTitler = (LinearLayout) findViewById(R.id.ll_FPTitler);
        ll_fPmemo = (LinearLayout) findViewById(R.id.ll_FPmemo);
        ll_con_bg = (LinearLayout) findViewById(R.id.ll_con_bg);
        ll_specialNeed = (LinearLayout) findViewById(R.id.ll_specialNeed);
        ll_teamSay = (LinearLayout) findViewById(R.id.ll_TeamSay);
        ll_addSay = (LinearLayout) findViewById(R.id.ll_AddSay);
        tv1_js_hh = (TextView) findViewById(R.id.tv1_js_hh);
        tv1_js_qd = (TextView) findViewById(R.id.tv1_js_qd);
        tv1_js_qd1 = (TextView) findViewById(R.id.tv1_js_qd1);
        tv1_js_qd_jg = (TextView) findViewById(R.id.tv1_js_qd_jg);
        ll_con_vq = (LinearLayout) findViewById(R.id.ll_con_vq);
        ll_gskh_policy = (LinearLayout) findViewById(R.id.ll_gskh_policy);
        ll_cj_policy = (LinearLayout) findViewById(R.id.ll_cj_policy);
        tv_gskh_policy = (TextView) findViewById(R.id.tv_gskh_policy);

        rb_ratify.setVisibility(View.GONE);
        tv_huiqian.setVisibility(View.GONE);


    }

    //###4.设置点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_approvefanhui:
                finish();
                break;

            case R.id.bt_agree:
                agreeHttp();
                break;

            case R.id.bt_reelect:
                //+++++++++这里点击重选按钮刷新界面
                break;

            case R.id.tv_mainht:
                dialog(1);
                break;

            case R.id.tv_fuht:
                dialog(2);
                break;

            default:
                break;
        }
    }


    //###5.附件合同下载
    private void fujiandownload(String url, String name) {


        String SDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        HttpOH.downloadAsyn(url, SDPath, name, new ACallOkHttp() {
            @Override
            public void onBeforeRequest(int tag) {

            }

            @Override
            public void onResultRequest(int tag, Object bean) {
                Log.i("susess", "sussess");
                Looper.prepare();
                Toast.makeText(getApplicationContext(), "下载成功", Toast.LENGTH_SHORT).show();
                Looper.loop();

            }

            @Override
            public void onErrorRequest(int tag, String e) {
                Log.i("failed", e);
                Looper.prepare();
                Toast.makeText(getApplicationContext(), "下载失败", Toast.LENGTH_SHORT).show();
                Looper.loop();

            }
        }, 1);
    }


    //###5.合同下载
    private void maindownload(String url) {

        Log.i("这里是主合同的下载地址看看看看看看看看看看", mainUrl);

        String SDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        HttpOH.downloadAsyn(mainUrl, SDPath, dataBean.getMainname(), new ACallOkHttp() {
            @Override
            public void onBeforeRequest(int tag) {

            }

            @Override
            public void onResultRequest(int tag, Object bean) {
                Log.i("susess", "sussess");

                Looper.prepare();
                Toast.makeText(getApplicationContext(), "下载成功", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }

            @Override
            public void onErrorRequest(int tag, String e) {
                Log.i("failed", e);
                Looper.prepare();
                Toast.makeText(getApplicationContext(), "下载失败", Toast.LENGTH_SHORT).show();
                Looper.loop();

            }
        }, 1);
    }


    //3.这里是点击确认按钮时的网络请求
    private void agreeHttp() {
        if (agreeType != 1) {
            if (TextUtils.isEmpty(disaagreeremark) && TextUtils.isEmpty(ratifyremark)) {
                Toast.makeText(this, "请填写备注", Toast.LENGTH_SHORT).show();
                return;
            }
        }


        maoli_hs = et_maoli_hs.getText().toString().trim();
        maoli_hs1 = et_maoli_hs1.getText().toString().trim();
        maoli_hs_jg = et_maoli_hs_jg.getText().toString().trim();
        js_qd = et_js_qd.getText().toString().trim();
        js_qd1 = et_js_qd1.getText().toString().trim();
        js_qd_jg = et_js_qd_jg.getText().toString().trim();
        js_hh = et_js_hh.getText().toString().trim();


        if (Myapplication.loginBean.isIs_agree() == false) {

            RequestBody formBody = new FormEncodingBuilder()
                    .add("agreeMark", agreeremark).add("radio", agreeType + "").add("reason", disaagreeremark).add("zdjd", "")
                    .add("thd", "2").add("checkmemo", ratifyremark)
                    .add("_appNumid", sys_id + "")
                    .add("hqids", checkId)//这里需要会签人员的id
                    .add("user_id", Myapplication.loginBean.getUserid() + "").add("_appNum", dataBean.getNum())
                    .add("maoli_hs", maoli_hs).add("maoli_hs1", maoli_hs1).add("maoli_hs_jg", maoli_hs_jg)
                    .add("js_qd", js_qd).add("js_qd_jg", js_qd_jg).add("js_qd1", js_qd1).add("js_hh", js_hh)
                    .add("imei", SharedPreferencesUtils.getStringData(getApplicationContext(), "imei", ""))
                    .build();

            HttpOH.postData(getString(R.string.surePort), formBody, new ACallOkHttp() {
                @Override
                public void onBeforeRequest(int tag) {

                }

                @Override
                public void onResultRequest(int tag, Object bean) {
                    SureBean agree = (SureBean) bean;
                    if (agree.getMsg().equals("ok")) {
                        setResult(1);
                        finish();
                    }
                }

                @Override
                public void onErrorRequest(int tag, String e) {
                    Toast.makeText(getApplicationContext(), "请求网络失败", Toast.LENGTH_SHORT).show();
                }
            }, SureBean.class, 1);
            Log.i("普通接口", "+++");
        } else {
            RequestBody formBody = new FormEncodingBuilder()
                    .add("sid", sys_id + "")
                    .add("hqRadio", agreeType + "")
                    .add("agreeMark", agreeremark)
                    .add("NoagreeMark", disaagreeremark)
                    .add("user_id", Myapplication.loginBean.getUserid() + "")
                    .add("office_id", Myapplication.loginBean.getOffid() + "")
                    .add("user_name", Myapplication.loginBean.getName())
                    .add("imei", SharedPreferencesUtils.getStringData(getApplicationContext(), "imei", ""))
                    .build();

            HttpOH.postData(getString(R.string.hqSurePort), formBody, new ACallOkHttp() {
                @Override
                public void onBeforeRequest(int tag) {

                }

                @Override
                public void onResultRequest(int tag, Object bean) {
                    SureBean agree = (SureBean) bean;
                    if (agree.getMsg().equals("ok")) {
                        setResult(1);
                        finish();
                    }
                }

                @Override
                public void onErrorRequest(int tag, String e) {
                    Toast.makeText(getApplicationContext(), "请求网络失败", Toast.LENGTH_SHORT).show();
                }
            }, SureBean.class, 1);
            Log.i("会签接口", "+++");
        }
    }

    //###同意,不同意,会签几个页面设置事件
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (resultCode) {
            case -1:
                agreeType = 1;
                agreeremark = data.getStringExtra("agreeremark");
                wenjie = data.getIntExtra("wenjie", 0);
                //rbagree = data.getBooleanExtra("rbagree", rbagree);
                Log.i("rbagree", rbagree + "");
                //rb_agree.setChecked(rbagree);
                Log.i("同意备注", wenjie + "");
                disaagreeremark = "";
                ratifyremark = "";
                checkId = "";
                break;
            case 2:
                agreeType = 2;
                disaagreeremark = data.getStringExtra("disagreeremark");
                Log.i("不同意备注", disaagreeremark);
                agreeremark = "";
                ratifyremark = "";
                checkId = "";
                break;
            case 3:
                agreeType = 3;
                if (Myapplication.loginBean.getUserid() == 183) {
                    ratifyremark = data.getStringExtra("zhratifyremark");
                } else {
                    ratifyremark = data.getStringExtra("ratifyremark");

                }
                Log.i("会签备注", ratifyremark);
                if (Myapplication.loginBean.getUserid() == 183) {
                    checkId = data.getStringExtra("checked");
                } else {
                    checkId = data.getStringExtra("checkId");
                }
                Log.i("会签id", checkId);
                disaagreeremark = "";
                agreeremark = "";
                break;


        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void dialog(final int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("确认下载吗？");
        builder.setTitle("保存到" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                if (i == 1) {
                    maindownload(mainUrl);
                } else if (i == 2) {
                    fuUrl = dataBean.getHetongurl();
                    fuName = dataBean.getFujianname();
                    String fuNames[] = fuName.split(",");

                    String fuLisr[] = fuUrl.split(",");
                    String qian[] = fuLisr[0].split("=");
                    for (int i = 0; i < fuLisr.length - 1; i++) {
                        if (fuLisr.length == 2) {
                            downUrl = fuLisr[0] + fuLisr[fuLisr.length - 1];
                            fujiandownload(downUrl, fuNames[i]);
                            break;
                        } else {
                            if (i == 0) {
                                downUrl = fuLisr[0] + fuLisr[fuLisr.length - 1];
                                fujiandownload(downUrl, fuNames[i]);
                            } else {
                                downUrl = qian[0] + fuLisr[i] + fuLisr[fuLisr.length - 1];
                                fujiandownload(downUrl, fuNames[i]);
                            }
                        }
                    }
                }
                dialog.dismiss();

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();

    }


}
