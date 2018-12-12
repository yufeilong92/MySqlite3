package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private DBHelper mHelper;
    private SQLiteDatabase mDatabase;
    private Button mInsertBtn;
    private Button mDeleteBtn;
    private Button mUpdateBtn;
    private Button mQueryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

        mHelper = new DBHelper(this);
        mDatabase = mHelper.getWritableDatabase();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.insert_btn) {
            insertData();
        } else if (view.getId() == R.id.delete_btn) {
            deleteData();
        } else if (view.getId() == R.id.update_btn) {
            updateData();
        } else if (view.getId() == R.id.query_btn) {
            queryData();
        }
    }

    // 表名
    // null。数据库如果插入的数据为null，会引起数据库不稳定。为了防止崩溃，需要传入第二个参数要求的对象
    // 如果插入的数据不为null，没有必要传入第二个参数避免崩溃，所以为null
    // 插入的数据
    private void insertData() {
        ContentValues values = new ContentValues();
        values.put(DBHelper.NAME, "鹿晗");
        values.put(DBHelper.AGE, 17);
        mDatabase.insert(DBHelper.TABLE_NAME, null, values);
        Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
    }

    // 表名
    // 删除条件
    // 满足删除的值
    private void deleteData() {
        int count = mDatabase.delete(DBHelper.TABLE_NAME, DBHelper.NAME + " = ?", new String[]{"鹿晗"});
        Toast.makeText(this, "删除数量：" + count, Toast.LENGTH_SHORT).show();
    }

    // 表名
    // 修改后的数据
    // 修改条件
    // 满足修改的值
    private void updateData() {
        ContentValues values = new ContentValues();
        values.put(DBHelper.NAME, "小茗同学");
        values.put(DBHelper.AGE, 18);
        int count = mDatabase
                .update(DBHelper.TABLE_NAME, values, DBHelper.NAME + " = ?", new String[]{"鹿晗"});
        Toast.makeText(this, "修改成功：" + count, Toast.LENGTH_SHORT).show();
    }

    // 表名
    // 查询字段
    // 查询条件
    // 满足查询的值
    // 分组
    // 分组筛选关键字
    // 排序
    private void queryData() {
        Cursor query = mDatabase.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);
        while (query.moveToNext()){
            int index = query.getColumnIndex(DBHelper.NAME);
            String string = query.getString(index);
            Log.e("==================", "queryData: "+string );
        }
     /*   Cursor cursor = mDatabase.query(DBHelper.TABLE_NAME,
                new String[]{DBHelper.NAME, DBHelper.AGE},
                DBHelper.AGE + " > ?",
                new String[]{"16"},
                null,
                null,
                DBHelper.AGE + " desc");// 注意空格！

        int nameIndex = cursor.getColumnIndex(DBHelper.NAME);
        int ageIndex = cursor.getColumnIndex(DBHelper.AGE);
        while (cursor.moveToNext()) {
            String name = cursor.getString(nameIndex);
            String age = cursor.getString(ageIndex);

            Log.d("1507", "name: " + name + ", age: " + age);
        }*/

    }

    private void initView() {
        mInsertBtn = (Button) findViewById(R.id.insert_btn);
        mDeleteBtn = (Button) findViewById(R.id.delete_btn);
        mUpdateBtn = (Button) findViewById(R.id.update_btn);
        mQueryBtn = (Button) findViewById(R.id.query_btn);

        mInsertBtn.setOnClickListener(this);
        mDeleteBtn.setOnClickListener(this);
        mUpdateBtn.setOnClickListener(this);
        mQueryBtn.setOnClickListener(this);
    }
}
