package com.example.controlesbasicos2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

    private EditText txtNum1, txtNum2, resultado;
    private int num1, num2;
    private TextView lblNumCorrectas, lblNumIncorrectas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);


        txtNum1= (EditText) findViewById(R.id.txtNum1);
        txtNum2= (EditText) findViewById(R.id.txtNum2);
        resultado= (EditText) findViewById(R.id.txtResp);

        generarSuma();

    }

    private void generarSuma() {
        resultado.setText("");

        num1= (int) (Math.random()*101);
        num2= (int) (Math.random()*101);

        txtNum1.setText(num1+"");
        txtNum2.setText(num2+"");
    }


    public void comprobar (View v){
        Intent intent = new Intent( Actividad2.this, Actividad2_ResultadoOperacion.class);
        intent.putExtra("resultado", Integer.parseInt(resultado.getText().toString()));
        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);
        startActivityForResult(intent, 111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        lblNumCorrectas= (TextView) findViewById(R.id.lblNumCorrectas);
        lblNumIncorrectas=(TextView) findViewById(R.id.lblNumIncorrectas);

        if (requestCode == 111 && resultCode == RESULT_OK) {
            int aux=Integer.parseInt(lblNumCorrectas.getText().toString());
            aux++;
            lblNumCorrectas.setText(aux+"");
        }else{
            int aux=Integer.parseInt(lblNumIncorrectas.getText().toString());
            aux++;
            lblNumIncorrectas.setText(aux+"");
        }

        generarSuma();

    }
}