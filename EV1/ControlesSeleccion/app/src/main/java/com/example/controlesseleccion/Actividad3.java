package com.example.controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Actividad3 extends AppCompatActivity {

    private final String []  DATOS ={"Lidia", "Kunimitsu", "Armor King", "Kazuya", "Heihachi", "Jin", "Kazumi","Yoshimitsu", "Lei Wulong"};
    private final int [] IMG_PERSONAJES = {R.drawable.lidia, R.drawable.kuni, R.drawable.armorking, R.drawable.kazuya, R.drawable.heihachi, R.drawable.jin, R.drawable.kazumi, R.drawable.yoshimitsu, R.drawable.lei};
    private GridView gvPersonajes;
    private TextView lblRage;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        gvPersonajes = (GridView) findViewById(R.id.gvPersonajes);
        lblRage = (TextView) findViewById(R.id.lblRage);
        img = (ImageView) findViewById(R.id.img);


        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, DATOS);

        gvPersonajes.setAdapter(adaptador);

        gvPersonajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                img.setImageDrawable(getDrawable(IMG_PERSONAJES[i]));
                lblRage.setText(getResources().getStringArray(R.array.rage)[i]);

            }
        });
    }




    public void volver(View view){
        finish();
    }
}