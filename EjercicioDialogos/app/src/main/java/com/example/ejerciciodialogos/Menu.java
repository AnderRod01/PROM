package com.example.ejerciciodialogos;

public class Menu {
    private String nombre, desc;
    private int img;

    public Menu (String nombre, String desc, int img){
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

    public String getDesc() {
        return desc;
    }

}
