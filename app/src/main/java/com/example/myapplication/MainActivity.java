package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn;
    private Button mBtnFind;
    private TextView mTv;
    private SQLiteDatabase readableDatabase;
    private Button mDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        OpenHelp help = new OpenHelp(MainActivity.this);
        readableDatabase = help.getWritableDatabase();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtnFind = (Button) findViewById(R.id.btn_find);

        mBtn.setOnClickListener(this);
        mBtnFind.setOnClickListener(this);
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setOnClickListener(this);
        mDelete = (Button) findViewById(R.id.delete);
        mDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                readableDatabase.beginTransaction();
                ContentValues values = new ContentValues();
                values.put("name", 22);
                values.put("age", 33);
                readableDatabase.insert(OpenHelp.name, null, values);
                readableDatabase.setTransactionSuccessful();
                readableDatabase.endTransaction();
                break;
            case R.id.btn_find:
                Cursor query = readableDatabase.query("user", null, null, null, null, null
                        , null);
                StringBuffer buffer = new StringBuffer();
                buffer.append("查询到数据：");
                while (query.moveToNext()) {
                    int age = query.getColumnIndex("age");
                    int anInt = query.getInt(age);
                    int name = query.getColumnIndex("name");
                    int anInt1 = query.getInt(name);
                    buffer.append(anInt + "" + anInt1 + "\n");
                }
                mTv.setText(buffer.toString());

                break;
            case R.id.delete:
                readableDatabase.delete(OpenHelp.name,null,null);
                break;
        }
    }

    private synchronized void s() {

    }
}
