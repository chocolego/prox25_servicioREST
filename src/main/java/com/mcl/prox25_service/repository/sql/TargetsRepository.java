/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mcl.prox25_service.repository.sql;

import com.mcl.prox25_service.model.Targets;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author lmcancela
 */
public interface TargetsRepository extends JpaRepository<Targets, Integer> {
    
    // Targets asignados a dispositovo por id_dispositivo
    List<Targets> findByDispositivos_Id(Integer idDispositivo);
    
    Optional<Targets> findByNombre(String nombre);
    
    //exemplo metodo directo con query hql(JPQL)
    @Query("SELECT t FROM Targets t LEFT JOIN t.dispositivos d WHERE d IS NULL")
    List<Targets> findAllFreeTargets();

    
}

