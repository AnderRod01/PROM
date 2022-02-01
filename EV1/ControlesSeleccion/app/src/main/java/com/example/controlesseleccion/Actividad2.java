package com.example.controlesseleccion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

    private ListView lvWebsFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        lvWebsFav = (ListView) findViewById(R.id.lvWebsFav);

        rellenarLista();

        lvWebsFav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Web webSeleccionada = (Web) adapterView.getItemAtPosition(i);

                Uri uri = Uri.parse(webSeleccionada.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    private void rellenarLista(){
        final Web[] WEBS = {new Web("Twitter", "https://twitter.com", R.drawable.twitter, "Red social"),
                new Web("Nomad Complex", "https://nomadcomplex.com", R.drawable.nomad_complex,"Tienda de ropa"),
                new Web("Twitch", "https://www.twitch.tv/", R.drawable.twitch, "Plataforma de streaming"),
                new Web ("Etsy", "https://www.etsy.com", R.drawable.etsy, "Comercio online de artesania")};

        AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(this, WEBS);
        lvWebsFav.setAdapter(adaptadorTitulares);
    }



    class AdaptadorTitulares extends ArrayAdapter<Web> {

        private Web[] datos;

        public AdaptadorTitulares(@NonNull Context context, Web[] datos) {
            super(context, R.layout.listitem_web, datos);
            this.datos=datos;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_web, null);

            TextView tvTitulo = (TextView)item.findViewById(R.id.lblNombre);
            tvTitulo.setText(datos[position].getNombre());

            TextView tvSubtitulo = (TextView)item.findViewById(R.id.lblIdentificativo);
            tvSubtitulo.setText(datos[position].getId());

            ImageView img = (ImageView) item.findViewById(R.id.img);
            img.setImageDrawable(getDrawable(datos[position].getidDrawable()));

            return (item);
        }
    }

    public void volver(View view){
        finish();
    }
}