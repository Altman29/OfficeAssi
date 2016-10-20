package com.zixu.officeassi;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.zhy.autolayout.AutoLayoutActivity;
import com.zixu.officeassi.fragment.MyapplFragment;
import com.zixu.officeassi.fragment.MyapplcgFragment;
import com.zixu.officeassi.fragment.MyapplsbFragment;
import com.zixu.officeassi.fragment.MyapplshzFragment;
import com.zixu.officeassi.fragment.MyapplssFragment;
import com.zixu.officeassi.fragment.MyapprFragment;
import com.zixu.officeassi.fragment.MyapprssFragment;
import com.zixu.officeassi.utils.SharedPreferencesUtils;


public class ApproveActivity extends AutoLayoutActivity implements View.OnClickListener {
    private TextView tv_myappr;
    private TextView tv_myappl;
    private ListView lv_approve;
    private ImageView iv_approve_search;
    private ImageView iv_approve_fanhui;
    private View bottom1;
    private View bottom2;
    private LinearLayout ll_approve;
    private LinearLayout ll_approve_title;
    private EditText et_approve_search;
    private ImageView iv_search_close;
    private TextView tv_search_cancle;
    private LinearLayout ll_approve_search;

    Context context = this;
    private ImageView iv_search_close1;
    private ImageView iv_approve_sousuo;
    private Button bt_cg;
    private Button bt_sb;
    private Button bt_shz;
    private String search;
    private TextView tv_sousuo;
    private MyapplFragment myapplFragment;
    private MyapprFragment myapprFragment;
    private PopupWindow popupWindow;

    //找到控件
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve);
        findView();
        onClick(tv_myappr);


    }

    private void findView() {
        tv_myappr = (TextView) findViewById(R.id.tv_myappr);
        tv_myappl = (TextView) findViewById(R.id.tv_myappl);
        iv_approve_fanhui = (ImageView) findViewById(R.id.iv_approve_fanhui);
        iv_approve_search = (ImageView) findViewById(R.id.iv_approve_search);
        bottom1 = findViewById(R.id.view_bottom1);
        bottom2 = findViewById(R.id.view_bottom2);
        ll_approve = (LinearLayout) findViewById(R.id.ll_approve);
        ll_approve_title = (LinearLayout) findViewById(R.id.ll_approve_title);
        et_approve_search = (EditText) findViewById(R.id.et_approve_search);
        iv_search_close = (ImageView) findViewById(R.id.iv_search_close);
        tv_search_cancle = (TextView) findViewById(R.id.tv_search_cancle);
        ll_approve_search = (LinearLayout) findViewById(R.id.ll_approve_search);
        iv_approve_sousuo = (ImageView) findViewById(R.id.iv_approve_sousuo);
        tv_sousuo = (TextView) findViewById(R.id.tv_sousuo);
        tv_myappl.setOnClickListener(this);
        tv_myappr.setOnClickListener(this);
        iv_approve_fanhui.setOnClickListener(this);
        iv_approve_search.setOnClickListener(this);
        tv_search_cancle.setOnClickListener(this);
        ll_approve_search.setVisibility(View.GONE);
        iv_approve_sousuo.setOnClickListener(this);
        tv_sousuo.setOnClickListener(this);
    }

    //设置点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_myappl:
                tv_myappl.setTextColor(getResources().getColor(R.color.colorAppr));
                tv_myappr.setTextColor(getResources().getColor(R.color.colorApp));
                bottom1.setBackgroundColor(getResources().getColor(R.color.colorwrite));
                bottom2.setBackgroundColor(getResources().getColor(R.color.colorAppr));
                myapplFragment = new MyapplFragment();
                initFragment(myapplFragment);
                showPopupWindow(v);
                break;
            case R.id.tv_myappr:
                tv_myappl.setTextColor(getResources().getColor(R.color.colorApp));
                tv_myappr.setTextColor(getResources().getColor(R.color.colorAppr));
                bottom1.setBackgroundColor(getResources().getColor(R.color.colorAppr));
                bottom2.setBackgroundColor(getResources().getColor(R.color.colorwrite));
                myapprFragment = new MyapprFragment();
                initFragment(myapprFragment);
                break;
            case R.id.iv_approve_fanhui:
                finish();
                break;
            case R.id.iv_approve_search:
                ll_approve_title.setVisibility(View.GONE);
                ll_approve_search.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_search_cancle:
                ll_approve_title.setVisibility(View.VISIBLE);
                ll_approve_search.setVisibility(View.GONE);
                break;
            case R.id.iv_search_close:
                break;
            case R.id.tv_sousuo:

                search = et_approve_search.getText().toString().trim();
                SharedPreferencesUtils.saveStringData(getApplicationContext(), "search", search);
                Log.i("woshi搜索", search);
                if (myapprFragment.isVisible()) {
                    Log.i("myapprFragment", "myapprFragment");
                    initFragment(new MyapprssFragment());
                } else {
                    initFragment(new MyapplssFragment());
                    Log.i("myapplFragment", "myapplFragment");
                }
                break;
            default:
                break;
        }
    }

    //popuwidnows的点击事件
    private void showPopupWindow(View v) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.pop_window, null);
        // 设置按钮的点击事件
        bt_cg = (Button) contentView.findViewById(R.id.bt_cg);
        bt_sb = (Button) contentView.findViewById(R.id.bt_sb);
        bt_shz = (Button) contentView.findViewById(R.id.bt_shz);

        bt_cg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFragment(new MyapplcgFragment());
                popupWindow.dismiss();
            }
        });

        bt_sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFragment(new MyapplsbFragment());
                popupWindow.dismiss();
            }
        });

        bt_shz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFragment(new MyapplshzFragment());
                popupWindow.dismiss();
            }
        });

        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }

        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button));

        // 设置好参数之后再show
        popupWindow.showAsDropDown(v, 80, 0);

    }

    //初始化Fragment
    private void initFragment(Fragment myapplFragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.ll_approve, myapplFragment, "");
        ft.commit();
    }
}
