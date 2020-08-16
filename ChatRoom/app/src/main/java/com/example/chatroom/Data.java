package com.example.chatroom;

import org.litepal.crud.LitePalSupport;

public class Data extends LitePalSupport {
    private String content;
    private int type;
    private String name;
    private int num;
    private boolean judge;
    private String afftime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isJudge() {
        return judge;
    }

    public void setJudge(boolean judge) {
        this.judge = judge;
    }

    public String getAfftime() {
        return afftime;
    }

    public void setAfftime(String afftime) {
        this.afftime = afftime;
    }
}
