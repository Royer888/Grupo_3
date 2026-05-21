package com.example.Grupo3.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "estados")
@Schema(description = "Modelo de la tabla ESTADO")
public class EstadoEntity {

    @Id
    @Column(name = "codestado")
    @Schema(description = "Código único del estado", example = "1")
    private int codestado;

    @Column(name = "nomestado", length = 10, nullable = false)
    @Schema(description = "Nombre del estado físico", example = "BUENO")
    private String nomestado;

    public EstadoEntity() {}

    public EstadoEntity(int codestado, String nomestado) {
        this.codestado = codestado;
        this.nomestado = nomestado;
    }

    public int getCodestado() { return codestado; }
    public void setCodestado(int codestado) { this.codestado = codestado; }

    public String getNomestado() { return nomestado; }
    public void setNomestado(String nomestado) { this.nomestado = nomestado; }
}