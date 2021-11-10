package com.example.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class FragmentLista extends Fragment {

    private Libro [] datos = new Libro[] {
            new Libro("Nacidos de la bruma: El Imperio Final", "Brandon Sanderson", "Rebelion al Imperio Final", R.drawable.imperiofinal),
            new Libro("Nacidos de la bruma: El pozo de la ascensión", "Brandon Sanderson", "Asedio a Luthadel", R.drawable.pozoascension),
            new Libro("Metro 2033", "Dmitry Glukhovsky", "Supervivencia en el metro por una apocalipsis nuclear", R.drawable.metro2033)};

    private ListView lstLista;
    private LibroListener listener;


    public FragmentLista() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lstLista = (ListView) getView().findViewById(R.id.lstListado);
        lstLista.setAdapter(new AdaptadorLibros(this));

        lstLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                if (listener != null)
                    listener.onLibroSeleccionado(
                            (Libro)lstLista.getAdapter().getItem(position));
            }
        });


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }


    class AdaptadorLibros extends ArrayAdapter<Libro>{
        private Activity context;

        public AdaptadorLibros (Fragment context){
            super (context.getActivity(), R.layout.listitem_libro, datos);
            this.context = context.getActivity();
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_libro, null);

            TextView lblTituloLibro = (TextView) item.findViewById(R.id.lblTituloLibro);
            lblTituloLibro.setText(datos[position].getTitulo());

            TextView lblAutor = (TextView) item.findViewById(R.id.lblAutor);
            lblAutor.setText(datos[position].getAutor());

            ImageView imgPortada = (ImageView) item.findViewById(R.id.imgPortada);
            imgPortada.setImageDrawable(getResources().getDrawable(datos[position].getImg()));

            return item;
        }
    }

    public void setLibroListener (LibroListener listener){
        this.listener = listener;
    }

}