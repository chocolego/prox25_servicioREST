/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mcl.prox25_service.repository.sql;

import com.mcl.prox25_service.model.Usuarios_Dispositivos;
import com.mcl.prox25_service.model.Usuarios_Dispositivos_PK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lmcancela
 */
public interface Usuarios_DispositivosRepository extends JpaRepository<Usuarios_Dispositivos, Usuarios_Dispositivos_PK> {

    List<Usuarios_Dispositivos> findById_IdUsuario(Integer idUsuario);

    List<Usuarios_Dispositivos> findById_IdUsuarioAndHastaIsNull(Integer idUsuario);

    List<Usuarios_Dispositivos> findById_IdUsuarioAndHastaIsNotNull(Integer idUsuario);
}

