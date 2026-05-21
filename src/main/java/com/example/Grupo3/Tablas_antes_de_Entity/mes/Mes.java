package com.example.Grupo3.Tablas_antes_de_Entity.mes;

public class Mes {
    private int mes;
    private String nommes;

    public Mes() {}

    public Mes(int mes, String nommes) {
        this.mes = mes;
        this.nommes = nommes;
    }

    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }

    public String getNommes() { return nommes; }
    public void setNommes(String nommes) { this.nommes = nommes; }
}