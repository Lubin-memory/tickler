package com.example.tickler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class milk extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk);
    }



    @Override
    public void onClick(View button) {
        Intent history = new Intent(this, heatCal.class);
        startActivity(history);

    }

}
