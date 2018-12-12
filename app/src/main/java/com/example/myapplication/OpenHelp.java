package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication2
 * @Package com.example.myapplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018.12.12 上午 10:27
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class OpenHelp extends SQLiteOpenHelper {
    public static final String name="user";

    public OpenHelp(Context context) {
        super(context, "myclass.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " +name+
                "(id integer primary key autoincrement," +
                "name varchar," +
                "age varchar)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
