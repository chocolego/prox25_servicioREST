/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.services.sql;

import com.mcl.prox25_service.model.Dispositivos;
import com.mcl.prox25_service.model.Targets;
import com.mcl.prox25_service.repository.sql.DispositivosRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lmcancela
 */
@Service
public class DispositivosService {

    @Autowired
    private DispositivosRepository dispositivosRepository;

    public List<Dispositivos> findAll() {
        return dispositivosRepository.findAll();
    }

    public Dispositivos findById(Integer id) {
        return dispositivosRepository.findById(id).orElse(null);
    }

    public Dispositivos findByNombreDispositivo(String nombreDispositivo) {
        return dispositivosRepository.findByNombreDispositivo(nombreDispositivo).orElse(null);
    }

    public Dispositivos findByNumeroSerie(String numeroSerie) {
        return dispositivosRepository.findByNumeroSerie(numeroSerie).orElse(null);
    }
    public Set<Targets> getTargetsByDispositivoId(Integer id) {
    Optional<Dispositivos> dispositivoOpt = dispositivosRepository.findById(id);
    return dispositivoOpt.map(Dispositivos::getTargets).orElse(Collections.emptySet());
    }

}

