/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.controller;

import com.mcl.prox25_service.model.Posiciones;
import com.mcl.prox25_service.services.mongo.PosicionesService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lmcancela
 */
@RestController
@RequestMapping("/posiciones")
public class PosicionesController {

    @Autowired
    private PosicionesService posicionesService;

    // 1) Get all positions for a device (no date filtering)
    @GetMapping("/device/{id_dispositivo}/all")
    public ResponseEntity<List<Posiciones>> getAllPositionsByDevice(@PathVariable int id_dispositivo) {
        List<Posiciones> posiciones = posicionesService.getPosicionesporIdDisp(id_dispositivo);
        if (posiciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(posiciones);
    }
    
     // 2) Get positions filtered by date range
    @GetMapping("/device/{dispId}/filtered")
    public ResponseEntity<List<Posiciones>> posicionesporDispIdRangoFechas(
            @PathVariable int dispId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
        
        List<Posiciones> posiciones = posicionesService.buscarFiltrandoporFechas(dispId, desde, hasta);
        
        if (posiciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(posiciones);
    }
    

    // Insert a new position entry
    @PostMapping
    public ResponseEntity<Posiciones> nuevaPosicion(@RequestBody Posiciones posicion) {
        Posiciones created = posicionesService.insertarPos(posicion);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

//    // Optional: get all positions (maybe limited)
//    @GetMapping
//    public ResponseEntity<List<Posiciones>> getAllPositions() {
//        List<Posiciones> allPositions = posicionesService.getAll();
//        return ResponseEntity.ok(allPositions);
//    }
}

