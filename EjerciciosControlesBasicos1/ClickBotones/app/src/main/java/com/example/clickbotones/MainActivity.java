package com.example.clickbotones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView logo;

    private Button btnBing, btnGoogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (ImageView) findViewById(R.id.logo);
        btnGoogle = (Button) findViewById(R.id.google);
        btnBing = (Button) findViewById(R.id.bing);

        btnBing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logo.setImageResource(R.drawable.logobing);
            }
        });

        btnGoogle.setOnClickListener(this);

    }



    public void clYahoo(View v){
        logo.setImageResource(R.drawable.logoyahoo);
    }

    @Override
    public void onClick(View view) {
        logo.setImageResource(R.drawable.logogoogle);
    }
}