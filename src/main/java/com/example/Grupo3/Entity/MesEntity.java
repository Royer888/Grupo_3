package com.example.Grupo3.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mes")
public class MesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mes;

    @Column(name = "nommes", nullable = false, length = 10)
    private String nommes;

    public MesEntity() {
    }

    public MesEntity(Long mes, String nommes) {
        this.mes = mes;
        this.nommes = nommes;
    }


    public Long getMes() {
        return mes;
    }

    public void setMes(Long mes) {
        this.mes = mes;
    }

    public String getNommes() {
        return nommes;
    }

    public void setNommes(String nommes) {
        this.nommes = nommes;
    }
}