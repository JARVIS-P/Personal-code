package com.example.contactstest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyProvider extends ContentProvider {
    public static final int TABlE1_DIR=0;
    public static final int TABlE1_ITEM=1;
    public static final int TABlE2_DIR=2;
    public static final int TABlE2_ITEM=3;
    private static UriMatcher uriMatcher;

    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.app.provider","table1",TABlE1_DIR);
        uriMatcher.addURI("com.example.app.provider","table1/#",TABlE1_ITEM);
        uriMatcher.addURI("com.example.app.provider","table2",TABlE2_DIR);
        uriMatcher.addURI("com.example.app.provider","table1/#",TABlE2_ITEM);
    }
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        switch (uriMatcher.match(uri)){
            case TABlE1_DIR:
                //查询table1表中的所有数据
                break;
            case TABlE1_ITEM:
                //查询table1表中的单条数据
                break;
            case TABlE2_DIR:
                //查询table2表中的所有数据
                break;
            case TABlE2_ITEM:
                //查询table2中的单条数据
                break;
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)){
            case TABlE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.app.provider.table1";
            case TABlE1_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.app.provider.table1";
            case TABlE2_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.app.provider.table2";
            case TABlE2_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.app.provider.table1";
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
