package com.example.Grupo3.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "obj_gasto")
public class ObjGastoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", length = 50)
    private String codigo;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    // Constructores vacíos y con parámetros
    public ObjGastoEntity() {
    }

    public ObjGastoEntity(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}