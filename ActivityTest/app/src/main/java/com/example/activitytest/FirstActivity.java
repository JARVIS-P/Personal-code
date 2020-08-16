package com.example.activitytest;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.e("FirstActivity","onRestart");
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnData);
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("FirstActivity","Task id is "+getTaskId());
        setContentView(R.layout.first_layout);
        Button button1=(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SecondActivity.actionStart(FirstActivity.this,"data1","data2");
            }
        });
        /*Button button1=(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);*/
                /*String data="Hello SecoundActivity";//向下传递参数
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);*/
                /*Intent intent=new Intent(Intent.ACTION_DIAL);//隐式Intent打开拨号
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/
                /*Intent intent=new Intent(Intent.ACTION_VIEW);//隐式Intent打开百度网页
                 intent.setData(Uri.parse("http://baidu.com"));
                 startActivity(intent);*/
                /*Intent intent=new Intent("com.example.activitytest.ACTION_START");//隐式Intent
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);*/
                /*Intent intent=new Intent(FirstActivity.this,SecondActivity.class);//显式Intent
                startActivity(intent);*/
                /*Toast.makeText(FirstActivity.this,"You clicked Button1",//反馈信息
                        Toast.LENGTH_SHORT).show();*/
                //finish();//关闭
        /*    }
        });*/
    }
}