package com.example.chatroom;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityList.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityList.remove(this);
    }
}
