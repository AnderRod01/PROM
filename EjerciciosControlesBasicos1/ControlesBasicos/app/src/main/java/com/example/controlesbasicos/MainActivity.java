package com.example.controlesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnPrueba;
    private TextView lblSuma;
    private EditText num1, num2;
    private final String TEXTOSUMA= "La suma es: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrueba = (Button) findViewById(R.id.botonSimple);
        lblSuma = (TextView) findViewById(R.id.suma);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        btnPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblSuma.setText(TEXTOSUMA + (Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString())));
            }
        });

    }


}