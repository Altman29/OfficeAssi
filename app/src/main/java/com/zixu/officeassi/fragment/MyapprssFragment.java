package com.zixu.officeassi.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;
import com.zixu.officeassi.ContractActivity;
import com.zixu.officeassi.Myapplication;
import com.zixu.officeassi.R;
import com.zixu.officeassi.adapter.MyAdapter;
import com.zixu.officeassi.bean.UserBean;
import com.zixu.officeassi.utils.ACallOkHttp;
import com.zixu.officeassi.utils.HttpOH;
import com.zixu.officeassi.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;


public class MyapprssFragment extends BaseFragment {

    private ListView lv_myappr;
    private MyAdapter myAdapter;
    private List<UserBean.DataListBean> data = new ArrayList<UserBean.DataListBean>();
    private Gson gson;
    private UserBean dataBean;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_myappr, null);
        findViews(view);
        return view;
    }

    private void findViews(View view) {
        lv_myappr = (ListView) view.findViewById(R.id.lv_myappl);
        //获取数据,以bean的方式封装到list集合中
        myAdapter = new MyAdapter(getActivity(), data);
        lv_myappr.setAdapter(myAdapter);
        gson = new Gson();
        postData();
        setListner();


    }

    private void setListner() {
        lv_myappr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ContractActivity.class);
                intent.putExtra("sys_id", data.get(position).getSys_id());
                intent.putExtra("is_hq",data.get(position).getIs_hq());
                startActivityForResult(intent,1000);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode){
            case 1:
                postData();
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //请求网络获取数据
    private void postData() {
        Myapplication.loginBean.getUserid();
        RequestBody formBody = new FormEncodingBuilder()
                .add("user_id", Myapplication.loginBean.getUserid() + "")//添加参数
                .add("imei", SharedPreferencesUtils.getStringData(getContext(),"imei",""))
                .add("search",SharedPreferencesUtils.getStringData(getContext(),"search",""))
                .build();
        Log.i("传过来的 user_id", Myapplication.loginBean.getUserid() + "");
        Log.i("传过来的 imei",SharedPreferencesUtils.getStringData(getContext(),"imei",""));
        Log.i("传过来的 search",SharedPreferencesUtils.getStringData(getContext(),"search",""));
        HttpOH.postData("http://crm.1qfa.com/appInterface/Search.ashx", formBody, new ACallOkHttp() {


            @Override
            public void onBeforeRequest(int tag) {
            }

            @Override
            public void onResultRequest(int tag, Object bean) {
                dataBean = (UserBean) bean;
                if (dataBean != null) {
                    data.clear();
                    data.addAll(dataBean.getData());
                    myAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onErrorRequest(int tag, String e) {

            }
        }, UserBean.class, 1);
    }
}
