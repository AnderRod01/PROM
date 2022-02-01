package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Actividad3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);
    }

    public void enviar (View v){


        String datos = "";
        EditText txtNombre = (EditText) findViewById(R.id.txtNombre_act3);
        EditText txtApellidos = (EditText) findViewById(R.id.txtApellidos_act3);

        datos +=txtNombre.getText().toString() + " " + txtApellidos.getText().toString() + "\n";



        RadioGroup grupo = (RadioGroup) findViewById(R.id.radioGroupSexo);
        int id = grupo.getCheckedRadioButtonId();
        RadioButton rbtn = grupo.findViewById(id);

        datos += rbtn.getText().toString() + "\n";


        CheckBox c = (CheckBox) findViewById(R.id.chkboxMusica);
        if(c.isChecked()){
            datos += c.getText().toString()+"\t";
        }
        c = (CheckBox) findViewById(R.id.chkboxLectura);
        if(c.isChecked()){
            datos += c.getText().toString()+"\t";
        }
        c = (CheckBox) findViewById(R.id.chkboxDeporte);
        if(c.isChecked()){
            datos += c.getText().toString()+"\t";
        }
        c = (CheckBox) findViewById(R.id.chkboxViajar);
        if(c.isChecked()){
            datos += c.getText().toString()+"\t";
        }

        Intent intent = new Intent(Actividad3.this, Actividad3_Datos.class);
        intent.putExtra("datos", datos);
        startActivity(intent);

    }
}