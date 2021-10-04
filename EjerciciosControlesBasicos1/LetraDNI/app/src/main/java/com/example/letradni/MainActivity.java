package com.example.letradni;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numDni, letra;
    private TextView resp;
    private Button validar;
    private static String dniAComprobar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void comprobar (View v){
        validar = (Button) findViewById(R.id.validar);
        numDni = (EditText) findViewById(R.id.dni);
        letra = (EditText) findViewById(R.id.letra);
        resp = (TextView) findViewById(R.id.respuesta);

        dniAComprobar = numDni.getText() + "" + letra.getText();

        boolean valido = esValido();

        if (valido){
            resp.setText("DNI VALIDO");
            resp.setTextColor(Color.GREEN);
        }else{
            resp.setText("DNI NO VALIDO");
            resp.setTextColor(Color.RED);
        }
    }

    private static boolean esValido(){
        char[] letraDni = {
                'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
        };


        String num= "";
        int ind = 0;
        boolean valido;

        if(dniAComprobar.length() == 8) {
            dniAComprobar = "0" + dniAComprobar;
        }

        if (!Character.isLetter(dniAComprobar.charAt(8))) {
            return false;
        }
        if (dniAComprobar.length() != 9){
            return false;
        }
        for (int i=0; i<8; i++) {

            if (!Character.isDigit(dniAComprobar.charAt(i))) {
                return false;
            }

            num += dniAComprobar.charAt(i);
        }

        ind = Integer.parseInt(num);


        ind %= 23;


        if ((Character.toUpperCase(dniAComprobar.charAt(8))) != letraDni[ind]){
            return false;
        }

        return true;

    }

}