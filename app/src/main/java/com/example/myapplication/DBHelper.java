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
 * @date: 2018.12.12 下午 12:38
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class DBHelper extends SQLiteOpenHelper { // 数据库文件名
    public static final String DB_NAME = "my_database.db";
    // 数据库表名
    public static final String TABLE_NAME = "t_person";
    // 数据库版本号
    public static final int DB_VERSION = 1;

    public static final String NAME = "name";
    public static final String AGE = "age";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // 当数据库文件创建时，执行初始化操作，并且只执行一次
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 建表
        String sql = "create table " +
                TABLE_NAME +
                "(_id integer primary key autoincrement, " +
                NAME + " varchar, " +
                AGE + " varchar"
                + ")";

        db.execSQL(sql);
    }

    // 当数据库版本更新执行该方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
