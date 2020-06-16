package com.example.tickler;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class heatCal extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener{

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;

    EditText   editText1;
    EditText   editText2;
    EditText   editText3;
    EditText   editText4;

     String TAG="heatCal";
    Button button1;
    Button  button2;
    TextView textView;

    float temp1;//主食类食物的热量
    float temp2;//蔬菜类食物的热量
    float temp3;//水果类食物的热量
    float temp4;//奶制品类食物的热量

    String str1;
    String str2;
    String str3;
    String str4;

    float cal=0;

    //定义Spinner
    private TextView tv1;
    //定义TextView
    private ArrayAdapter<String > simp_adapter1;
    private ArrayAdapter<String > simp_adapter2;
    private ArrayAdapter<String > simp_adapter3;
    private ArrayAdapter<String > simp_adapter4;
    private ArrayAdapter<String > simp_adapter5;

    //定义适配器
    private List<Map<String,Object>> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heat_cal);
        //实例化Spinner，TextView

        spinner1= (Spinner)findViewById(R.id.spinner1);
        spinner2=(Spinner) findViewById(R.id.spinner2);
        spinner3= (Spinner)findViewById(R.id.spinner3);
        spinner4= (Spinner)findViewById(R.id.spinner4);
        spinner5= (Spinner)findViewById(R.id.spinner5);


        editText1=(EditText) findViewById(R.id.editText1);
        editText2=(EditText) findViewById(R.id.editText2);
        editText3=(EditText) findViewById(R.id.editText3);
        editText4=(EditText) findViewById(R.id.editText4);




        button1=(Button) findViewById(R.id.button1);//匿名内部类
        button1.setOnClickListener(this);

        button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        textView=(TextView) findViewById(R.id.tv1);
        Resources res =getResources();
       // String [] arr1={"玉米","包子","米饭","面包","面条"};
        String[] arr1=res.getStringArray(R.array.spinner1);
//        String [] arr2= {"胡萝卜","白菜","黄瓜","南瓜","竹笋","土豆"};
//        String [] arr3= {"苹果","草莓","香蕉","橙子","火龙果"};
//        String [] arr4={"牛奶","酸奶","全脂奶粉"};
        String[] arr2=res.getStringArray(R.array.spinner2);
        String[] arr3=res.getStringArray(R.array.spinner3);
        String[] arr4=res.getStringArray(R.array.spinner4);
        String[] arr5=res.getStringArray(R.array.spinner5);

        //添加ArrayAdapter适配器,参数二调用系统预设布局文件
        simp_adapter1 = new ArrayAdapter<String >(
                this,R.layout.activity_item,arr1);
        simp_adapter2= new ArrayAdapter<String >(
                this,R.layout.activity_item,arr2);
        simp_adapter3 = new ArrayAdapter<String >(
                this,R.layout.activity_item,arr3);
        simp_adapter4= new ArrayAdapter<String >(
                this,R.layout.activity_item,arr4);
        simp_adapter5= new ArrayAdapter<String >(
                this,R.layout.activity_spinner5_item,arr5);

//设置下拉列表的样式
//       simp_adapter1.setDropDownViewResource(R.layout.activity_item);
//        simp_adapter2.setDropDownViewResource(R.layout.activity_item);
//       simp_adapter3.setDropDownViewResource(R.layout.activity_item);
//       simp_adapter4.setDropDownViewResource(R.layout.activity_item);
//        simp_adapter5.setDropDownViewResource(R.layout.activity_spinner5_item);


        //Spinner加载适配器
        spinner1.setAdapter(simp_adapter1);
        spinner2.setAdapter(simp_adapter2);
        spinner3.setAdapter(simp_adapter3);
        spinner4.setAdapter(simp_adapter4);
        spinner5.setAdapter(simp_adapter5);

        //Spinner加载监听事件
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //通过此方法为下拉列表设置点击事件
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String content= spinner1.getItemAtPosition(i).toString();
              if (content.equals("玉米")){
                  temp1=1.12f;
             }else if(content.equals("包子")){
                   temp1=2.27f;
               }else if(content.equals("米饭")){
                   temp1=1.16f;
               }else if(content.equals("面包")){
                   temp1=3.13f;
                }else{
                   temp1=3.01f;
               }
                Log.i(TAG,"temp1="+temp1);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //通过此方法为下拉列表设置点击事件
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String content= spinner2.getItemAtPosition(i).toString();
            if (content.equals("胡萝卜")){
                   temp2=0.32f;
                }else if(content.equals("白菜")){
                   temp2=0.20f;
                }else if(content.equals("黄瓜")){
                   temp2=0.16f;
               }else if(content.equals("南瓜")){
                   temp2=0.23f;
               }else if(content.equals("竹笋")){
                   temp2=0.23f;
               }else{
                   temp2=0.81f;
               }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //通过此方法为下拉列表设置点击事件
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String content= spinner3.getItemAtPosition(i).toString();
                if (content.equals("苹果")){
                   temp3=0.53f;
                }else if(content.equals("草莓")){
                   temp3=0.32f;
              }else if(content.equals("香蕉")){
                    temp3=0.93f;
               }else if(content.equals("橙子")){
                    temp3=0.48f;
                }else{
                   temp3=0.55f;
               }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //通过此方法为下拉列表设置点击事件
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String content= spinner4.getItemAtPosition(i).toString();
                if (content.equals("牛奶")){
                    temp4=0.54f;
               }else if(content.equals("酸奶")){
                    temp4=0.72f;
                }else {
                    temp4=4.78f;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //通过此方法为下拉列表设置点击事件
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String content= spinner5.getItemAtPosition(i).toString();
                if (content.equals("历史记录")){
                    openConfig1();
                }else if(content.equals("热量详情")){
                    openConfig2();

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }        });
        }

    @Override
    public void onClick(View button) {


//获取用户输入
        if(button.getId()==R.id.button1) {

          String str1=editText1.getText().toString();
            String str2=editText2.getText().toString();
            String str3=editText3.getText().toString();
            String str4=editText4.getText().toString();


            float r1 = 0;
            float r2 = 0;
            float r3 = 0;
            float r4 = 0;
            Log.i(TAG,"str1="+str1);
            Log.i(TAG,"str2="+str2);
            Log.i(TAG,"str3="+str3);
            Log.i(TAG,"str4="+str4);


            if (str1.length() > 0 || str2.length() > 0 || str3.length() > 0 || str4.length() > 0) {
                r1 = Float.parseFloat(str1);
                r2 = Float.parseFloat(str2);
                r3 = Float.parseFloat(str3);
                r4 = Float.parseFloat(str4);
                cal=r1*temp1+r2*temp2+r3*temp3+r4*temp4;


                String calString = "您今日食用的热量为："+String.valueOf(cal)+"千卡";


                textView.setText(calString);

            } else {//给用户提示信息
                Toast.makeText(this, "请输入完整的信息", Toast.LENGTH_SHORT).show();//消息提示  LENGTH_SHORT显示时间短，


            }

        } else if(button.getId()==R.id.button2){

            //获得当前系统时间
            final Date today= Calendar.getInstance().getTime();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            final String todayStr = sdf.format(today);

            BigDecimal b  =   new BigDecimal(cal);

            float   f1   =  b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            Heat_History heat_history=new Heat_History(todayStr,f1);
            DBManager dbManager = new DBManager(heatCal.this);
            dbManager.add(heat_history);
            Toast.makeText(getApplicationContext(),"保存成功",Toast.LENGTH_LONG).show();



        }
    }





    private void openConfig1() {   //打开历史记录界面
    Intent history = new Intent(this, history.class);
//
       startActivity(history);//requestCode

    }
    private void openConfig2() {   //打开热量属性界面
        Intent history = new Intent(this, Index.class);

        startActivity(history);//requestCode
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    //点击菜单的事件处理
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_history){
            //点击后的事件处理，可填入打开历史记录页面的代码
            openConfig1();

        }else{
            openConfig2();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

