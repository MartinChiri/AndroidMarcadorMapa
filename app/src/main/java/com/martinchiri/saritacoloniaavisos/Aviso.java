package com.martinchiri.saritacoloniaavisos;

public class Aviso {
    private String titulo;
    private String detalle;
    private String direccion;
    private double latitud;
    private double longitud;

    public Aviso(String titulo, String detalle, String direccion, double latitud, double longitud) {
        this.titulo = titulo;
        this.detalle = detalle;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }


    public String getTitulo() {
        return titulo;
    }


    public String getDetalle() {
        return detalle;
    }


    public String getDireccion() {
        return direccion;
    }
}
