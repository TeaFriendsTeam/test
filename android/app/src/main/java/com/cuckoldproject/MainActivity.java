package com.cuckoldproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        layout = findViewById(R.id.layout);
        //setting up the textivew
        tv = findViewById(R.id.tv);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(returnRandomNumber());
            }
        });
    }
    public String returnRandomNumber(){
        Random rand = new Random();
        String x = Integer.toString(rand.nextInt(100));
        return x;
    }
}
