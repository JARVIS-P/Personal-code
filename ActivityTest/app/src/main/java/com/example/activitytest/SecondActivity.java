package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.BlockingDeque;

public class SecondActivity extends BaseActivity {
    public static void actionStart(Context context,String data1,String data2){
        Intent intent=new Intent(context,SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("SecondActivity","onDestroy");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("SecoundActivity","Task id is "+getTaskId());
        setContentView(R.layout.second_layout);
        Button button2=(Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
        /*Button button2=(Button) findViewById(R.id.button_2);//向上返回数据
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("data_return","Hello FirstActivity");
                setResult(RESULT_OK,intent);
                finish();
            }
        });*/
        /*Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        Log.d("SecondActivity",data);*///向下参数的传递
    }
    @Override
    public void onBackPressed(){
        Intent intent=new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }
}