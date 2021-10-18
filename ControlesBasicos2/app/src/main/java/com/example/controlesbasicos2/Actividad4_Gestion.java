package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad4_Gestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad4_gestion);

        Bundle bundle = getIntent().getExtras();
        boolean gestion = bundle.getBoolean("gestion");
        int dinero = bundle.getInt("dinero");


        EditText txtDinero = (EditText) findViewById(R.id.txtDinero);
        TextView lblGestion = (TextView) findViewById(R.id.lblGestion);

        if (gestion){
            lblGestion.setText("Introduzca cantidad a INGRESAR");
        }else{
            lblGestion.setText("Introduzca cantidad a RETIRAR");
        }

        Button btnAceptar = (Button) findViewById(R.id.btnAceptar_act4);
        Button btnCancelar = (Button) findViewById(R.id.btnCancelar_act4);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int dineroNuevo;


               if (gestion) {
                   dineroNuevo = Integer.parseInt(txtDinero.getText().toString()) + dinero;
               }else {
                   if (dinero < Integer.parseInt(txtDinero.getText().toString())) {
                       Intent intent = new Intent();
                       setResult(RESULT_CANCELED, intent);
                       finish();
                   }
                   dineroNuevo = dinero - Integer.parseInt(txtDinero.getText().toString());
               }


               Intent intent = new Intent();
               intent.putExtra("dineroNuevo", dineroNuevo);
               setResult(RESULT_OK, intent);
               finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();

            }
        });



    }
}