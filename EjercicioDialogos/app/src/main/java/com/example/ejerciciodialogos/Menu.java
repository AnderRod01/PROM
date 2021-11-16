package com.example.ejerciciodialogos;

public class Menu {
    private String nombre;
    private int img, desc;
    private boolean carne;

    public Menu (String nombre, int desc, int img, boolean carne){
        this.nombre=nombre;
        this.desc=desc;
        this.img=img;
        this.carne = carne;
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
