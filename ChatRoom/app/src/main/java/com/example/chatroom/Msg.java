package com.example.chatroom;

import android.widget.ImageView;
import android.widget.TextView;

public class Msg {
    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SENT=1;
    private String content;
    private int type;
    private String name;
    private int num;
    private ImageView touxiang;
    private TextView time;
    private boolean judge;
    private String afftime;

    public Msg(String content,int type,String name,int num,boolean judge){
        this.content=content;
        this.type=type;
        this.name=name;
        this.num=num;
        this.judge=judge;
    }

    public Msg(String content,int type,String name,int num,boolean judge,String afftime){
        this.content=content;
        this.type=type;
        this.name=name;
        this.num=num;
        this.judge=judge;
        this.afftime=afftime;
    }

    public String getContent(){
        return  content;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public boolean isJudge() {
        return judge;
    }

    public String getAfftime() {
        return afftime;
    }
}
