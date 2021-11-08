package com.example.notificaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtNum1;
    private EditText txtNum2;
    private EditText txtResp;
    private TextView lblSimbolo;
    private TextView lblNumCorrectas;

    int numCorrectas = 0;
    private int num1, num2;

    private final String[] SIMBOLOS = {"+", "-", "*", "/"};
    private int iSimbolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        txtResp = (EditText) findViewById(R.id.txtResp);

        lblSimbolo = (TextView) findViewById(R.id.lblSimbolo);
        lblNumCorrectas = (TextView) findViewById(R.id.lblNumCorrectas);


        generarOperacion();





    }

    public void comprobar (View view){
        switch (iSimbolo){
            case 0:
                if ((num1 + num2) == Integer.parseInt(txtResp.getText().toString())) {
                    numCorrectas++;
                    lblNumCorrectas.setText(numCorrectas + "");
                    generarOperacion();
                }else{
                    generarOperacion();
                }
            case 1:
                if ((num1 - num2) == Integer.parseInt(txtResp.getText().toString())) {
                    numCorrectas++;
                    lblNumCorrectas.setText(numCorrectas + "");
                    generarOperacion();
                }else{
                    generarOperacion();
                }
            case 2:
                if ((num1 * num2) == Integer.parseInt(txtResp.getText().toString())) {
                    numCorrectas++;
                    lblNumCorrectas.setText(numCorrectas + "");
                    generarOperacion();
                }else{
                    generarOperacion();
                }
            default:
                if ((num1 / num2) == Integer.parseInt(txtResp.getText().toString())) {
                    numCorrectas++;
                    lblNumCorrectas.setText(numCorrectas + "");
                    generarOperacion();
                }else{
                    generarOperacion();
                }
        }
    }

    private void generarOperacion(){
        txtResp.setText("");
        iSimbolo = (int)(Math.random()*4);

        lblSimbolo.setText( SIMBOLOS[iSimbolo]);

        num1= (int) (Math.random()*101);
        num2= (int) (Math.random()*101);

        while (iSimbolo == 3 && num2>num1) {
            num2= (int) (Math.random()*101);
        }
        txtNum1.setText(num1+"");
        txtNum2.setText(num2+"");

    }
}