package com.example.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private ImageView fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fondo = (ImageView) findViewById(R.id.fondo);
    }

    public void encender (View v){
        fondo.setBackgroundColor(Color.rgb(255,255,255));
    }

    public void apagar (View v){
        fondo.setBackgroundColor(Color.rgb(0,0,0));

    }
}