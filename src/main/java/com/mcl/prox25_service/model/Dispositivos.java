/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lmcancela
 */

@Entity
@Table(name = "Dispositivos")
public class Dispositivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dispositivo")
    private Integer id;

    @Column(name = "nombre_dispositivo", nullable = false, unique = true, length = 100)
    private String nombreDispositivo;

    @Column(name = "numero_serie", nullable = false, unique = true, length = 100)
    private String numeroSerie;

    @Column(name = "modelo", length = 100)
    private String modelo;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private Timestamp fechaCreacion;

    // RELACIÓN: creado_por → Usuarios
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creado_por")
    @JsonIgnore  // json no serializar 'creadoPor'
    private Usuarios creadoPor;

    @ManyToMany(mappedBy = "dispositivos")
    //@JsonManagedReference(value = "dispositivos-targets")
    private Set<Targets> targets = new HashSet<>();


    // --- Constructores ---

    public Dispositivos() {}

    public Dispositivos(String nombreDispositivo, String numeroSerie, String modelo, Usuarios creadoPor) {
        this.nombreDispositivo = nombreDispositivo;
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.creadoPor = creadoPor;
    }

    // --- Getters and Setters ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public void setNombreDispositivo(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuarios getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Usuarios creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Set<Targets> getTargets() {
        return targets;
    }

    public void setTargets(Set<Targets> targets) {
        this.targets = targets;
    }
    
    

    @Override
    public String toString() {
        return "Dispositivos{" + "id=" + id + ", nombreDispositivo=" + nombreDispositivo + ", numeroSerie=" + numeroSerie + ", modelo=" + modelo + ", fechaCreacion=" + fechaCreacion + '}';
    }
    
    
}


