package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class activityDetalle extends AppCompatActivity {

    public static final String EXTRA_TEXTO = "com.example.ejfragments.EXTRA_TEXTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        FragmentDetalle detalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);

        Log.i("valor EXTRA_TEXTO: ",EXTRA_TEXTO);
        Log.i("paso: ",getIntent().getStringExtra(EXTRA_TEXTO));
        Log.i("AAA: ",getIntent().getClass().toString());

        detalle.mostrarSinopsis(getIntent().getStringExtra(EXTRA_TEXTO));
    }
}