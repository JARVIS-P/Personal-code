package com.example.chatroom;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsgList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        TextView myNmae;
        TextView y_name;
        ImageView my_touxiang;
        ImageView y_touxiang;
        TextView s_time;
        TextView r_time;
        String afftime;
        int num;
        boolean judge;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftLayout=(LinearLayout) itemView.findViewById(R.id.left_layout);
            rightLayout=(LinearLayout) itemView.findViewById(R.id.right_layout);
            leftMsg=(TextView) itemView.findViewById(R.id.left_msg);
            rightMsg=(TextView) itemView.findViewById(R.id.right_msg);
            myNmae=(TextView) itemView.findViewById(R.id.my_name);
            y_name=(TextView) itemView.findViewById(R.id.your_name);
            my_touxiang=(ImageView) itemView.findViewById(R.id.my_touxiang);
            y_touxiang=(ImageView) itemView.findViewById(R.id.your_touxiang);
            s_time=(TextView) itemView.findViewById(R.id.s_time);
            r_time=(TextView) itemView.findViewById(R.id.r_time);
        }
    }
    public MsgAdapter(List<Msg> msgList){
        mMsgList=msgList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Msg msg=mMsgList.get(position);
        if(msg.getType()==Msg.TYPE_RECEIVED){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
            holder.y_name.setText(msg.getName());
            holder.judge=msg.isJudge();
            holder.afftime=msg.getAfftime();
            if(holder.judge){
                if(holder.afftime!=null){
                    holder.r_time.setText(holder.afftime);
                } else {
                    DateFormat sdf = new SimpleDateFormat("hh:mm:ss ");
                    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
                    String temp=sdf.format(new Date());
                    holder.r_time.setText(temp);
                }
            }else {
                holder.r_time.setVisibility(View.GONE);
            }
            holder.num=msg.getNum();
            if(holder.num==1) {
                holder.y_touxiang.setImageResource(R.drawable.touxiang1);
            }
            if(holder.num==2) {
                holder.y_touxiang.setImageResource(R.drawable.touxiang2);
            }
            if(holder.num==3) {
                holder.y_touxiang.setImageResource(R.drawable.touxiang3);
            }
            if(holder.num==4) {
                holder.y_touxiang.setImageResource(R.drawable.touxiang4);
            }
            if(holder.num==5) {
                holder.y_touxiang.setImageResource(R.drawable.touxiang5);
            }
            if(holder.num==6) {
                holder.y_touxiang.setImageResource(R.drawable.touxiang6);
            }
        }else if(msg.getType()==Msg.TYPE_SENT){
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
            holder.myNmae.setText(msg.getName());
            holder.judge=msg.isJudge();
            holder.afftime=msg.getAfftime();
            if(holder.judge){
                if(holder.afftime!=null){
                    holder.s_time.setText(holder.afftime);
                } else {
                    DateFormat sdf = new SimpleDateFormat("hh:mm:ss ");
                    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
                    String temp=sdf.format(new Date());
                    holder.s_time.setText(temp);
                }
            }else {
                holder.s_time.setVisibility(View.GONE);
            }
            holder.num=msg.getNum();
            if(holder.num==1) {
                holder.my_touxiang.setImageResource(R.drawable.touxiang1);
            }
            if(holder.num==2) {
                holder.my_touxiang.setImageResource(R.drawable.touxiang2);
            }
            if(holder.num==3) {
                holder.my_touxiang.setImageResource(R.drawable.touxiang3);
            }
            if(holder.num==4) {
                holder.my_touxiang.setImageResource(R.drawable.touxiang4);
            }
            if(holder.num==5) {
                holder.my_touxiang.setImageResource(R.drawable.touxiang5);
            }
            if(holder.num==6) {
                holder.my_touxiang.setImageResource(R.drawable.touxiang6);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
