package com.example.actividadficheros1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText txtEscribir;
    private Button btnAniadirInt, btnAniadirExt, btnLeerInt,
            btnLeerExt, btnBorrarInt, btnBorrarExt, btnLeerRec;

    private TextView lblContenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAniadirInt = (Button) findViewById(R.id.btnAniadirInt);
        btnLeerInt = (Button) findViewById(R.id.btnLeerInt);
        btnBorrarInt = (Button) findViewById(R.id.btnBorrarInt);

        btnAniadirExt = (Button) findViewById(R.id.btnAniadirExt);
        btnLeerExt = (Button) findViewById(R.id.btnLeerExt);
        btnBorrarExt = (Button) findViewById(R.id.btnBorrarExt);

        btnLeerRec = (Button) findViewById(R.id.btnLeerRec);

        txtEscribir = (EditText) findViewById(R.id.txtContenido);
        lblContenido = (TextView) findViewById(R.id.lblContenido);



        btnAniadirInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    OutputStreamWriter osw=
                            new OutputStreamWriter(openFileOutput("prueba_int.txt",
                                    Context.MODE_APPEND));
                    osw.write(txtEscribir.getText() + "\n");
                    osw.close();
                }
                catch (Exception e) {
                    Log.e("Ficheros", "ERROR!! al escribir fichero en memoria interna");
                }
            }
        });

        btnLeerInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnBorrarInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnLeerRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        btnAniadirExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    File ruta_sd = getApplicationContext().getExternalFilesDir(null);

                    File f = new File (ruta_sd.getAbsolutePath(),"Ficheros1_SD.txt");
                    OutputStreamWriter osw =
                            new OutputStreamWriter(new FileOutputStream(f, true));

                    osw.write(txtEscribir.getText() + "\n");
                    osw.close();
                    Log.i ("Ficheros", "fichero escrito correctamente");
                }
                catch (Exception ex){
                    Log.e ("Ficheros", "Error al escribir fichero en tarjeta SD");
                }

            }
        });

        btnLeerExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File ruta_sd = getApplicationContext().getExternalFilesDir(null);

                    File f= new File(ruta_sd.getAbsolutePath(), "Ficheros1_SD.txt");
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(new FileInputStream(f)));
                    String linea= br.readLine();
                    String texto = "";
                    while (linea !=null){
                        texto = texto + linea + "\n";
                        Log.i("Ficheros", linea);
                        linea=br.readLine();
                    }
                    br.close();
                    lblContenido.setText(texto);
                }catch (Exception ex){
                    Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
                }
            }
        });

        btnBorrarExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}