package com.dominiopersonal.luxianapp.BBDD.Modelo;

public class Ruta {

    String Capital, Ciudad, Descripción, Precio, Título;
    Long ID_ciudad, ID_ruta, Tiempo_Medio;

    public Ruta (){}

    public Ruta(String capital, String ciudad, String descripción, Long ID_ciudad, Long ID_ruta, String precio, Long tiempo_Medio, String título) {
        this.Capital = capital;
        this.Ciudad = ciudad;
        this.Descripción = descripción;
        this.ID_ciudad = ID_ciudad;
        this.ID_ruta = ID_ruta;
        this.Precio = precio;
        Tiempo_Medio = tiempo_Medio;
        Título = título;
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

    public Long getID_ciudad() {
        return ID_ciudad;
    }

    public void setID_ciudad(Long ID_ciudad) {
        this.ID_ciudad = ID_ciudad;
    }

    public Long getID_ruta() {
        return ID_ruta;
    }

    public void setID_ruta(Long ID_ruta) {
        this.ID_ruta = ID_ruta;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public Long getTiempo_Medio() {
        return Tiempo_Medio;
    }

    public void setTiempo_Medio(Long tiempo_Medio) {
        Tiempo_Medio = tiempo_Medio;
    }

    public String getTítulo() {
        return Título;
    }

    public void setTítulo(String título) {
        Título = título;
    }
}
