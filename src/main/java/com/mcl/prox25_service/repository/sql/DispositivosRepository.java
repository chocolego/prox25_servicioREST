/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mcl.prox25_service.repository.sql;

import com.mcl.prox25_service.model.Dispositivos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lmcancela
 */
public interface DispositivosRepository extends JpaRepository<Dispositivos, Integer> {

    Optional<Dispositivos> findByNombreDispositivo(String nombreDispositivo);

    Optional<Dispositivos> findByNumeroSerie(String numeroSerie);
}

