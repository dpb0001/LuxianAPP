package com.dominiopersonal.luxianapp.BBDD.Modelo;

public class Ruta {

    String Capital, Ciudad, Descripción, ID_ciudad, ID_ruta, Precio, Tiempo_Medio, Título;

    public Ruta (){}

    public Ruta(String capital, String ciudad, String descripción, String ID_ciudad, String ID_ruta, String precio, String tiempo_Medio, String título) {
        this.Capital = capital;
        this.Ciudad = ciudad;
        this.Descripción = descripción;
        this.ID_ciudad = ID_ciudad;
        this.ID_ruta = ID_ruta;
        this.Precio = precio;
        this.Tiempo_Medio = tiempo_Medio;
        this.Título = título;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String descripción) {
        Descripción = descripción;
    }

    public String getID_ciudad() {
        return ID_ciudad;
    }

    public void setID_ciudad(String ID_ciudad) {
        this.ID_ciudad = ID_ciudad;
    }

    public String getID_ruta() {
        return ID_ruta;
    }

    public void setID_ruta(String ID_ruta) {
        this.ID_ruta = ID_ruta;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getTiempo_Medio() {
        return Tiempo_Medio;
    }

    public void setTiempo_Medio(String tiempo_Medio) {
        Tiempo_Medio = tiempo_Medio;
    }

    public String getTítulo() {
        return Título;
    }

    public void setTítulo(String título) {
        Título = título;
    }
}
