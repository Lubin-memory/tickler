package com.example.tickler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class fruit extends AppCompatActivity implements View.OnClickListener{

Button button;
TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        button=(Button)findViewById(R.id.button_return_fruit);

        textView1=(TextView)findViewById(R.id.fruit1);
        textView2=(TextView)findViewById(R.id.fruit2);
        textView3=(TextView)findViewById(R.id.fruit3);
        textView4=(TextView)findViewById(R.id.fruit4);
        textView5=(TextView)findViewById(R.id.fruit5);



    }



    @Override
    public void onClick(View button) {
        Intent history = new Intent(this, heatCal.class);
        startActivity(history);
    }
}
