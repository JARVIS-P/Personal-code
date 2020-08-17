package com.example.networktest;

import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                /*if(!isNetworkAvailable()){//若无网络Toast后直接退出
                    Toast.makeText(MyApplication.getContext(),"network is unavailable",Toast.LENGTH_SHORT).show();
                    return;
                }*/
                //获取connection实例
                HttpURLConnection connection=null;
                try {
                    //设置url
                    URL url=new URL(address);
                    //将url放在conncetion中
                    connection=(HttpURLConnection) url.openConnection();
                    //设置请求类型
                    connection.setRequestMethod("GET");
                    //各种属性设置
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    //用io流获取响应
                    InputStream in=connection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    //操作数据
                    StringBuilder response=new StringBuilder();
                    String line;
                    while ((line=reader.readLine())!=null){
                        response.append(line);
                    }
                    if(listener!=null){
                        listener.onFinish(response.toString());
                    }
                } catch (Exception e) {
                    if(listener!=null){
                        listener.onError(e);
                    }
                } finally {
                    //释放资源
                    if(connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        //获得client实例
        OkHttpClient client=new OkHttpClient();
        //设置请求
        Request request=new Request.Builder()
                .url(address)
                .build();
        //获取响应
        client.newCall(request).enqueue(callback);
    }
}
