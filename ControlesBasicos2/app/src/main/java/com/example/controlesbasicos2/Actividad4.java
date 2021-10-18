package com.example.controlesbasicos2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad4 extends AppCompatActivity {

    private TextView lblCantidad, lblMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad4);

        Button btnIngresar = (Button) findViewById(R.id.btnIngresar);
        Button btnRetirar = (Button) findViewById(R.id.btnRetirar);
        Button btnVolver = (Button) findViewById(R.id.btnVolver_act4);
        lblCantidad = (TextView) findViewById(R.id.lblCantidad);
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Actividad4.this, Actividad4_Gestion.class);
                intent.putExtra("gestion", true);
                intent.putExtra("dinero", Integer.parseInt(lblCantidad.getText().toString()));
                startActivityForResult(intent, 1);
            }
        });

        btnRetirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Actividad4.this, Actividad4_Gestion.class);
                intent.putExtra("gestion", false);
                intent.putExtra("dinero", Integer.parseInt(lblCantidad.getText().toString()));
                startActivityForResult(intent, 1);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Actividad4.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK && requestCode==1) {
            lblCantidad.setText(data.getExtras().getInt("dineroNuevo") + "");
            lblMensaje.setText("Operación realizada con éxito");

        }else{
            lblMensaje.setText("La operación no se realizó con éxito");
        }



    }
}