package com.example.actividadwhatsapp;

public class Chat {
    private String nombre, mensaje, hora;

    public Chat (String nombre, String mensaje, String hora){
        this.mensaje=mensaje;
        this.nombre=nombre;
        this.hora=hora;
    }

    public String getHora() {
        return hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getNombre() {
        return nombre;
    }


}
