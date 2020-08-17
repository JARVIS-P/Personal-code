package com.example.androidthreadtest;
//AsyncTask的一个不完整练习
/*import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

public class DownloadTask extends AsyncTask<Void,Integer,Boolean> {
    ProgressDialog progressDialog;
    @Override
    protected void onPreExecute() {
        ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.show();//显示进度对话框
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try{
            while(true){
                int downloadPercent=doDownload();//这是一个虚拟的方法
                publishProgress(downloadPercent);
                if(downloadPercent>=100){
                    break;
                }
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //在这里更新下载进度
        progressDialog.setMessage("Downloaded"+values[0]+"%");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        progressDialog.dismiss();//关闭进度对话框
        if(aBoolean){
            Toast.makeText(context,"Download succeeded",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Download failed",Toast.LENGTH_SHORT).show();
        }
    }
}*/
