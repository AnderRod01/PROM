package com.example.notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
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

    private NotificationManager notificationManager;
    static final String CANAL_ID ="mi_canal";
    static final int NOTIFICACION_ID =1;

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
        if (txtResp.getText().toString().equals("")){
            generarOperacion();
        }
        else{
            switch (iSimbolo){
                case 0:
                    if ((num1 + num2) == Integer.parseInt(txtResp.getText().toString())) {
                        numCorrectas++;
                        lblNumCorrectas.setText(numCorrectas + "");
                        generarOperacion();
                    }else{
                        generarOperacion();
                    }
                    break;
                case 1:
                    if ((num1 - num2) == Integer.parseInt(txtResp.getText().toString())) {
                        numCorrectas++;
                        lblNumCorrectas.setText(numCorrectas + "");
                        generarOperacion();
                    }else{
                        generarOperacion();
                    }
                    break;
                case 2:
                    if ((num1 * num2) == Integer.parseInt(txtResp.getText().toString())) {
                        numCorrectas++;
                        lblNumCorrectas.setText(numCorrectas + "");
                        generarOperacion();
                    }else{
                        generarOperacion();
                    }
                    break;
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


        if (numCorrectas == 10){
            notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel = new NotificationChannel(
                        CANAL_ID, "Mis notificaciones",
                        NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel.setDescription("Descripción del canal");
                notificationManager.createNotificationChannel(notificationChannel);
            }

            NotificationCompat.Builder notificacion =
                    new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                            .setSmallIcon(R.drawable.outline_check_circle_outline_black_24dp)
                            .setContentTitle("\uD83D\uDE0E\uD83E\uDD19 ENHORABUENA \uD83E\uDD19\uD83D\uDE0E")
                            .setContentText(" Has acertado 10 operaciones!! ");
            notificationManager.notify(NOTIFICACION_ID, notificacion.build());
        }

    }

    private void generarOperacion(){
        txtResp.setText("");
        iSimbolo = (int)(Math.random()*4);

        lblSimbolo.setText( SIMBOLOS[iSimbolo]);

        num1= (int) (Math.random()*101);
        num2= (int) (Math.random()*101);

        while ((iSimbolo == 3 || iSimbolo == 1) && num2>num1) {
            num2= (int) (Math.random()*101);
        }
        txtNum1.setText(num1+"");
        txtNum2.setText(num2+"");

    }
}