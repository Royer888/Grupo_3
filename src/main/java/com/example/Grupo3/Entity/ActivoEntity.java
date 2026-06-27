package com.example.Grupo3.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "activo")
public class ActivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false, unique = true, length = 50)
    private String codigo;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "marca", length = 80)
    private String marca;

    @Column(name = "modelo", length = 80)
    private String modelo;

    @Column(name = "serie", length = 80)
    private String serie;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;

    @Column(name = "departamento", length = 100)
    private String departamento;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "organismo_fin", length = 150)
    private String organismoFin;

    @Column(name = "unidad_administrativa", length = 150)
    private String unidadAdministrativa;

    @Column(name = "entidad", length = 150)
    private String entidad;

    @Column(name = "usuario_registro", length = 80)
    private String usuarioRegistro;

    public ActivoEntity() {
    }

    public ActivoEntity(Long id, String codigo, String descripcion, String marca, String modelo, String serie,
                        Double precio, LocalDate fechaCompra, String departamento, String estado,
                        String organismoFin, String unidadAdministrativa, String entidad, String usuarioRegistro) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
        this.departamento = departamento;
        this.estado = estado;
        this.organismoFin = organismoFin;
        this.unidadAdministrativa = unidadAdministrativa;
        this.entidad = entidad;
        this.usuarioRegistro = usuarioRegistro;
    }

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOrganismoFin() {
        return organismoFin;
    }

    public void setOrganismoFin(String organismoFin) {
        this.organismoFin = organismoFin;
    }

    public String getUnidadAdministrativa() {
        return unidadAdministrativa;
    }

    public void setUnidadAdministrativa(String unidadAdministrativa) {
        this.unidadAdministrativa = unidadAdministrativa;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }
}
