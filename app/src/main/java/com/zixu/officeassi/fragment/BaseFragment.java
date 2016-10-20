package com.zixu.officeassi.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {
    //创建fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity mAcivity = getActivity();
    }
    //Fragment填充布局
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstamceState) {
        View view = initView();
        return view;
    }

    //初始化布局
    public abstract View initView();


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected void initData() {

    }
}
