package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        Button volver = (Button) findViewById(R.id.btnVolver);
        Button verificar = (Button) findViewById(R.id.btnVerificar);
        EditText nombre = (EditText) findViewById(R.id.txtNombre);
        EditText apellidos = (EditText) findViewById(R.id.txtApellido);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Actividad1.this, MainActivity.class);
                startActivity(intent);
            }
        });

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String auxNombre = nombre.getText().toString();
                String auxApellido = apellidos.getText().toString();

                Intent intent = new Intent(Actividad1.this, Actividad1_Verificar.class);
                intent.putExtra("auxNombre", auxNombre);
                intent.putExtra("auxApellidos", auxApellido);
                startActivityForResult(intent,12);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView lblFrase= (TextView) findViewById(R.id.lblFrase);
        if (requestCode == 12 && resultCode == RESULT_OK)
            lblFrase.setText("Aceptas condiciones: ACEPTADO");
        else
            lblFrase.setText("Aceptas condiciones: RECHAZADO");
    }
}