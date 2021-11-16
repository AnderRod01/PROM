package com.example.ejerciciodialogos;

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

    private Menu [] datos = new Menu[] {};

    private ListView lstMenu;
    private MenuListener listener;

    public FragmentLista() {
        // Required empty public constructor
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lstMenu = (ListView) getView().findViewById(R.id.lstMenu);
        lstMenu.setAdapter(new AdaptadorMenu(this));

        lstMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                if (listener != null)
                    listener.onMenuSeleccionado(
                            (Menu) lstMenu.getAdapter().getItem(position));
            }
        });


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }


    class AdaptadorMenu extends ArrayAdapter<Menu> {
        private Activity context;

        public AdaptadorMenu (Fragment context){
            super (context.getActivity(), R.layout.listitem_menu, datos);
            this.context = context.getActivity();
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_menu, null);

            TextView lblTituloLibro = (TextView) item.findViewById(R.id.lblMenu);
            lblTituloLibro.setText(datos[position].getNombre());

            ImageView imgPortada = (ImageView) item.findViewById(R.id.img);
            imgPortada.setImageDrawable(getResources().getDrawable(datos[position].getImg()));

            return item;
        }
    }

    public void setMenuListener (MenuListener listener){
        this.listener=listener;
    }
}