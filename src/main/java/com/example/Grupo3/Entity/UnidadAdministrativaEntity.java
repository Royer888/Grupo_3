package com.example.Grupo3.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidad_administrativa")
public class UnidadAdministrativaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entidad", nullable = false, length = 100)
    private String entidad;

    @Column(name = "unidad", nullable = false, length = 50)
    private String unidad;

    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;

    @Column(name = "ciudad", nullable = false, length = 80)
    private String ciudad;

    @Column(name = "estado_uni", nullable = false, length = 20)
    private String estadoUni;

    public UnidadAdministrativaEntity() {
    }

    public UnidadAdministrativaEntity(Long id, String entidad, String unidad, String descripcion, String ciudad, String estadoUni) {
        this.id = id;
        this.entidad = entidad;
        this.unidad = unidad;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.estadoUni = estadoUni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstadoUni() {
        return estadoUni;
    }

    public void setEstadoUni(String estadoUni) {
        this.estadoUni = estadoUni;
    }
}
