package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad3_Datos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3_datos);

        Bundle bundle = getIntent().getExtras();
        String datos = bundle.getString("datos");

        ((TextView)findViewById(R.id.lblDatos)).setText(datos);
    }

    public void volver (View v){
        Intent intent = new Intent(Actividad3_Datos.this, MainActivity.class);
        startActivity(intent);
    }
}