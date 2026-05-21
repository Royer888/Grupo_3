package com.example.Grupo3.Tablas_antes_de_Entity.organismo_fin;

public class OrganismoFin {

    private int gestion;
    private String of;
    private String des;
    private String sigla;

    public OrganismoFin() {
    }

    public OrganismoFin(int gestion, String of, String des, String sigla) {
        this.gestion = gestion;
        this.of = of;
        this.des = des;
        this.sigla = sigla;
    }

    public int getGestion() {
        return gestion;
    }

    public void setGestion(int gestion) {
        this.gestion = gestion;
    }

    public String getOf() {
        return of;
    }

    public void setOf(String of) {
        this.of = of;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}