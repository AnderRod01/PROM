package com.example.operar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView lblResult;
    private EditText num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    
    
    public void suma (View v){

        lblResult = (TextView) findViewById(R.id.suma);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        lblResult.setText("Resultado: " + (Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString())));
    }

    public void resta (View v){
        lblResult = (TextView) findViewById(R.id.suma);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        lblResult.setText("Resultado: " + (Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num2.getText().toString())));
    }

    public void multiplicar (View v){
        lblResult = (TextView) findViewById(R.id.suma);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        lblResult.setText("Resultado: " + (Integer.parseInt(num1.getText().toString()) * Integer.parseInt(num2.getText().toString())));
    }

    public void dividir (View v){
        lblResult = (TextView) findViewById(R.id.suma);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        lblResult.setText("Resultado: " + (Integer.parseInt(num1.getText().toString()) / Integer.parseInt(num2.getText().toString())));
    }
}