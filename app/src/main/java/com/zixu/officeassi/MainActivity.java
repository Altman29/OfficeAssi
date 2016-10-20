package com.zixu.officeassi;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;

import com.zhy.autolayout.AutoLayoutActivity;
import com.zixu.officeassi.fragment.ContentFragment;

public class MainActivity extends AutoLayoutActivity {

    private LinearLayout ll_main;
    private LinearLayout ll_home;
    private LinearLayout ll_work;
    private LinearLayout ll_knowledge;
    private LinearLayout ll_my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置四个主界面
        ll_main = (LinearLayout) findViewById(R.id.ll_main);
        ll_home = (LinearLayout) findViewById(R.id.ll_home);
        ll_work = (LinearLayout) findViewById(R.id.ll_work);
        ll_knowledge = (LinearLayout) findViewById(R.id.ll_knowledge);
        ll_my = (LinearLayout) findViewById(R.id.ll_my);
        initFragment();

    }

    //初始化Fragment
    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction ft = fm.beginTransaction();
        //替换布局
        ft.replace(R.id.ll_main, new ContentFragment(), "");
        //提交事务
        ft.commit();

    }
}
