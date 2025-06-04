/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.services.sql;

import com.mcl.prox25_service.model.Dispositivos;
import com.mcl.prox25_service.model.Usuarios_Dispositivos;
import com.mcl.prox25_service.model.Usuarios_Dispositivos_PK;
import com.mcl.prox25_service.repository.sql.Usuarios_DispositivosRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lmcancela
 */

@Service
public class Usuarios_DispositivosService {

    @Autowired
    private Usuarios_DispositivosRepository usuariosDispositivosRepository;

    // Get all Usuarios_Dispositivos entries
    public List<Usuarios_Dispositivos> getAll() {
        return usuariosDispositivosRepository.findAll();
    }
//
//    // Get dispositivos for a user with hasta = NULL (active)
//    public List<Dispositivos> getDispositivosActivosPorUsuario(Integer idUsuario) {
//        return usuariosDispositivosRepository.findByIdUsuarioAndHastaIsNull(idUsuario)
//                .stream()
//                .map(Usuarios_Dispositivos::getDispositivo)
//                .collect(Collectors.toList());
//    }
//
//    // Get dispositivos para user con hasta != NULL (inactivo)
//    public List<Dispositivos> getDispositivosInactivosPorUsuario(Integer idUsuario) {
//        return usuariosDispositivosRepository.findByIdUsuarioAndHastaIsNotNull(idUsuario)
//                .stream()
//                .map(Usuarios_Dispositivos::getDispositivo)
//                .collect(Collectors.toList());
//    }
//
//    // Optional: get all assignments by user
//    public List<Usuarios_Dispositivos> getAsignacionesPorUsuario(Integer idUsuario) {
//        return usuariosDispositivosRepository.findByIdUsuario(idUsuario);
//    }

    
    // Get all dispositivos for a user (regardless of 'hasta')
    public List<Dispositivos> getDispositivosByUsuarioId(Integer idUsuario) {
        List<Usuarios_Dispositivos> udsList = usuariosDispositivosRepository.findById_IdUsuario(idUsuario);
        return udsList.stream()
                      .map(Usuarios_Dispositivos::getDispositivo)
                      .collect(Collectors.toList());
    }

    // Get dispositivos with hasta == null (active)
    public List<Dispositivos> getDispositivosActivosByUsuarioId(Integer idUsuario) {
        List<Usuarios_Dispositivos> udsList = usuariosDispositivosRepository.findById_IdUsuarioAndHastaIsNull(idUsuario);
        return udsList.stream()
                      .map(Usuarios_Dispositivos::getDispositivo)
                      .collect(Collectors.toList());
    }

    // Get dispositivos with hasta != null (historical)
    public List<Dispositivos> getDispositivosHistoricosByUsuarioId(Integer idUsuario) {
        List<Usuarios_Dispositivos> udsList = usuariosDispositivosRepository.findById_IdUsuarioAndHastaIsNotNull(idUsuario);
        return udsList.stream()
                      .map(Usuarios_Dispositivos::getDispositivo)
                      .collect(Collectors.toList());
    } 
    
}

