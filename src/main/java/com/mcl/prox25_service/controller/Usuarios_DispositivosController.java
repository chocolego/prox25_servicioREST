/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.controller;

import com.mcl.prox25_service.model.Dispositivos;
import com.mcl.prox25_service.services.sql.DispositivosService;
import com.mcl.prox25_service.services.sql.UsuariosService;
import com.mcl.prox25_service.services.sql.Usuarios_DispositivosService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lmcancela
 */
@RestController
@RequestMapping("/dispositivos")
public class Usuarios_DispositivosController {

    @Autowired
    private Usuarios_DispositivosService usuariosDispositivosService;
    @Autowired
    private UsuariosService usuariosService;
    
     @GetMapping("/usuarios/{usuarioId}/dispositivos")
    public ResponseEntity<List<Dispositivos>> getDispositivosByUsuario(@PathVariable Integer usuarioId) {
        List<Dispositivos> dispositivos = usuariosDispositivosService.getDispositivosByUsuarioId(usuarioId);
        return ResponseEntity.ok(dispositivos); // always returns 200 with list (empty if none)
    }
    
//     @GetMapping("/usuarios/{usuarioId}/dispositivos")
//    public Set<Dispositivos> getDispositivosByUsuario(@PathVariable Integer usuarioId) {
//        return usuariosService.obtenerUsuarioPorId(usuarioId).getDispostivosAsignados(); // always returns 200 with list (empty if none)
//    }

    @GetMapping("/usuarios/{usuarioId}/dispositivos/activos")
    public ResponseEntity<List<Dispositivos>> getDispositivosActivosByUsuario(@PathVariable Integer usuarioId) {
        List<Dispositivos> dispositivos = usuariosDispositivosService.getDispositivosActivosByUsuarioId(usuarioId);
        return ResponseEntity.ok(dispositivos);
    }

    @GetMapping("/usuario/{usuarioId}/dispositivos/inactivos")
    public ResponseEntity<List<Dispositivos>> getDispositivosHistoricosByUsuario(@PathVariable Integer usuarioId) {
        List<Dispositivos> dispositivos = usuariosDispositivosService.getDispositivosHistoricosByUsuarioId(usuarioId);
        return ResponseEntity.ok(dispositivos);
    }

    @GetMapping("/usuarios/{usuarioId}/dispositivos/libres")
    public ResponseEntity<List<Dispositivos>> getDispositivosSinTargetsByUsuario(@PathVariable Integer usuarioId) {
        List<Dispositivos> dispositivos = usuariosDispositivosService.getDispositivosSinTargetsByUsuarioId(usuarioId);
        return ResponseEntity.ok(dispositivos);
    }


//    @GetMapping("/usuarios/{id}/activos")
//    public ResponseEntity<List<Dispositivos>> getDispositivosActivos(@PathVariable Integer id) {
//        return ResponseEntity.ok(usuariosDispositivosService.getDispositivosActivosPorUsuario(id));
//    }
//
//    @GetMapping("/usuarios/{id}/historicos")
//    public ResponseEntity<List<Dispositivos>> getDispositivosHistoricos(@PathVariable Integer id) {
//        return ResponseEntity.ok(usuariosDispositivosService.getDispositivosInactivosPorUsuario(id));
//    }
}