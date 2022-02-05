package com.example.actividadficheros1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Ejercicio3 extends AppCompatActivity {

    private ListView listWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        listWeb = findViewById(R.id.listWeb);

        listWeb.setOnItemClickListener((parent, view, position, id) -> {
            Web web = (Web) parent.getItemAtPosition(position);
            String urlWeb = web.getUrl().trim();

            Uri uri = Uri.parse(urlWeb);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });


        ArrayList<Web> arrWeb = leerRecurso();
        Web[] datos = new Web[arrWeb.size()];

        for(int contDatos = 0; contDatos < datos.length; contDatos++)
            datos[contDatos] = arrWeb.get(contDatos);

        AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(this, datos);
        listWeb.setAdapter(adaptadorTitulares);


    }

    private ArrayList<Web> leerRecurso (){
        ArrayList<Web> arrWeb = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.webs)));

        try {
            String linea = br.readLine();
            while (linea!=null){
                String [] lineaDiv = linea.split(";");

                Web web = new Web(lineaDiv[0],lineaDiv[1], lineaDiv[2], lineaDiv[3]);
                arrWeb.add(web);
                linea=br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrWeb;
    }




    private static class AdaptadorTitulares extends ArrayAdapter<Web> {
        private final Web[] datos;

        public AdaptadorTitulares(Context context, Web[] datos) {
            super(context, R.layout.listitem_web, datos);
            this.datos = datos;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            @SuppressLint({"InflateParams", "ViewHolder"}) View item = inflater.inflate(R.layout.listitem_web, null);

            ImageView imgWeb = item.findViewById(R.id.imgWeb);
            try {
                Field idField = R.drawable.class.getDeclaredField(datos[position].getLogo().trim());
                try {
                    imgWeb.setImageResource(idField.getInt(idField));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }


            TextView tvNomWeb = item.findViewById(R.id.lblNombre);
            tvNomWeb.setText(datos[position].toString());

            TextView tvUrlWeb = item.findViewById(R.id.lblUrl);
            tvUrlWeb.setText(datos[position].getUrl());

            TextView tvIdWeb = item.findViewById(R.id.tvIdWeb);
            tvIdWeb.setText(datos[position].getId());
            return item;
        }
    }
}