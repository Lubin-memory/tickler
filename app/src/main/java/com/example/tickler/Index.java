package com.example.tickler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Index extends AppCompatActivity implements View.OnClickListener {
Button button1;
Button button2;
Button button3;
Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        button1 = (Button) findViewById(R.id.staple);
        button1.setOnClickListener((View.OnClickListener) this);

        button2 = (Button) findViewById(R.id.fruit);
        button2.setOnClickListener((View.OnClickListener) this);

        button3 = (Button) findViewById(R.id.vegetable);
        button3.setOnClickListener((View.OnClickListener) this);

        button4 = (Button) findViewById(R.id.milk);
        button4.setOnClickListener((View.OnClickListener) this);
    }


    @Override
    public void onClick(View button) {
        if (button.getId()== R.id.staple) {
            Intent history = new Intent(this, staple.class);
            startActivity(history);
        } else if (button.getId() == R.id.fruit) {
            Intent history = new Intent(this, fruit.class);
            startActivity(history);
        }else if (button.getId() == R.id.vegetable) {
            Intent history = new Intent(this, vgetable.class);
            startActivity(history);
        }else if (button.getId() == R.id.milk) {
            Intent history = new Intent(this, milk.class);
            startActivity(history);
        }else{
            Intent history = new Intent(this, heatCal.class);
            startActivity(history);
        }
    }
}
