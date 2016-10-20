package com.zixu.officeassi.fragment;

import android.content.Intent;
import android.os.Message;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;
import com.zixu.officeassi.Contract1Activity;
import com.zixu.officeassi.Myapplication;
import com.zixu.officeassi.R;
import com.zixu.officeassi.RefreshableView;
import com.zixu.officeassi.adapter.MylAdapter;
import com.zixu.officeassi.bean.UserBean;
import com.zixu.officeassi.utils.ACallOkHttp;
import com.zixu.officeassi.utils.HttpOH;
import com.zixu.officeassi.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;


public class MyapplcgFragment extends BaseFragment {

    private ListView lv_myappr;
    private MylAdapter mylAdapter;
    private List<UserBean.DataListBean> data = new ArrayList<UserBean.DataListBean>();
    private List<UserBean.DataListBean> alldata = new ArrayList<UserBean.DataListBean>();

    private Gson gson;
    private View bottom1;
    private View bottom2;
    private UserBean dataBean;
    private TextView tv_cg;
    private TextView tv_sb;
    private RefreshableView refreshableView;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_myappl, null);
        findViews(view);
        return view;
    }

    private void findViews(View view) {
        lv_myappr = (ListView) view.findViewById(R.id.lv_myappl);
        refreshableView = (RefreshableView) view.findViewById(R.id.refreshable_view);

        //获取数据,以bean的方式封装到list集合中
        mylAdapter = new MylAdapter(getActivity(), data);
        lv_myappr.setAdapter(mylAdapter);
        gson = new Gson();
        postData();

        setListner();
        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    handler.sendMessage(new Message());
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                refreshableView.finishRefreshing();
            }
        }, 0);
    }

    Handler handler = new Handler()//Looper.getMainLooper()
    {
        public void handleMessage(Message msg) {
            postData();
        }

    };

    private void setListner() {
        lv_myappr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Contract1Activity.class);
                intent.putExtra("sys_id", data.get(position).getSys_id());
                intent.putExtra("is_hq", data.get(position).getIs_hq());
                startActivityForResult(intent, 1000);
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
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
                .add("office", Myapplication.loginBean.getOffid() + "")
                .add("imei", SharedPreferencesUtils.getStringData(getContext(), "imei", ""))
                .build();
        Log.i("传过来的 user_id", Myapplication.loginBean.getUserid() + "");
        Log.i("传过来的 imei", SharedPreferencesUtils.getStringData(getContext(), "imei", ""));
        HttpOH.postData("http://crm.1qfa.com/appInterface/AlreadyPass.ashx", formBody, new ACallOkHttp() {


            @Override
            public void onBeforeRequest(int tag) {
            }

            @Override
            public void onResultRequest(int tag, Object bean) {
                dataBean = (UserBean) bean;
                if (dataBean != null) {

                    alldata.addAll(dataBean.getData());
                    for (int i = 0; i < alldata.size(); i++) {
                        if (alldata.get(i).getStatus() == 2) {
                            data.add(alldata.get(i));
                        }
                    }
                    mylAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onErrorRequest(int tag, String e) {

            }
        }, UserBean.class, 1);
    }


}
