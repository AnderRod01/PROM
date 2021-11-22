package com.example.ejerciciodialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActividadDescripcion extends AppCompatActivity {

    private String direccion;
    private int desc;
    private NotificationManager notificationManager;
    static final String CANAL_ID ="mi_canal";
    static final int NOTIFICACION_ID =1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_descripcion);



        Bundle datos =  getIntent().getExtras();

        direccion = datos.getString("direccion");
        desc = datos.getInt("desc");
        int img = datos.getInt("imagen");
        System.out.println(direccion);
        System.out.println("aa");

        Button btnRealizarPedido = (Button) findViewById(R.id.btnRealizarPedido);
        TextView lblDesc = (TextView) findViewById(R.id.lblDesc);
        ImageView imgDesc = (ImageView) findViewById(R.id.imgDesc);

        imgDesc.setImageDrawable(getDrawable(img));

        lblDesc.setText(getResources().getString(desc));

        btnRealizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager = (NotificationManager) getSystemService(
                        NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel(
                            CANAL_ID, "Mis notificaciones",
                            NotificationManager.IMPORTANCE_DEFAULT);
                    notificationChannel.setDescription("Descripción del canal");
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                //if (direccion.equals("")){
                NotificationCompat.Builder notificacion =
                        new NotificationCompat.Builder(ActividadDescripcion.this,CANAL_ID)
                                .setSmallIcon(R.drawable.logo_burger_king)
                                .setContentTitle("Se ha realizado tu pedido!")
                                .setContentText("Estara listo en 20 minutos");
                notificationManager.notify(NOTIFICACION_ID, notificacion.build());

                /*}else {
                    NotificationCompat.Builder notificacion =
                            new NotificationCompat.Builder(ActividadDescripcion.this,CANAL_ID)
                                    .setSmallIcon(R.drawable.logo_burger_king)
                                    .setContentTitle("Se ha realizado tu pedido a domicilio!")
                                    .setContentText("tu pedido llegara a " + direccion + " en 50 minutos");
                    notificationManager.notify(NOTIFICACION_ID, notificacion.build());
                }*/
                finish();
            }
        });



    }
}