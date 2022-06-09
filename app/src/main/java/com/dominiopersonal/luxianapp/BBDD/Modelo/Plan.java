package com.dominiopersonal.luxianapp.BBDD.Modelo;

public class Plan {

    String Altitud, Descripción, ID_plan, Latitud, Nombre, Precio, Tiempo;

    public Plan (){}

    public Plan(String altitud, String descripción, String ID_plan, String latitud, String nombre, String precio, String tiempo) {
        this.Altitud = altitud;
        this.Descripción = descripción;
        this.ID_plan = ID_plan;
        this.Latitud = latitud;
        this.Nombre = nombre;
        this.Precio = precio;
        this.Tiempo = tiempo;
    }

    public String getAltitud() {
        return Altitud;
    }

    public void setAltitud(String altitud) {
        Altitud = altitud;
    }

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String descripción) {
        Descripción = descripción;
    }

    public String getID_plan() {
        return ID_plan;
    }

    public void setID_plan(String ID_plan) {
        this.ID_plan = ID_plan;
    }

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String latitud) {
        Latitud = latitud;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getTiempo() {
        return Tiempo;
    }

    public void setTiempo(String tiempo) {
        Tiempo = tiempo;
    }
}
