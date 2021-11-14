package com.example.ejerciciodialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoInicioSesion, DialogoSalir.OnDialogoCerrar{

    private static final String USER = "usuario1", PSWD = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        DialogoLogin dialogoLogin = new DialogoLogin();
        dialogoLogin.show(fm, "tagLogin");
    }

    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogoSalir dialogoSalir = new DialogoSalir();
        dialogoSalir.show(fragmentManager, "DialogoSalir");
    }

    @Override
    public void onPossitiveButtonClickInicio(String usu, String pass) {
        if(!usu.equals(USER) || !pass.equals(PSWD)) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogoLogin dialogoLogin = new DialogoLogin();
            dialogoLogin.show(fragmentManager, "DialogoLogin");
        }
    }

    @Override
    public void onNegativeButtonClick() {
        finish();
    }

    @Override
    public void onPossitiveButtonClick() {
        finish();
    }
}