package com.example.ejerciciodialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoLogin extends DialogFragment {

    private EditText txtUsuario, txtContrasena;
    private OnDialogoInicioSesion listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener= (OnDialogoInicioSesion)context;


        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "no Implemento OnDialogoInicioSesion");
        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        setCancelable(true);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = onCreateView(inflater, null,null);
        builder.setView(inflater.inflate(R.layout.dialogo_login, null))
                .setPositiveButton("Iniciar sesion", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.onPossitiveButtonClickInicio(txtUsuario.getText().toString(), txtContrasena.getText().toString());
                    }
                }).setNegativeButton("SALIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onNegativeButtonClick();
            }
        });
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        txtUsuario = (EditText) getDialog().findViewById(R.id.txtUsuario);
        txtContrasena = (EditText) getDialog().findViewById(R.id.txtContrasenia);
    }

    public interface OnDialogoInicioSesion {
        void onPossitiveButtonClickInicio(String usu, String pass);
        void onNegativeButtonClick();
    }

}




