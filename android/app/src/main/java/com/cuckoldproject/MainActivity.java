package com.cuckoldproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final HtmlStuff hs = new HtmlStuff();

        layout = findViewById(R.id.layout);
        //setting up the textivew
        tv = findViewById(R.id.tv);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    hs.sendGET();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv.setText(hs.getResponse());
            }
        });
    }

}
