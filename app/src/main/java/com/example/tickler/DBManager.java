package com.example.tickler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private DBHelper dbHelper;
    private String TBNAME;

    public DBManager(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME;
    }

    public void add(Heat_History item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();//获得可写数据对象
        ContentValues values = new ContentValues();//相当于map，bundle
        values.put("curtime", item.getCurTime());
        values.put("curheat", item.getCurHeat());
        db.insert(TBNAME, null, values);//insert为新增记录
        db.close();
    }

    public void addAll(List<Heat_History> list){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        for (Heat_History item : list) {
            ContentValues values = new ContentValues();
            values.put("curtime", item.getCurTime());
            values.put("curheat", item.getCurHeat());
            db.insert(TBNAME, null, values);
        }
        db.close();
    }

    public void deleteAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME, "ID=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void update(Heat_History item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("curtime", item.getCurTime());
        values.put("curheat", item.getCurHeat());
        db.update(TBNAME, values, "ID=?", new String[]{String.valueOf(item.getId())});
        db.close();
    }

    public List<Heat_History> listAll(){
        List<Heat_History> historyList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        if(cursor!=null){
            historyList = new ArrayList<Heat_History>();
            while(cursor.moveToNext()){
                Heat_History item = new Heat_History();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setCurTime(cursor.getString(cursor.getColumnIndex("CURTIME")));
                item.setCurHeat(cursor.getFloat(cursor.getColumnIndex("CURHEAT")));

                historyList.add(item);
            }
            cursor.close();
        }
        db.close();
        return historyList;

    }

//    public RateItem findById(int id){
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.query(TBNAME, null, "ID=?", new String[]{String.valueOf(id)}, null, null, null);
//        RateItem rateItem = null;
//        if(cursor!=null && cursor.moveToFirst()){
//            rateItem = new RateItem();
//            rateItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
//            rateItem.setCurName(cursor.getString(cursor.getColumnIndex("CURNAME")));
//            rateItem.setCurRate(cursor.getString(cursor.getColumnIndex("CURRATE")));
//            cursor.close();
//        }
//        db.close();
//        return rateItem;
//    }
}
