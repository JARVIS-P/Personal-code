package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 聊天室服务器
 */
public class Server {
    private static CopyOnWriteArrayList<Channel> all=new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("-------Server-------");
        ServerSocket server=new ServerSocket(8888);
        int num=0;
        while(true) {
            Socket client=server.accept();
            System.out.println(" 一个客户端建立了连接");
            num++;
            if(num%2==0) {
                Channel c=new Channel(client);
                all.add(c);
                new Thread(c).start();
            }
        }
    }

    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;
        private String name;

        public Channel(Socket client) {
            this.client=client;
            try {
                dis=new DataInputStream(client.getInputStream());
                dos=new DataOutputStream(client.getOutputStream());
                isRunning=true;
                this.name=receive();
            } catch (IOException e) {
                release();
            }
        }
        //接收消息
        private String receive(){
            String msg="";
            try {
                msg=dis.readUTF();
            } catch (IOException e) {
                release();
            }
            return msg;
        }
        //给别人发送消息
        private void sendOthers(String msg) {
            String[] temp=msg.split(",");
            if(temp[1].startsWith("@")) {
                int idx=temp[1].indexOf(":");
                String targetName=temp[1].substring(1,idx).trim();
                for(Channel other:all) {
                    if(other.name.equals(targetName)) {
                        other.send(msg);
                    }
                }
            }
            else {
                for(Channel other:all) {
                    if(other==this) {
                        continue;
                    }
                    other.send(msg);
                }
            }
        }
        //给自己发送消息
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                release();
            }
        }
        //释放资源
        private void release() {
            this.isRunning=false;
            Utils.close(dis,dos,client);
            all.remove(this);
        }
        @Override
        public void run() {
            while(isRunning) {
                String msg=receive();
                if(!msg.equals("")) {
                    sendOthers(msg);
                }
            }
        }
    }
}
