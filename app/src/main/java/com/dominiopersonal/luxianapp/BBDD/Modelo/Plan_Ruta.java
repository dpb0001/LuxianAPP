package com.dominiopersonal.luxianapp.BBDD.Modelo;

public class Plan_Ruta {

    String ID_plan, ID_ruta;

    public Plan_Ruta(){}

    public Plan_Ruta(String ID_plan, String ID_ruta) {
        this.ID_plan = ID_plan;
        this.ID_ruta = ID_ruta;
    }

    public String getID_plan() {
        return ID_plan;
    }

    public void setID_plan(String ID_plan) {
        this.ID_plan = ID_plan;
    }

    public String getID_ruta() {
        return ID_ruta;
    }

    public void setID_ruta(String ID_ruta) {
        this.ID_ruta = ID_ruta;
    }
}
