package com.example.fragments;

public class Libro {

    private String titulo;
    private String autor;
    private String sinopsis;
    private int img;

    public Libro (String titulo, String autor, String sinopsis, int img){
        this.autor=autor;
        this.sinopsis=sinopsis;
        this.titulo=titulo;
        this.img=img;
    }

    public int getImg() {
        return img;
    }

    public String getAutor() {
        return autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }
}
