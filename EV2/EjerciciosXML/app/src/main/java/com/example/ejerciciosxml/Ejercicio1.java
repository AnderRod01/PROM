package com.example.ejerciciosxml;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Ejercicio1 extends AppCompatActivity {

    private final String url = "https://www.europapress.es/rss/rss.aspx";
    private List<Noticia> noticias;
    private ListView listaNoticias;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        cargarConSAXSimplificado();


        listaNoticias = findViewById(R.id.listaNoticias);
        listaNoticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Noticia noticia =(Noticia) adapterView.getItemAtPosition(i);
                String url = noticia.getGuid().trim();

                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    public void cargarConSAXSimplificado () {
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {

        protected Boolean doInBackground(String...params) {
            RssParserSAX_Noticia saxparser =
                    new RssParserSAX_Noticia(params[0]);
            noticias = saxparser.parse();
            return true;
        }

        @SuppressLint("SetTextI18n")
        protected void onPostExecute(Boolean result) {
            Noticia[] datos = new Noticia[noticias.size()];
            for (int i = 0; i < noticias.size(); i++) {
                datos[i] = noticias.get(i);
            }
            AdaptadorNoticias adaptadorNoticias = new AdaptadorNoticias(getApplicationContext(), datos);
            listaNoticias.setAdapter(adaptadorNoticias);
        }
    }

    private static class AdaptadorNoticias extends ArrayAdapter<Noticia> {

        private final Noticia[] datos;

        public AdaptadorNoticias(Context context, Noticia[] datos) {
            super(context, R.layout.listitem_noticias, datos);
            this.datos = datos;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            @SuppressLint({"InflateParams", "ViewHolder"}) View item = inflater.inflate(R.layout.listitem_noticias, null);

            String titulo = datos[position].getTitulo().trim();
            TextView txtTitulo = item.findViewById(R.id.titulo);
            txtTitulo.setText(titulo);

            return item;
        }
    }
}