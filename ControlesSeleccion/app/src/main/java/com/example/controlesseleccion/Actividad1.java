package com.example.controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        ListView lvPaises= (ListView) findViewById(R.id.lvPaises);
        TextView lblInfo=(TextView) findViewById(R.id.lblInfo);


        ArrayAdapter adapter= ArrayAdapter.createFromResource(this, R.array.paises, android.R.layout.simple_list_item_1);
        lvPaises.setAdapter(adapter);

        lvPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        lblInfo.setText("HABITANTES: 47,35 millones (2020)\nSUPERFICIE: 505.990 km²");
                        break;
                    case 1:
                        lblInfo.setText("HABITANTES: 67,39 millones (2020)\nSUPERFICIE: 632.734 km²");
                        break;
                    case 2:
                        lblInfo.setText("HABITANTES: 83,24 millones (2020)\nSUPERFICIE: 357.386 km²");
                        break;
                    case 3:
                        lblInfo.setText("HABITANTES: 329,5 millones (2020)\nSUPERFICIE: 9,834 millones km²");
                        break;
                    default:
                        lblInfo.setText("HABITANTES: 1,402 miles de millones (2020)\nSUPERFICIE: 9,597 millones km²");
                }
            }
        });
    }

    public void volver(View view){
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}