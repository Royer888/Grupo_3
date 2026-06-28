package com.example.Grupo3.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "objeto_gasto")
public class ObjetoGastoEntity {

    @Id
    @Column(name = "objeto", nullable = false, length = 50)
    private String objeto;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "gestion")
    private Integer gestion;

    @Column(name = "estado", length = 30)
    private String estado;

    public ObjetoGastoEntity() {
    }

    public ObjetoGastoEntity(String objeto, String descripcion, Integer gestion, String estado) {
        this.objeto = objeto;
        this.descripcion = descripcion;
        this.gestion = gestion;
        this.estado = estado;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getGestion() {
        return gestion;
    }

    public void setGestion(Integer gestion) {
        this.gestion = gestion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
