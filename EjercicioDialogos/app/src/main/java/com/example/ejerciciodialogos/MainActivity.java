package com.example.ejerciciodialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoInicioSesion, DialogoSalir.OnDialogoCerrar{

    private static final String USER = "usuario1", PSWD = "123456";
    private Button btnPedido;
    private EditText txtDireccion;
    private RadioGroup rdGroup;
    private RadioButton rBtnDomicilio, rBtnRecoger;
    private TextView lblDireccion;
    private String direccion = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        DialogoLogin dialogoLogin = new DialogoLogin();
        dialogoLogin.show(fm, "tagLogin");

        btnPedido = (Button) findViewById(R.id.btnPedido);

        rdGroup = (RadioGroup) findViewById(R.id.rdGroup);
        rBtnDomicilio = (RadioButton) findViewById(R.id.rdDomicilio);
        rBtnRecoger = (RadioButton) findViewById(R.id.rdRecoger);

        lblDireccion = (TextView) findViewById(R.id.lblDireccion);
        txtDireccion = (EditText) findViewById(R.id.txtDireccion);

        if (rBtnDomicilio.isChecked()){
            direccion = txtDireccion.getText().toString();
        }


        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, ActividadMenus.class);
                intent.putExtra("direccion", direccion);
                startActivity(intent);
                
            }
        });

        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioGroup.getCheckedRadioButtonId() == R.id.rdDomicilio){
                    lblDireccion.setVisibility(View.VISIBLE);
                    txtDireccion.setVisibility(View.VISIBLE);
                    btnPedido.setEnabled(true);
                }else{
                    lblDireccion.setVisibility(View.INVISIBLE);
                    txtDireccion.setVisibility(View.INVISIBLE);
                    btnPedido.setEnabled(true);
                }
            }
        });

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