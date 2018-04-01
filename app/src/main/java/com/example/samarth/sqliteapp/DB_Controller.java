package com.example.samarth.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by samarth on 1/4/18.
 */

public class DB_Controller extends SQLiteOpenHelper {
    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TEST.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE EMPLOYEE(ID INTEGER PRIMARY KEY AUTOINCREMENT,EMPNAME TEXT UNIQUE,DEPTNAME TEXT);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS EMPLOYEE;");
        onCreate(sqLiteDatabase);

    }
    public void insertEmployee(String empname,String deptname)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("EMPNAME",empname);
        contentValues.put("DEPTNAME",deptname);
        this.getWritableDatabase().insertOrThrow("EMPLOYEE","",contentValues);
    }
    public void listRecord(TextView textView)
    {
        Cursor cursor=this.getReadableDatabase().rawQuery("SELECT * FROM EMPLOYEE",null);
        textView.setText("");
        while(cursor.moveToNext()){
            textView.append(cursor.getString(1)+" "+cursor.getString(2)+"\n");
        }
    }
}
