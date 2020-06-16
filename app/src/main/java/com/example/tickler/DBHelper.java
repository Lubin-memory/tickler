package com.example.tickler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "myheat.db";
    public static final String TB_NAME = "tb_heats";


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {
                    //name为传过来的数据库名，context控制生命周期

        super(context, name, factory, version);
    }
    public DBHelper(Context context) {
        super(context,DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TB_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,CURTIME TEXT,CURHEAT FLOAT)");
    }// AUTOINCREMENT为自动增长，

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {//数据库的升级
        // TODO Auto-generated method stub

    }


}
