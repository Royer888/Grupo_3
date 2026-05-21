package com.example.Grupo3.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "baja")
public class BajaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codbaja;

    @Column(name = "descbaja", nullable = false, length = 120)
    private String descbaja;

    public BajaEntity() {}

    public BajaEntity(Long codbaja, String descbaja) {
        this.codbaja = codbaja;
        this.descbaja = descbaja;
    }

    public Long getCodbaja() { return codbaja; }
    public void setCodbaja(Long codbaja) { this.codbaja = codbaja; }
    public String getDescbaja() { return descbaja; }
    public void setDescbaja(String descbaja) { this.descbaja = descbaja; }
}