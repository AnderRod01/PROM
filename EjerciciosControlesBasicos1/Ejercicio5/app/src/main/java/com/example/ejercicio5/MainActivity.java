package com.example.ejercicio5;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch switchCamara, switchLuz;
    private ToggleButton toggleCamara, toggleLuz;
    private ImageView cam1, cam2, luz1, luz2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        switchCamara = (Switch) findViewById(R.id.switchCamara);
        switchLuz = (Switch) findViewById(R.id.switchLuz);
        cam1 = (ImageView) findViewById(R.id.imgCamara1);
        cam2 = (ImageView) findViewById(R.id.imgCamara2);
        luz1 = (ImageView) findViewById(R.id.imgBombilla1);
        luz2 = (ImageView) findViewById(R.id.imgBombilla2);
        toggleCamara= (ToggleButton) findViewById(R.id.toggleCamara);
        toggleLuz = (ToggleButton) findViewById(R.id.toggleLuz);

        switchCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCamara.isChecked())
                    cam1.setVisibility(View.VISIBLE);
                else
                    cam1.setVisibility(View.INVISIBLE);
            }
        });

        toggleCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleCamara.isChecked()) {
                    cam2.setVisibility(View.VISIBLE);
                }
                else
                    cam2.setVisibility(View.INVISIBLE);
            }
        });

        switchLuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchLuz.isChecked())
                    luz1.setImageResource(R.drawable.bombillaencendida);
                else
                    luz1.setImageResource(R.drawable.bombillaapagada);
            }
        });

        toggleLuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleLuz.isChecked())
                    luz2.setImageResource(R.drawable.bombillaencendida);
                else
                    luz2.setImageResource(R.drawable.bombillaapagada);
            }
        });

    }
}