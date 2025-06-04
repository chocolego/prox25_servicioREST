/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.model;

/**
 *
 * @author lmcancela
 */
import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios_Dispositivos")
public class Usuarios_Dispositivos {

    @EmbeddedId
    private Usuarios_Dispositivos_PK id;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    @ManyToOne
    @MapsId("idDispositivo")
    @JoinColumn(name = "id_dispositivo")
    private Dispositivos dispositivo;

    @Column(name = "hasta")
    private Timestamp hasta;

    @Column(name = "asignado_por")
    private Integer asignadoPor;

    // Constructores

    public Usuarios_Dispositivos() {}

    public Usuarios_Dispositivos(Usuarios_Dispositivos_PK id, Usuarios usuario, Dispositivos dispositivo, Timestamp hasta, Integer asignadoPor) {
        this.id = id;
        this.usuario = usuario;
        this.dispositivo = dispositivo;
        this.hasta = hasta;
        this.asignadoPor = asignadoPor;
    }

    public Usuarios_Dispositivos(Usuarios_Dispositivos_PK id, Usuarios usuario, Dispositivos dispositivo, Timestamp hasta) {
        this.id = id;
        this.usuario = usuario;
        this.dispositivo = dispositivo;
        this.hasta = hasta;
    }

    // Getters and setters

    public Usuarios_Dispositivos_PK getId() {
        return id;
    }

    public void setId(Usuarios_Dispositivos_PK id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Dispositivos getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivos dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Timestamp getHasta() {
        return hasta;
    }

    public void setHasta(Timestamp hasta) {
        this.hasta = hasta;
    }

    public Integer getAsignadoPor() {
        return asignadoPor;
    }

    @Override
    public String toString() {
        return "Usuarios_Dispositivos{" + "id=" + id + ", usuario=" + usuario + ", dispositivo=" + dispositivo + ", hasta=" + hasta + ", asignadoPor=" + asignadoPor + '}';
    }
    
    
}

