/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mcl.prox25_service.repository.sql;

import com.mcl.prox25_service.model.Usuarios;
import com.mcl.prox25_service.model.Usuarios_Estado;
import com.mcl.prox25_service.model.Usuarios_Estado.Status;
import java.sql.Timestamp;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lmcancela
 */
@Repository
public interface Usuarios_EstadoRepository extends JpaRepository<Usuarios_Estado, Integer> {

    //Optional<Usuarios_Estado> findByUsuarioAndStatusAndHastaIsNull(Usuarios usuario, Status status);
    
//    @Query("SELECT ue.status FROM Usuarios_Estado ue WHERE ue.usuario = :usuario")
//    String comprobarActivoUsuario(@Param("usuario") Usuarios usuario);
    
//    @Query("SELECT ue.hasta FROM Usuarios_Estado ue WHERE ue.usuario = :usuario ORDER BY ue.desde DESC")
//    Timestamp findLatestHastaByUsuario(@Param("usuario") Usuarios usuario);
    //Timestamp findFirstByUsuarioOrderByDesdeDesc(Usuarios usuario);
    @Query("SELECT ue.hasta FROM Usuarios_Estado ue WHERE ue.usuario = :usuario ORDER BY ue.desde DESC")
    Optional<Timestamp> findTopHastaByUsuarioOrderByDesdeDesc(@Param("usuario") Usuarios usuario);

}

