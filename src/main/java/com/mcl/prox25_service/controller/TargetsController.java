/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.controller;

import com.mcl.prox25_service.model.Targets;
import com.mcl.prox25_service.services.sql.TargetsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lmcancela
 */
@RestController
@RequestMapping("/targets")
public class TargetsController {

    @Autowired
    private TargetsService targetsService;
    
    @GetMapping
    public List<Targets> obtenerTodasLasTareas() {
        return targetsService.getAllTargets();
    }
    
    
    @GetMapping("/dispositivo/{id}")
    public ResponseEntity<List<Targets>> getTargetsByDispositivoId(@PathVariable Integer id) {
        List<Targets> targets = targetsService.getTargetsByDispositivoId(id);
        return ResponseEntity.ok(targets);
    }

    @PostMapping("/{targetId}/asignar/{dispositivoId}")
    public ResponseEntity<Targets> assignDispositivoToTarget(
            @PathVariable Integer targetId,
            @PathVariable Integer dispositivoId) {

        Targets updatedTarget = targetsService.assignDispositivoToTarget(targetId, dispositivoId);
        return ResponseEntity.ok(updatedTarget);
    }
    
    @PostMapping
    //@PostMapping(consumes = "application/json")
    public Targets insertarTarget(@RequestBody Targets target) {
        return targetsService.saveTarget(target);
    }

    @PutMapping("/update/{id}")
    public Targets actualizarTarget(@RequestBody Targets target) {  
        return targetsService.updateTarget(target);             
    }
    
    @DeleteMapping("/{id}")
    public void eliminarTarget(@PathVariable Integer id) {
        targetsService.deleteTarget(id);
    }
    
    @GetMapping("/nombre/{nombreTarget}")
    public Targets obtenerPorNombreTarget(@PathVariable String nombreTarget) {
        return targetsService.findByNombre(nombreTarget);
    }
    
    @GetMapping("/id/{idTarget}")
    public Targets obtenerPorIdTarget(@PathVariable Integer idTarget) {
        return targetsService.getTargetsById(idTarget);
    }

    @GetMapping("/freeTargets")
    public ResponseEntity<List<Targets>> getUnassignedTargets() {
        List<Targets> targets = targetsService.getUnassignedTargets();
        return ResponseEntity.ok(targets);
    }


//
//    @GetMapping("/dispositivo/{id}")
//    public ResponseEntity<List<Targets>> getTargetsByDispositivoId(@PathVariable Integer id) {
//        List<Targets> targets = targetsService.getTargetsByDispositivoId(id);
//        return ResponseEntity.ok(targets);
//    }

    // other endpoints...
}

