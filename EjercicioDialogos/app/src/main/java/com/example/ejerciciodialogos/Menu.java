package com.example.ejerciciodialogos;

import android.widget.ImageView;

public class Menu {
    private String nombre;
    private int desc;
    private ImageView img;


    public Menu (String nombre, int desc, ImageView img){
        this.nombre=nombre;
        this.desc=desc;
        this.img=img;
    }

    public String getNombre() {
        return nombre;
    }

    public ImageView getImg() {
        return img;
    }

    public int getDesc() {
        return desc;
    }

}
