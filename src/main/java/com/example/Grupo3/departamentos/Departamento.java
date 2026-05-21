package com.example.Grupo3.departamentos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de la tabla DEPARTAMENTOS")
public class Departamento {

    @Schema(
            description = "Código único del departamento",
            example = "1"
    )
    private int codigo;

    @Schema(
            description = "Nombre del departamento",
            example = "LA PAZ"
    )
    private String desc;

    @Schema(
            description = "Sigla del departamento",
            example = "LPZ"
    )
    private String sigla;

    // Constructor vacío
    public Departamento() {
    }

    // Constructor completo
    public Departamento(int codigo, String desc, String sigla) {
        this.codigo = codigo;
        this.desc = desc;
        this.sigla = sigla;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}