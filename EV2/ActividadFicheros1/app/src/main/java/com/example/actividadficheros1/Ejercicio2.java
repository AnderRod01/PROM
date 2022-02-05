package com.example.actividadficheros1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejercicio2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        ArrayList <String> listaSpinner = new ArrayList<String>();
        Spinner sp = (Spinner) findViewById(R.id.spinnerEj2);

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.provincias)));

            String linea = br.readLine();
            while (linea != null){
                listaSpinner.add(linea);
                linea = br.readLine();
            }
            br.close();
        }
        catch (Exception ex){
            Log.e("Ficheros", "Error al leer fichero de recursos");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
    }
}