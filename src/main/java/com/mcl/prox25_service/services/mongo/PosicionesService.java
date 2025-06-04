/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.services.mongo;

import com.mcl.prox25_service.model.Posiciones;
import com.mcl.prox25_service.repository.mongo.PosicionesRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lmcancela
 */
@Service
public class PosicionesService {

    @Autowired
    private PosicionesRepository posicionRepository;

    // GET Todalas posicions filtrando por IDDispositivo
    public List<Posiciones> getPosicionesporIdDisp(int dispId) {
        return posicionRepository.findByIdDispositivo(dispId);
    }

    // Get posicions filtrando por IDDispositivo e rango datas
    public List<Posiciones> buscarFiltrandoporFechas(int dispId, LocalDateTime desde, LocalDateTime hasta) {
        return posicionRepository.findByIdDispositivoAndTimestampBetween(dispId, desde, hasta);
    }

    // nova posicion
    public Posiciones insertarPos(Posiciones posicion) {
        return posicionRepository.save(posicion);
    }

    // Uso opcional (por agora non necesario)
    public void borrarPosicionesdeDispositivo(int dispId) {
        posicionRepository.deleteByIdDispositivo(dispId);
    }
}

