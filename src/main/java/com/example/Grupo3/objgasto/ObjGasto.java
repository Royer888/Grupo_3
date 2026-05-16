package com.example.Grupo3.objgasto;

import jakarta.persistence.*;

@Entity
@Table(name = "objgasto")
public class ObjGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gestion", nullable = false)
    private Integer gestion;

    @Column(name = "partida", length = 5, nullable = false)
    private String partida;

    @Column(name = "descrip", length = 50, nullable = false)
    private String descrip;

    public ObjGasto() {}

    public ObjGasto(Integer gestion, String partida, String descrip) {
        this.gestion = gestion;
        this.partida = partida;
        this.descrip = descrip;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getGestion() { return gestion; }
    public void setGestion(Integer gestion) { this.gestion = gestion; }
    public String getPartida() { return partida; }
    public void setPartida(String partida) { this.partida = partida; }
    public String getDescrip() { return descrip; }
    public void setDescrip(String descrip) { this.descrip = descrip; }
}
