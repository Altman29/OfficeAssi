package com.zixu.officeassi.utils;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * okhttp管理类
 */
public class HttpOH {
    /**
     * 连接超时(默认：30秒)
     */
    public static int TimeOut = 30;

    private static OkHttpClient getHttpClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(TimeOut, TimeUnit.SECONDS);
        return client;
    }


    /**
     * 提交formBody的参数
     */

    public static void postData(String url, RequestBody formBody, ACallOkHttp cb, Class<?> resultClass, int tag) {
        if (url.isEmpty()) {
            return;
        }
        Gson gson = new Gson();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        cb.registerClass(resultClass, tag);
        cb.onBeforeRequest(tag);
        getHttpClient().newCall(request).enqueue(cb);
    }

    /**
     * 下载
     *
     * @param url
     * @param destFileDir
     * @param callback
     * @param tag
     */
    public static void downloadAsyn(final String url, final String destFileDir,final String fileName, final ACallOkHttp callback, final int tag) {

        Request request = new Request.Builder().url(url).get().build();
        callback.onBeforeRequest(tag);
        Call call = getHttpClient().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onFailure(request, e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    InputStream is = response.body().byteStream();
                    File file = new File(destFileDir);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File downLoad = new File(destFileDir, fileName);
                    FileOutputStream fos = new FileOutputStream(downLoad);
                    int len = -1;
                    byte[] buffer = new byte[1024];
                    while ((len = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                    }
                    fos.flush();
                    fos.close();
                    is.close();
                    callback.onResultRequest(tag, downLoad);
                }
            }

        });
    }
}
