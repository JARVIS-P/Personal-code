package com.example.activitylifecycletest;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData="Somthing you just typed";
        outState.putString("data_key",tempData);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            String tempData=savedInstanceState.getString("data_key");
            Log.e(TAG,tempData);
        }
        Button startNormalActivity=(Button)findViewById(R.id.start_nromal_activity);
        Button startDialogActivity=(Button)findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Normal_Activity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.e(TAG,"onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.e(TAG,"onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.e(TAG,"onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.e(TAG,"onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }
    @Override
    protected void onRestart(){
        super.onRestart();;
        Log.e(TAG,"onReStart");
    }
}