package com.example.Grupo3.estado;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de la tabla ESTADO")
public class Estado {

    @Schema(
            description = "Código único del estado",
            example = "1"
    )
    private int codestado;

    @Schema(
            description = "Nombre del estado físico",
            example = "BUENO"
    )
    private String nomestado;

    public Estado() {
    }

    public Estado(int codestado, String nomestado) {
        this.codestado = codestado;
        this.nomestado = nomestado;
    }

    public int getCodestado() {
        return codestado;
    }

    public void setCodestado(int codestado) {
        this.codestado = codestado;
    }

    public String getNomestado() {
        return nomestado;
    }

    public void setNomestado(String nomestado) {
        this.nomestado = nomestado;
    }
}