package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad1_Verificar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acividad1_verificar);

        TextView frase = (TextView) findViewById(R.id.lblVerif);
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("auxNombre");
        String apellidos = datos.getString("auxApellidos");
        Button btnAceptar = (Button) findViewById(R.id.btnAceptar);
        Button btnRechazar = (Button) findViewById(R.id.btnRechazar);

        frase.setText("Hola " + nombre.toUpperCase() + " " + apellidos.toUpperCase() + " ¿Aceptas las condiciones?");


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnRechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }
}