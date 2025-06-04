/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.model;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author lmcancela
 */
@Document(collection = "posicions") 
public class Posiciones {
    
    @Id
    private String id; // MongoDB id

    @Field("id_dispositivo")
    private int idDispositivo;

    private LocalDateTime timestamp;

    // GeoJSON location, campo con coordenadas: [longitude, latitude]
    private GeoJsonPoint location;

    public Posiciones() {}

    public Posiciones(int idDispositivo, LocalDateTime timestamp, GeoJsonPoint location) {
        this.idDispositivo = idDispositivo;
        this.timestamp = timestamp;
        this.location = location;
    }

    // Getters setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Posiciones{" +
                "id='" + id + '\'' +
                ", idDispositivo=" + idDispositivo +
                ", timestamp=" + timestamp +
                ", location=" + location +
                '}';
    }
}
