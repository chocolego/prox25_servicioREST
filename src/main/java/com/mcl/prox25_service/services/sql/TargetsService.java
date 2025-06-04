/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.services.sql;

import com.mcl.prox25_service.model.Dispositivos;
import com.mcl.prox25_service.model.Targets;
import com.mcl.prox25_service.repository.sql.DispositivosRepository;
import com.mcl.prox25_service.repository.sql.TargetsRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author lmcancela
 */
@Service
public class TargetsService {

    @Autowired
    private DispositivosRepository dispositivosRepository;
    
    @Autowired
    private TargetsRepository targetsRepository;
    
    
    public List<Targets> getAllTargets() {
        return targetsRepository.findAll();
    }
    
    public Targets getTargetsById(Integer id) {
        return targetsRepository.findById(id).orElse(null);
    }

    public List<Targets> getTargetsByDispositivoId(Integer id) {
        return targetsRepository.findByDispositivos_Id(id);
    }
    
    public Targets assignDispositivoToTarget(Integer targetId, Integer dispositivoId) {
    Targets target = targetsRepository.findById(targetId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Target no encontrado con id: " + targetId));

    Dispositivos dispositivo = dispositivosRepository.findById(dispositivoId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dispositivo no encontrado con id: " + dispositivoId));

    // Check si target está asignado
    if (!target.getDispositivos().isEmpty()) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Este target ya tiene dispositivo asignado.");
    }

        // Check dispositivo está asignado
        if (target.getDispositivos().contains(dispositivo)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Dispositivo ya asignado a otro target.");
        }

        // asignar
        target.getDispositivos().add(dispositivo);
        dispositivo.getTargets().add(target);

        return targetsRepository.save(target);
    }

    public Targets findByNombre(String nombreTarget) {
        Optional<Targets> optionalTarget = targetsRepository.findByNombre(nombreTarget);

        if (optionalTarget.isPresent()) {
            Targets target = optionalTarget.get();
            return target;
        }
        return null;
    }
    
    public List<Targets> getUnassignedTargets() {
    return targetsRepository.findAllFreeTargets();
}

    public Targets saveTarget(Targets target) {
        return targetsRepository.save(target);
    }
    
    public Targets updateTarget(Targets target) {
         return targetsRepository.save(target);
    }

    public void deleteTarget(Integer id) {
        targetsRepository.deleteById(id);
    }


//    public List<Targets> getTargetsByDispositivoId(Integer id) {
//    return dispositivosRepository.findById(id)
//        .map(dispositivo -> new ArrayList<>(dispositivo.getTargets()))
//        .orElseGet(ArrayList::new);}

    
//public Targets assignDispositivoToTarget(Integer targetId, Integer dispositivoId) {
//    Targets target = targetsRepository.findById(targetId)
//        .orElseThrow(() -> new RuntimeException("Target not found"));
//
//    Dispositivos dispositivo = dispositivosRepository.findById(dispositivoId)
//        .orElseThrow(() -> new RuntimeException("Dispositivo not found"));
//
//    target.setDispositivo(dispositivo);
//    return targetsRepository.save(target);
//}
    


    // other target methods...

    
}
