package com.example.Grupo3.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "com/example/Grupo3/Tablas_antes_de_Entity/estado_entidad")
public class EstadoEntidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int gestion;
    private int sectorEnt;
    private int subsecEnt;
    private int areaEnt;
    private int subareaent;
    private int nivelInst;
    private String desEstruct;
    private String siglaestru;
    private String apropiable;

    public EstadoEntidadEntity() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getGestion() { return gestion; }
    public void setGestion(int gestion) { this.gestion = gestion; }
    public int getSectorEnt() { return sectorEnt; }
    public void setSectorEnt(int sectorEnt) { this.sectorEnt = sectorEnt; }
    public int getSubsecEnt() { return subsecEnt; }
    public void setSubsecEnt(int subsecEnt) { this.subsecEnt = subsecEnt; }
    public int getAreaEnt() { return areaEnt; }
    public void setAreaEnt(int areaEnt) { this.areaEnt = areaEnt; }
    public int getSubareaent() { return subareaent; }
    public void setSubareaent(int subareaent) { this.subareaent = subareaent; }
    public int getNivelInst() { return nivelInst; }
    public void setNivelInst(int nivelInst) { this.nivelInst = nivelInst; }
    public String getDesEstruct() { return desEstruct; }
    public void setDesEstruct(String desEstruct) { this.desEstruct = desEstruct; }
    public String getSiglaestru() { return siglaestru; }
    public void setSiglaestru(String siglaestru) { this.siglaestru = siglaestru; }
    public String getApropiable() { return apropiable; }
    public void setApropiable(String apropiable) { this.apropiable = apropiable; }
}