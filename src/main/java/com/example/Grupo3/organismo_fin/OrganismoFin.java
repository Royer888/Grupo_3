package com.example.Grupo3.organismo_fin;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de la tabla ORGANISMO_FIN")
public class OrganismoFin {

    @Schema(
            description = "Año de gestión del organismo financiador",
            example = "2013"
    )
    private int gestion;

    @Schema(
            description = "Código único del organismo financiador",
            example = "111"
    )
    private String of;

    @Schema(
            description = "Descripción completa del organismo financiador",
            example = "Tesoro"
    )
    private String des;

    @Schema(
            description = "Sigla oficial del organismo financiador",
            example = "TGN"
    )
    private String sigla;

    // Constructor vacío
    public OrganismoFin() {
    }

    // Constructor completo
    public OrganismoFin(int gestion, String of, String des, String sigla) {
        this.gestion = gestion;
        this.of = of;
        this.des = des;
        this.sigla = sigla;
    }

    public int getGestion() {
        return gestion;
    }

    public void setGestion(int gestion) {
        this.gestion = gestion;
    }

    public String getOf() {
        return of;
    }

    public void setOf(String of) {
        this.of = of;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}