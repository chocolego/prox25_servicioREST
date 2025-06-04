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

    // Buscar todalas posicions por ID dispositivo.
    List<Posiciones> findByIdDispositivo(int idDispositivo);

    // Buscar posicions por ID dispositivo e rango datas (dende, ata)
    List<Posiciones> findByIdDispositivoAndTimestampBetween(int idDispositivo, LocalDateTime start, LocalDateTime end);

    // Eliminar posicions por ID dispositivo
    void deleteByIdDispositivo(int idDispositivo);
}
