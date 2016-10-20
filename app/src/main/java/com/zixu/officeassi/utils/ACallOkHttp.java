package com.zixu.officeassi.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;


public abstract class ACallOkHttp implements Callback {

    private int tag = 0;
    private Class<?> resultClass = null;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    onResultRequest(msg.arg1, msg.obj);
                    break;
                case 2:
                    onErrorRequest(msg.arg1, (String) msg.obj);
                    break;
            }
        }
    };

    @Override
    public void onFailure(Request request, IOException e) {
        Message message = new Message();
        message.obj = e.getLocalizedMessage();
        message.arg1 = tag;
        message.what = 2;
        handler.sendMessage(message);
    }

    @Override
    public void onResponse(Response response) {
        Gson gson = new Gson();
        String json = null;

        try {
            json = response.body().string();
            Log.i("请求网络", json + "==");
            Object bean = gson.fromJson(json, resultClass);
            Message message = new Message();
            message.obj = bean;
            message.arg1 = tag;
            message.what = 1;
            handler.sendMessage(message);

        } catch (IOException e) {
            e.printStackTrace();
            onErrorRequest(tag, "JSON解析失败!");
        }
    }

    public void registerClass(Class<?> resultClass, int tag) {
        this.resultClass = resultClass;
        this.tag = tag;
    }


    //请求开始

    public abstract void onBeforeRequest(int tag);

    //请求成功
    public abstract void onResultRequest(int tag, Object bean);

     //请求失败
    public abstract void onErrorRequest(int tag, String e);

}
