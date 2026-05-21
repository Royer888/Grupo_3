package com.example.Grupo3.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "departamentos")
@Schema(description = "Modelo de la tabla DEPARTAMENTOS")
public class DepartamentoEntity {

    @Id
    @Column(name = "codigo")
    @Schema(
            description = "Código único del departamento",
            example = "1"
    )
    private Integer codigo;

    @Column(name = "descripcion", length = 15)
    @Schema(
            description = "Nombre del departamento",
            example = "LA PAZ"
    )
    private String descripcion;

    @Column(name = "sigla", length = 10)
    @Schema(
            description = "Sigla del departamento",
            example = "LPZ"
    )
    private String sigla;

    // Constructor vacío
    public DepartamentoEntity() {}

    // Constructor completo
    public DepartamentoEntity(Integer codigo, String descripcion, String sigla) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.sigla = sigla;
    }

    // Getters y Setters
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}