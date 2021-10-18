package com.example.controlesseleccion;

import android.widget.ImageView;

public class Web {

    private String nombre, url, id;
    private ImageView img;

    public Web (String nombre, String url, ImageView img, String id){
        this.nombre=nombre;
        this.url=url;
        this.img=img;
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public ImageView getImg() {
        return img;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

}
