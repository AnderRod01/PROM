package com.example.actividadficheros1;

public class Web {

    private String nombre, url, logo, id;

    public Web (String nombre, String url, String logo, String id){
        this.nombre = nombre;
        this.url=url;
        this.logo=logo;
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getLogo() {
        return logo;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
