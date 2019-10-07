package com.example.controlesseleccion;

import android.content.res.Resources;
import android.media.Image;


public class Web {
    String id;
    String nombre;
    String url;
    String imagePath;

    public Web(String id, String nombre, String url, String imagePath) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
        this.imagePath = imagePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
