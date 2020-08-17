package com.example.chatroom;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    EditText edit_ip;
    EditText edit_port;
    EditText edit_name;
    Intent intent;
    Socket client;
    boolean a=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        edit_ip=(EditText) findViewById(R.id.edit_ip);
        edit_port=(EditText) findViewById(R.id.edit_port);
        edit_name=(EditText) findViewById(R.id.edit_name);
        intent=new Intent(MainActivity.this,SelectActivity.class);
        Button enter=(Button) findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("ip",edit_ip.getText().toString());
                intent.putExtra("port",edit_port.getText().toString());
                intent.putExtra("name",edit_name.getText().toString());
                if(!judge(edit_port.getText().toString())){
                    Toast.makeText(MainActivity.this, "请输入正确端口", Toast.LENGTH_SHORT).show();
                    return;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            client = new Socket(edit_ip.getText().toString(), Integer.parseInt(edit_port.getText().toString()));
                            a=false;
                            startActivity(intent);
                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivity.this, "链接成功", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(a){
                    Toast.makeText(MainActivity.this, "链接失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean judge(String a){
        for(int i=0;i<a.length();i++){
            if(!Character.isDigit(a.charAt(i))){
                return false;
            }
        }
        return true;
    }
}