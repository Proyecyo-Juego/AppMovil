package com.example.myapplication;

public class Pelea {
    private String nombre;
    private String descripcion;
    private int nivel;


    public Pelea(String nombre, String descripcion, int nivel) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    public Pelea(){}

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNivel() {
        return nivel;
    }
    public String getNivelString() {
        return "nivel: " + nivel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
