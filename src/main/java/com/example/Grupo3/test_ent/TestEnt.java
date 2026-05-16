package com.example.Grupo3.test_ent;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de la tabla TEST_ENT")
public class TestEnt {

    @Schema(description = "Año de gestión", example = "2012")
    private int gestion;

    @Schema(description = "Código del sector", example = "1")
    private int sector_ent;

    @Schema(description = "Código de subsector", example = "1")
    private int subsec_ent;

    @Schema(description = "Código del área", example = "1")
    private int area_ent;

    @Schema(description = "Código de subárea", example = "14")
    private int subareaent;

    @Schema(description = "Nivel institucional", example = "0")
    private int nivel_inst;

    @Schema(description = "Descripción de la estructura", example = "Gobiernos Autónomos Departamentales")
    private String des_estruct;

    @Schema(description = "Sigla de la estructura", example = "GAD")
    private String siglaestru;

    @Schema(description = "Indica si es apropiable", example = "S")
    private String apropiable;

    // Constructor vacío
    public TestEnt() {
    }

    // Constructor completo
    public TestEnt(int gestion, int sector_ent, int subsec_ent,
                   int area_ent, int subareaent, int nivel_inst,
                   String des_estruct, String siglaestru,
                   String apropiable) {

        this.gestion = gestion;
        this.sector_ent = sector_ent;
        this.subsec_ent = subsec_ent;
        this.area_ent = area_ent;
        this.subareaent = subareaent;
        this.nivel_inst = nivel_inst;
        this.des_estruct = des_estruct;
        this.siglaestru = siglaestru;
        this.apropiable = apropiable;
    }

    public int getGestion() {
        return gestion;
    }

    public void setGestion(int gestion) {
        this.gestion = gestion;
    }

    public int getSector_ent() {
        return sector_ent;
    }

    public void setSector_ent(int sector_ent) {
        this.sector_ent = sector_ent;
    }

    public int getSubsec_ent() {
        return subsec_ent;
    }

    public void setSubsec_ent(int subsec_ent) {
        this.subsec_ent = subsec_ent;
    }

    public int getArea_ent() {
        return area_ent;
    }

    public void setArea_ent(int area_ent) {
        this.area_ent = area_ent;
    }

    public int getSubareaent() {
        return subareaent;
    }

    public void setSubareaent(int subareaent) {
        this.subareaent = subareaent;
    }

    public int getNivel_inst() {
        return nivel_inst;
    }

    public void setNivel_inst(int nivel_inst) {
        this.nivel_inst = nivel_inst;
    }

    public String getDes_estruct() {
        return des_estruct;
    }

    public void setDes_estruct(String des_estruct) {
        this.des_estruct = des_estruct;
    }

    public String getSiglaestru() {
        return siglaestru;
    }

    public void setSiglaestru(String siglaestru) {
        this.siglaestru = siglaestru;
    }

    public String getApropiable() {
        return apropiable;
    }

    public void setApropiable(String apropiable) {
        this.apropiable = apropiable;
    }
}