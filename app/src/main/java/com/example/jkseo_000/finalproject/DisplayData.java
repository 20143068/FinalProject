package com.example.jkseo_000.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayData extends AppCompatActivity {
    SQLiteDatabase db;
    String dbName = "DailyList.db";
    String tableName = "DailyListTable";
    int dbMode = Context.MODE_PRIVATE;

    ListView mList;
    ArrayAdapter<String> baseAdapter;
    ArrayList<String> DailyList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        DailyList = new ArrayList<String>();
        baseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, DailyList);
        mList.setAdapter(baseAdapter);
    }

    public void createTable() {
        try {
            String sql = "create table " + tableName + "(id integer primary key autoincrement, " + "date text, " + "time text, " + "event text)";
            db.execSQL(sql);
        } catch (android.database.sqlite.SQLiteException e) {
            Log.d("Lab sqlite", "error: " + e);
        }
    }
    public void selectData(int index) {
        String sql = "select * from " + tableName + " where id = " + index + ";";
        Cursor result = db.rawQuery(sql, null);

        // result(Cursor 객체)가 비어 있으면 false 리턴
        if (result.moveToFirst()) {
            int id = result.getInt(0);
            String name = result.getString(1);
        }
        result.close();
    }

}
