package com.dominiopersonal.luxianapp.BBDD.Modelo;

public class Ciudad {

    String Descripción, Foto, Nombre;
    Long ID_ciudad, Latitud, Longitud;

    public Ciudad(){}

    public Ciudad(String descripción, String foto, String nombre, Long ID_ciudad, Long latitud, Long longitud) {
        this.Descripción = descripción;
        this.Foto = foto;
        this.Nombre = nombre;
        this.ID_ciudad = ID_ciudad;
        Latitud = latitud;
        Longitud = longitud;
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Long getID_ciudad() {
        return ID_ciudad;
    }

    public void setID_ciudad(Long ID_ciudad) {
        this.ID_ciudad = ID_ciudad;
    }

    public Long getLatitud() {
        return Latitud;
    }

    public void setLatitud(Long latitud) {
        Latitud = latitud;
    }

    public Long getLongitud() {
        return Longitud;
    }

    public void setLongitud(Long longitud) {
        Longitud = longitud;
    }
}
