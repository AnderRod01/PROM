package com.example.ejerciciodialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoSalir extends DialogFragment {
    private OnDialogoCerrar listener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener= (OnDialogoCerrar)context;


        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "no Implemento OnDialogoInicioSesion");
        }
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Seguro que quieres salir?").setTitle("Salir")
                .setPositiveButton("SALIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.onPossitiveButtonClick();
                    }
                })
                .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public interface OnDialogoCerrar{
        void onPossitiveButtonClick();
    }
}
