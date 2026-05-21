package com.example.Grupo3.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "organismo_fin")
public class OrganismoFinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int gestion;
    private String of;
    private String des;
    private String sigla;

    public OrganismoFinEntity() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getGestion() { return gestion; }
    public void setGestion(int gestion) { this.gestion = gestion; }
    public String getOf() { return of; }
    public void setOf(String of) { this.of = of; }
    public String getDes() { return des; }
    public void setDes(String des) { this.des = des; }
    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }
}