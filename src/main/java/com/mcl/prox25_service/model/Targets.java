/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lmcancela
 */

@Entity
@Table(name = "Targets")
public class Targets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_target")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_target", nullable = false)//('vehiculo', 'animal', 'otro')
    private TipoTarget tipoTarget;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    public enum TipoTarget {
        vehiculo, animal, otro
    }

    @ManyToMany
    //@JsonBackReference(value = "dispositivos-targets")
    @JsonIgnore  //evitar bucles autoreferencia
    @JoinTable(
            name = "Dispositivo_Target",
            joinColumns = @JoinColumn(name = "id_target"),
            inverseJoinColumns = @JoinColumn(name = "id_dispositivo")
    )
    private Set<Dispositivos> dispositivos = new HashSet<>();

    
    public Targets() {
    }

    public Targets(Integer id, TipoTarget tipoTarget, String nombre, String descripcion) {
        this.id = id;
        this.tipoTarget = tipoTarget;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoTarget getTipoTarget() {
        return tipoTarget;
    }

    public void setTipoTarget(TipoTarget tipoTarget) {
        this.tipoTarget = tipoTarget;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Dispositivos> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(Set<Dispositivos> dispositivos) {
        this.dispositivos = dispositivos;
    }
    

    @Override
    public String toString() {
        return "Targets{" + "id=" + id + ", tipoTarget=" + tipoTarget + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
}
