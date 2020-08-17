package com.example.litepaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase=(Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.getDatabase();
                Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_SHORT).show();
            }
        });
        Button addData=(Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book=new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknow");
                book.save();
                Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_SHORT).show();
            }
        });
        Button updateData=(Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book=new Book();
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name = ? and author = ?","The Lost Symbol","Dan Brown");
                /*Book book=new Book(); 对以存储的数据进行修改
                book.setName("The Lost Symbol");
                book.setAuthor("Dan Brown");
                book.setPages(510);
                book.setPrice(19.95);
                book.setPress("Unknow");
                book.save();
                book.setPrice(10.99);
                book.save();*/
            }
        });
        Button deleteButton=(Button) findViewById(R.id.delete_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.deleteAll(Book.class,"price < ?","15");
            }
        });
        Button queryButton=(Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Book> books=LitePal.findAll(Book.class);
                for(Book book:books){
                    Log.e("MainActivity", "book name is "+ book.getName());
                    Log.e("MainActivity", "book author is "+ book.getAuthor());
                    Log.e("MainActivity", "book pages is "+ book.getPages());
                    Log.e("MainActivity", "book price is "+ book.getPrice());
                    Log.e("MainActivity", "book press is "+ book.getPress());
                }
            }
        });
    }
}