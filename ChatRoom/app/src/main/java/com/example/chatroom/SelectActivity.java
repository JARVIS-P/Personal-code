package com.example.chatroom;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.Socket;

public class SelectActivity extends BaseActivity {
    ImageView touxiang01;
    ImageView touxiang02;
    ImageView touxiang03;
    ImageView touxiang04;
    ImageView touxiang05;
    ImageView touxiang06;
    String ip;//获取ip地址
    String port;//获取端口
    String name;//获取用户名
    int num;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        ImageView touxiang01=(ImageView) findViewById(R.id.touxiang01);
        ImageView touxiang02=(ImageView) findViewById(R.id.touxiang02);
        ImageView touxiang03=(ImageView) findViewById(R.id.touxiang03);
        ImageView touxiang04=(ImageView) findViewById(R.id.touxiang04);
        ImageView touxiang05=(ImageView) findViewById(R.id.touxiang05);
        ImageView touxiang06=(ImageView) findViewById(R.id.touxiang06);
        ImageView back=(ImageView) findViewById(R.id.back);
        intent=getIntent();
        ip=intent.getStringExtra("ip");
        port=intent.getStringExtra("port");
        name=intent.getStringExtra("name");
        intent=new Intent(SelectActivity.this,ChatActivity.class);
        touxiang01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num=1;
                intent.putExtra("ip",ip);
                intent.putExtra("port",port);
                intent.putExtra("name",name);
                intent.putExtra("num",num);
                startActivity(intent);
            }
        });
        touxiang02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num=2;
                intent.putExtra("ip",ip);
                intent.putExtra("port",port);
                intent.putExtra("name",name);
                intent.putExtra("num",num);
                startActivity(intent);
            }
        });
        touxiang03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num=3;
                intent.putExtra("ip",ip);
                intent.putExtra("port",port);
                intent.putExtra("name",name);
                intent.putExtra("num",num);
                startActivity(intent);
            }
        });
        touxiang04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num=4;
                intent.putExtra("ip",ip);
                intent.putExtra("port",port);
                intent.putExtra("name",name);
                intent.putExtra("num",num);
                startActivity(intent);
            }
        });
        touxiang05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num=5;
                intent.putExtra("ip",ip);
                intent.putExtra("port",port);
                intent.putExtra("name",name);
                intent.putExtra("num",num);
                startActivity(intent);
            }
        });
        touxiang06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num=6;
                intent.putExtra("ip",ip);
                intent.putExtra("port",port);
                intent.putExtra("name",name);
                intent.putExtra("num",num);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityList.finishAll();
            }
        });
    }
}