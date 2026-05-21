package com.example.Grupo3.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "organismos_fin")
@Schema(description = "Modelo de la tabla ORGANISMO_FIN")
public class OrganismoFinEntity {

    @Id
    @Column(name = "of")
    @Schema(description = "Código único del organismo financiador", example = "111")
    private String of;

    @Column(name = "gestion")
    @Schema(description = "Año de gestión del organismo financiador", example = "2013")
    private int gestion;

    @Column(name = "des")
    @Schema(description = "Descripción completa del organismo financiador", example = "Tesoro")
    private String des;

    @Column(name = "sigla")
    @Schema(description = "Sigla oficial del organismo financiador", example = "TGN")
    private String sigla;

    public OrganismoFinEntity() {}

    public OrganismoFinEntity(int gestion, String of, String des, String sigla) {
        this.gestion = gestion;
        this.of = of;
        this.des = des;
        this.sigla = sigla;
    }

    public String getOf() { return of; }
    public void setOf(String of) { this.of = of; }

    public int getGestion() { return gestion; }
    public void setGestion(int gestion) { this.gestion = gestion; }

    public String getDes() { return des; }
    public void setDes(String des) { this.des = des; }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }
}