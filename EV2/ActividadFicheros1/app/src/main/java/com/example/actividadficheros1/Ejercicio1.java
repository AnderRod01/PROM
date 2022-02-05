package com.example.actividadficheros1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ejercicio1 extends AppCompatActivity {

    private EditText txtEscribir;
    private Button btnAniadirInt, btnAniadirExt, btnLeerInt,
            btnLeerExt, btnBorrarInt, btnBorrarExt, btnLeerRec;

    private TextView lblContenido;

    private boolean sdDisponible, sdAccesoEscritura;

    private static final int SOLICITUD_PERMISO_WRITE_EXTERNAL = 0;
    private static final int SOLICITUD_PERMISO_READ_EXTERNAL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

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
                try {
                    OutputStreamWriter osw =
                            new OutputStreamWriter(openFileOutput("prueba_int.txt",
                                    Context.MODE_APPEND));
                    osw.write(txtEscribir.getText() + "\n");
                    osw.close();
                } catch (Exception e) {
                    Log.e("Ficheros", "ERROR!! al escribir fichero en memoria interna");
                }
            }
        });

        btnLeerInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BufferedReader br =
                            new BufferedReader(
                                    new InputStreamReader(
                                            openFileInput("prueba_int.txt")));

                    String linea = br.readLine();
                    String texto = "";
                    while (linea != null) {
                        texto = texto + linea + "\t";
                        linea = br.readLine();
                    }
                    br.close();

                    lblContenido.setText(texto);

                } catch (Exception ex) {
                    Log.e("Ficheros", "Error al leer fichero desde memoria interna");
                }
            }
        });

        btnBorrarInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFile("prueba_int.txt");
            }
        });

        btnLeerRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.prueba_raw)));

                    String linea = br.readLine();
                    String texto = "";
                    while (linea != null) {
                        texto = texto + linea + "\t";
                        linea = br.readLine();
                    }
                    br.close();
                    lblContenido.setText(texto);
                } catch (Exception ex) {
                    Log.e("Ficheros", "Error al leer fichero de recursos");
                }
            }
        });


        btnAniadirExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Ejercicio1.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    try {
                        File ruta_sd = getApplicationContext().getExternalFilesDir(null);

                        File f = new File(ruta_sd.getAbsolutePath(), "Ficheros1_SD.txt");
                        OutputStreamWriter osw =
                                new OutputStreamWriter(new FileOutputStream(f, true));

                        osw.write(txtEscribir.getText() + "\n");
                        osw.close();
                        Log.i("Ficheros", "fichero escrito correctamente");
                    } catch (Exception ex) {
                        Log.e("Ficheros", "Error al escribir fichero en tarjeta SD");
                    }
                } else {
                    solicitarPermiso(Manifest.permission.WRITE_EXTERNAL_STORAGE, "Se necesitan permisos para acceder a la memoria externa", SOLICITUD_PERMISO_WRITE_EXTERNAL, Ejercicio1.this);
                }
            }
        });

        btnLeerExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Ejercicio1.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    try {
                        File ruta_sd = getApplicationContext().getExternalFilesDir(null);

                        File f = new File(ruta_sd.getAbsolutePath(), "Ficheros1_SD.txt");
                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(new FileInputStream(f)));
                        String linea = br.readLine();
                        String texto = "";
                        while (linea != null) {
                            texto = texto + linea + "\t";
                            Log.i("Ficheros", linea);
                            linea = br.readLine();
                        }
                        br.close();
                        lblContenido.setText(texto);
                    } catch (Exception ex) {
                        Log.e("Ficheros", "ERROR!! en la lectura del fichero en SD");
                    }
                } else {
                    solicitarPermiso(Manifest.permission.READ_EXTERNAL_STORAGE, "Se necesitan permisos para acceder a la memoria externa", SOLICITUD_PERMISO_READ_EXTERNAL, Ejercicio1.this);
                }
            }
        });

        btnBorrarExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContextWrapper cw = new ContextWrapper(getApplicationContext());
                File ruta_sd = cw.getExternalFilesDir(null);
                File f = new File(ruta_sd.getAbsolutePath(), "Ficheros1_SD.txt");

                if (f.exists())
                    if (f.delete()) {
                        Toast.makeText(Ejercicio1.this, "Fichero externo borrado", Toast.LENGTH_LONG).show();
                    }
            }
        });

    }

    public static void solicitarPermiso(final String permiso, String justificacion, final int requestCode, final Activity actividad) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                actividad, permiso)) {
            //Informamos al usuario para qué y por qué
            //se necesitan los permisos
            new AlertDialog.Builder(actividad)
                    .setTitle("Solicitud de permiso")
                    .setMessage(justificacion)
                    .setPositiveButton("OK",
                            (dialog, which) -> ActivityCompat.requestPermissions(actividad,
                                    new String[]{permiso}, requestCode)).show();
        } else {
            //Muestra el cuadro de dialogo para la solicitud de permisos y
            //registra el permiso según respuesta del usuario
            ActivityCompat.requestPermissions(actividad,
                    new String[]{permiso}, requestCode);
        }
    }

    private void comprobarSD() {
        String estado = Environment.getExternalStorageState();

        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoEscritura = true;
        } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponible = true;
            sdAccesoEscritura = false;
        } else {
            sdDisponible = false;
            sdAccesoEscritura = false;
        }

    }


}