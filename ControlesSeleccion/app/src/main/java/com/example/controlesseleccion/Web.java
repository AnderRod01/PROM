package com.example.controlesseleccion;

import android.widget.ImageView;

public class Web {

    private String nombre, url, id;
    private int idDrawable;

    public Web (String nombre, String url, int idDrawable, String id){
        this.nombre=nombre;
        this.url=url;
        this.idDrawable=idDrawable;
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getidDrawable() {
        return idDrawable;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

}
