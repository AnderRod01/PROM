package com.example.controlesseleccion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
    }



    class AdaptadorTitulares extends ArrayAdapter<Web> {

        private Web[] webs;

        public AdaptadorTitulares(@NonNull Context context, Web[] datos) {
            super(context, R.layout.listitem_web, datos);
            datos=webs;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_web, null);

            TextView tvTitulo = (TextView)item.findViewById(R.id.lblNombre);
            tvTitulo.setText(webs[position].getNombre());

            TextView tvSubtitulo = (TextView)item.findViewById(R.id.lblUrl);
            tvSubtitulo.setText(webs[position].getUrl());

            ImageView img = (ImageView) findViewById(R.id.img);
            img.setImageDrawable();

            return (item);
        }
    }
}