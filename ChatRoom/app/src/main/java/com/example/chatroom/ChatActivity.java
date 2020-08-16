package com.example.chatroom;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.exceptions.DataSupportException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.BreakIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import javax.sql.DataSource;

public class ChatActivity extends AppCompatActivity {
    private List<Msg> msgList=new ArrayList<>();//滑动布局的数据
    RecyclerView msgRecyclerView;//滑动布局
    MsgAdapter adapter;//滑动布局适配器
    Socket client=null;//申请的客户端
    String text="";//发送的字符串
    Msg msg;//消息对象
    EditText edit_text;//聊天输入框
    Button button_send;//发送按钮
    String ip;//获取ip地址
    String port;//获取端口
    String name;//获取用户名
    int num;
    String[] temp;
    boolean judge=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //请求在主线程应用数据
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //获取用户的登录信息
        Intent intent=getIntent();
        ip=intent.getStringExtra("ip");
        port=intent.getStringExtra("port");
        name=intent.getStringExtra("name");
        num=intent.getIntExtra("num",1);
        //数据库初始化
        initMsgs();
        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        //布置滑动布局，获取实例
        msgRecyclerView=(RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter=new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        edit_text=(EditText) findViewById(R.id.edit_text);
        button_send=(Button) findViewById(R.id.button_send);
        //操作
        try {
            client=new Socket(ip, Integer.parseInt(port));
            new Thread(new Send(client,name)).start();
            new Thread(new Receive(client)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //将消息打包加入到滑动布局中
    protected void pack(Msg msg){
        msgList.add(msg);
        adapter.notifyItemInserted(msgList.size()-1);
        msgRecyclerView.scrollToPosition(msgList.size()-1);
    }
    //发送消息线程
    protected class Send implements Runnable {
        private DataOutputStream dos;
        private Socket client;
        private String name1;
        public Send(Socket cilent,String name1){
            text=edit_text.getText().toString();
            this.client=cilent;
            this.name1=name1;
            try {
                dos=new DataOutputStream(cilent.getOutputStream());
                send02(name1);
            } catch (IOException e) {
                this.release();
            }
        }
        @Override
        public void run() {
            send();
        }
        private void send02(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                release();
            }
        }
        private void send(){
            button_send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        text=edit_text.getText().toString();
                        if(!text.equals("")){
                            edit_text.setText("");
                            if(judge){
                                msg = new Msg(text, Msg.TYPE_SENT,name,num,true);
                                Data data=new Data();
                                data.setContent(text);
                                data.setType(Msg.TYPE_SENT);
                                data.setName(name);
                                data.setNum(num);
                                data.setJudge(true);
                                DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                                sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
                                String temp=sdf.format(new Date());
                                data.setAfftime(temp);
                                data.save();
                                judge=false;
                                pack(msg);
                                text=name+","+text+","+num+","+true+","+temp;
                                dos.writeUTF(text);
                                dos.flush();
                            }else {
                                msg = new Msg(text, Msg.TYPE_SENT,name,num,false);
                                Data data=new Data();
                                data.setContent(text);
                                data.setType(Msg.TYPE_SENT);
                                data.setName(name);
                                data.setNum(num);
                                data.setJudge(false);
                                data.setAfftime(null);
                                data.save();
                                pack(msg);
                                text=name+","+text+","+num+","+false+","+null;
                                dos.writeUTF(text);
                                dos.flush();
                            }
                        }
                    } catch (IOException e) {
                        release();
                    }
                }
            });
        }
        private void release(){
            Utils.close(dos,client);
        }
    }
    //接收消息线程
    protected class Receive implements Runnable{
        DataInputStream dis;
        private Socket client;
        private boolean isRunning;
        public Receive(Socket client){
            this.client=client;
            try {
                dis=new DataInputStream(client.getInputStream());
                isRunning=true;
            } catch (IOException e) {
                this.release();
            }
        }
        @Override
        public void run() {
            while(isRunning) {
                try {
                    text = dis.readUTF();
                    temp=text.split(",");
                    //不能在非ui创建线程中修改ui
                    ChatActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(judge) {
                                msg = new Msg(temp[1], Msg.TYPE_RECEIVED, temp[0], Integer.parseInt(temp[2]), true);
                                Data data=new Data();
                                data.setContent(temp[1]);
                                data.setType(Msg.TYPE_RECEIVED);
                                data.setName(temp[0]);
                                data.setNum(Integer.parseInt(temp[2]));
                                data.setJudge(true);
                                /*DateFormat sdf = new SimpleDateFormat("hh:mm:ss ");
                                sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
                                String temp=sdf.format(new Date());*/
                                data.setAfftime(temp[4]);
                                data.save();
                                judge = false;
                            } else {
                                msg = new Msg(temp[1], Msg.TYPE_RECEIVED, temp[0], Integer.parseInt(temp[2]), false);
                                Data data=new Data();
                                data.setContent(temp[1]);
                                data.setType(Msg.TYPE_RECEIVED);
                                data.setName(temp[0]);
                                data.setNum(Integer.parseInt(temp[2]));
                                data.setJudge(false);
                                data.setAfftime(temp[4]);
                                data.save();
                            }
                            pack(msg);
                        }
                    });
                } catch (IOException e) {
                    this.release();
                }
            }
        }
        private void release() {
            this.isRunning = false;
            Utils.close(dis, client);
        }
    }
    private void initMsgs(){
        List<Data> datas=LitePal.findAll(Data.class);
        for (Data data:datas){
            if(data.getName().equals(name)){
                msg=new Msg(data.getContent(),Msg.TYPE_SENT,data.getName(),data.getNum(),data.isJudge(),data.getAfftime());
            }else {
                if(data.getContent().startsWith("@")){
                    int idx=data.getContent().indexOf(":");
                    if(name.equals(data.getContent().substring(1,idx))){
                        msg=new Msg(data.getContent(),Msg.TYPE_RECEIVED,data.getName(),data.getNum(),data.isJudge(),data.getAfftime());
                    }else continue;
                } else msg=new Msg(data.getContent(),Msg.TYPE_RECEIVED,data.getName(),data.getNum(),data.isJudge(),data.getAfftime());
            }
            msgList.add(msg);
        }
    }
}