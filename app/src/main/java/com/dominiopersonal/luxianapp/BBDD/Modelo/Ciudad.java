package com.dominiopersonal.luxianapp.BBDD.Modelo;

public class Ciudad {

    String Descripción, Foto, ID_ciudad, Latitud, Longitud, Nombre;

    public Ciudad(){}

    public Ciudad(String descripción, String foto, String ID_ciudad, String latitud, String longitud, String nombre) {
        this.Descripción = descripción;
        this.Foto = foto;
        this.ID_ciudad = ID_ciudad;
        this.Latitud = latitud;
        this.Longitud = longitud;
        this.Nombre = nombre;
    }

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String descripción) {
        Descripción = descripción;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getID_ciudad() {
        return ID_ciudad;
    }

    public void setID_ciudad(String ID_ciudad) {
        this.ID_ciudad = ID_ciudad;
    }

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String latitud) {
        Latitud = latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    public void setLongitud(String longitud) {
        Longitud = longitud;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
