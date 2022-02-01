package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad2_ResultadoOperacion extends AppCompatActivity {

    private TextView lblResultado;
    private boolean correcto;
    private Button btnVolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2_resultado_operacion);

        Bundle datos =  getIntent().getExtras();
        int num1 = datos.getInt("num1");
        int num2 = datos.getInt("num2");
        int resp = datos.getInt("resultado");

        lblResultado= (TextView) findViewById(R.id.lblResultado);
        btnVolver = (Button) findViewById(R.id.btnVolver);

        if ((num1 + num2)==resp){
            lblResultado.setText("El resultado de la operacion es CORRECTA");
            correcto = true;
        } else {
            lblResultado.setText("El resultado de la operacion es INCORRECTA");
            correcto = false;
        }

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (correcto){
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    finish();
                }else{
                    Intent intent = new Intent();
                    setResult(RESULT_CANCELED, intent);
                    finish();
                }

            }
        });

    }







}