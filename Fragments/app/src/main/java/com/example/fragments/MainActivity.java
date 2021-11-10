package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LibroListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentLista fragmentLista = (FragmentLista) getSupportFragmentManager().findFragmentById(R.id.frgLista);
        fragmentLista.setLibroListener(this);
    }

    @Override
    public void onLibroSeleccionado(Libro l) {
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!= null);
        if (hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager().
                    findFragmentById(R.id.frgDetalle)).mostrarSinopsis(l.getSinopsis());
        }
        else {
            Intent i = new Intent(this, activityDetalle.class);
            i.putExtra(activityDetalle.EXTRA_TEXTO, l.getSinopsis());
            startActivity(i);
        }
    }
}