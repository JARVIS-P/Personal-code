package com.example.fragmentest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RightFragment extends Fragment {
    public static final String TAG="RightFragment";

    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach");
    }

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        Log.e(TAG, "onCreate");
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        View view=inflater.inflate(R.layout.right_fragment,container,false);
        return view;
    }

    public void onActivityCreated(Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);
        Log.e(TAG, "onActivityCreated:");
    }
    public void onStart(){
        super.onStart();
        Log.e(TAG, "onStart");
    }

    public void onResume(){
        super.onResume();
        Log.e(TAG, "onResume");
    }

    public void onPause(){
        super.onPause();
        Log.e(TAG, "onPause");
    }

    public void onStop(){
        super.onStop();
        Log.e(TAG, "onStop");
    }

    public void onDestroyView(){
        super.onDestroyView();
        Log.e(TAG, "onDestroyView");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    public void onDetach(){
        super.onDetach();
        Log.e(TAG, "onDetach");
    }
}
