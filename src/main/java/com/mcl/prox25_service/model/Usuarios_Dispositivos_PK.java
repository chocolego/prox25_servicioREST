/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author lmcancela
 */
@Embeddable
public class Usuarios_Dispositivos_PK implements Serializable {

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_dispositivo")
    private Integer idDispositivo;

    @Column(name = "desde")
    private Timestamp desde;

    // Required: default constructor
    public Usuarios_Dispositivos_PK() {}

    // Optional: constructor with fields
    public Usuarios_Dispositivos_PK(Integer idUsuario, Integer idDispositivo, Timestamp desde) {
        this.idUsuario = idUsuario;
        this.idDispositivo = idDispositivo;
        this.desde = desde;
    }

    // Required: equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuarios_Dispositivos_PK)) return false;
        Usuarios_Dispositivos_PK that = (Usuarios_Dispositivos_PK) o;
        return Objects.equals(idUsuario, that.idUsuario) &&
               Objects.equals(idDispositivo, that.idDispositivo) &&
               Objects.equals(desde, that.desde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idDispositivo, desde);
    }

    // Getters and setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public Timestamp getDesde() {
        return desde;
    }

    @Override
    public String toString() {
        return "Usuarios_Dispositivos_PK{" + "idUsuario=" + idUsuario + ", idDispositivo=" + idDispositivo + ", desde=" + desde + '}';
    }
    
    
    
    
}

