package com.example.tickler;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class history extends AppCompatActivity implements View.OnClickListener ,AdapterView.OnItemLongClickListener {
    Button button;
    ListView listView;
    String TAG = "history";

    private ListAdapter listItemAdapter;
    private ListAdapter listItemAdapter2;
    private List<HashMap<String, String>> noteList;
    private List<HashMap<String, String>> noteList2;
    SQLiteDatabase db;
    DBHelper DB;
    Heat_History history;
    DBManager manager = new DBManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        initListView();
        button = (Button) findViewById(R.id.btn_history_return);
        button.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.lv);
        listItemAdapter = new SimpleAdapter(history.this, noteList, R.layout.activity_list_item,
                new String[]{"Time", "Context"},
                new int[]{R.id.t1, R.id.t2})
        ;
        listItemAdapter2 = new SimpleAdapter(history.this, noteList, R.layout.activity_list_item,
                new String[]{"Time", "Context"},
                new int[]{R.id.t1, R.id.t2})
        ;


        listView.setAdapter(listItemAdapter);
        listView.setOnItemLongClickListener(this);

        DB = new DBHelper(this);
        db = DB.getReadableDatabase();


    }


    @Override
    public void onClick(View button) {
        if (button.getId() == R.id.btn_history_return) {
            Intent history = new Intent(this, heatCal.class);
            startActivity(history);
        } else {
            RefreshNotesList();

            Toast.makeText(this, "记录已全部清空", Toast.LENGTH_SHORT).show();
        }


    }


    private void initListView() {
        noteList = new ArrayList<HashMap<String, String>>();


        for (Heat_History item : manager.listAll()) {
//            String  time=item.getCurTime();
//            Float heat=item.getCurHeat();
//            Log.i(TAG,"数据第一条为：" +time);
//            Log.i(TAG,"数据第一条为：" +heat);
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("Time", item.getCurTime()); // 记录的时间
            map.put("Context", "当日食用热量为： "+item.getCurHeat().toString()+"千卡"); // 记录的热量
            noteList.add(map);
        }
    }


//用法与inintList相似
//            private List<Map<String, Object>> getData() {
//
//                Cursor cursor = dbread.query("note", null, "content!=\"\"", null, null,
//                        null, null);
//
//                while (cursor.moveToNext()) {
//                    String name = cursor.getString(cursor.getColumnIndex("content"));
//                    String date = cursor.getString(cursor.getColumnIndex("date"));
//                    Map<String, Object> map = new HashMap<String, Object>();
//                    map.put("tv_content", name);
//                    map.put("tv_date", date);
//                    dataList.add(map);
//                }
//                cursor.close();
//                return dataList;
//
//            }


    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
        final int n = arg2;
        Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("删除记录");
        builder.setMessage("确认删除吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String content = listView.getItemAtPosition(n) + "";
                String content1 = content.substring(content.indexOf("=") + 1,
                        content.indexOf(","));
                Cursor c = db.query("Time", null, "Context" + "'"
                        + content1 + "'", null, null, null, null);
                while (c.moveToNext()) {
                    String id = c.getString(c.getColumnIndex("_id"));
                    String sql_del = "update note set content='' where _id="
                            + id;
                    db.execSQL(sql_del);
                    RefreshNotesList();
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create();
        builder.show();
        return true;
    }

    public void RefreshNotesList() {

        int size = noteList.size();
        if (size > 0) {
            noteList2 = new ArrayList<HashMap<String, String>>();

            listItemAdapter2.notifyAll();
            listView.setAdapter(listItemAdapter2);
        }
    }
}
