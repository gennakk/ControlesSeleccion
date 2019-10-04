package com.example.controlesseleccion;

public class Pais {

    String nombre;
    int superficie;
    int habitantes;

    public Pais(String nombre, int superficie, int habitantes) {
        this.nombre = nombre;
        this.superficie = superficie;
        this.habitantes = habitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }
}
