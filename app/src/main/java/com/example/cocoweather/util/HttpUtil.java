package com.example.cocoweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Jun.Zhou on 2018/4/11.
 */

public class HttpUtil {
    public static void sendOKhttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
