package com.example.ejerciciodialogos;

import android.widget.ImageView;

public class Menu {
    private String nombre;
    private int desc;
    private int img;


    public Menu (String nombre, int desc, int img){
        this.nombre=nombre;
        this.desc=desc;
        this.img=img;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImg() {
        return img;
    }

    public int getDesc() {
        return desc;
    }

}
