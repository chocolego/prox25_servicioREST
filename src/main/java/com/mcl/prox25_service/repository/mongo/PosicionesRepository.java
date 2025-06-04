/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mcl.prox25_service.repository.mongo;

/**
 *
 * @author lmcancela
 */
import com.mcl.prox25_service.model.Posiciones;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PosicionesRepository extends MongoRepository<Posiciones, String> {

    // Find all positions by device ID
    List<Posiciones> findByIdDispositivo(int idDispositivo);

    // Find all positions by device ID and timestamp between start and end dates
    List<Posiciones> findByIdDispositivoAndTimestampBetween(int idDispositivo, LocalDateTime start, LocalDateTime end);

    // Delete positions by device ID (optional)
    void deleteByIdDispositivo(int idDispositivo);
}
