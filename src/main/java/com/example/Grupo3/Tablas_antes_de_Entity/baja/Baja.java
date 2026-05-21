package com.example.Grupo3.Tablas_antes_de_Entity.baja;

public class Baja {
    private int codbaja;
    private String descbaja;

    public Baja() {}

    public Baja(int codbaja, String descbaja) {
        this.codbaja = codbaja;
        this.descbaja = descbaja;
    }

    public int getCodbaja() { return codbaja; }
    public void setCodbaja(int codbaja) { this.codbaja = codbaja; }

    public String getDescbaja() { return descbaja; }
    public void setDescbaja(String descbaja) { this.descbaja = descbaja; }
}
