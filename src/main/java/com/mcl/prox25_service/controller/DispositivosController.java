/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.controller;

import com.mcl.prox25_service.model.Dispositivos;
import com.mcl.prox25_service.services.sql.DispositivosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lmcancela
 */

@RestController
@RequestMapping("/dispositivos")
public class DispositivosController {

    @Autowired
    private DispositivosService dispositivosService;

    @GetMapping
    public List<Dispositivos> getAllDispositivos() {
        return dispositivosService.findAll();
    }

    @GetMapping("/{idDisp}")
    public ResponseEntity<Dispositivos> getDispositivoById(@PathVariable Integer idDisp) {
        Dispositivos dispositivo = dispositivosService.findById(idDisp);
        if (dispositivo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dispositivo);
    }

    @GetMapping("/nombreDisp/{nombreDisp}")
    public ResponseEntity<Dispositivos> getDispositivoByNombre(@PathVariable String nombreDisp) {
        Dispositivos dispositivo = dispositivosService.findByNombreDispositivo(nombreDisp);
        if (dispositivo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dispositivo);
    }

    @GetMapping("/numserie/{numeroSerie}")
    public ResponseEntity<Dispositivos> getDispositivoByNumeroSerie(@PathVariable String numeroSerie) {
        Dispositivos dispositivo = dispositivosService.findByNumeroSerie(numeroSerie);
        if (dispositivo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dispositivo);
    }
}

