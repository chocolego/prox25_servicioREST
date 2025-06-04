/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.controller;

import com.mcl.prox25_service.model.Roles;
import com.mcl.prox25_service.model.Usuarios;
import com.mcl.prox25_service.repository.sql.UsuariosRepository;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mcl.prox25_service.services.sql.UsuariosService;

/**
 *
 * @author lmcancela
 */
@RestController
//@RequestMapping("/api/usuarios")
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public List<Usuarios> obtenerTodosLosUsuarios() {
        return usuariosService.obtenerTodolosUsuarios();
    }

    @GetMapping("/{id}")
    public Usuarios obtenerUsuarioPorId(@PathVariable Integer id) {
        return usuariosService.obtenerUsuarioPorId(id);
    }
    
//    @GetMapping("/tareas/{userId}")
//    public Set<Tareas> obtenerTareasUsuario(@PathVariable Integer userId) {
//        
//        return usuariosService.buscarUsuarioPorId(userId).getTareas();
//    }

    @PostMapping
    public Usuarios guardarUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.guardarUsuario(usuario);
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> guardarUsuario(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("user");
        String password = loginRequest.get("pass");
        String email = loginRequest.get("email");

        if (username == null || password == null || email == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Faltan campos obligatorios: user, pass o email.");
        }

        // Check si username o email ya existe
        if (usuariosService.obtenerUsuarioPorNombre(username) != null) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Nombre de usuario ya está en uso.");
        }

        if (usuariosService.obtenerUsuarioPorEmail(email) != null) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Email ya está en uso.");
        }
 
        Roles rol = new Roles();
        rol.setId(2);  // id referencia por defecto, por ahora siempre será 2 (usuario estandar)
        

        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario(username);
        usuario.setContrasena(password);
        usuario.setEmail(email);
        usuario.setRol(rol);

        usuariosService.guardarUsuario(usuario);
        return ResponseEntity.ok("Usuario registrado correctamente.");
    }

    
//    @PostMapping("/register")
//    public ResponseEntity<String> guardarUsuario(@RequestBody Map<String,String> loginRequest) {
//        Usuarios usuario = new Usuarios();
//        usuario.setNombreUsuario(loginRequest.get("user"));
//        usuario.setContrasena(loginRequest.get("pass"));
//        
//        if(usuariosService.obtenerUsuarioPorNombre(loginRequest.get("user")) == null){
//            usuariosService.guardarUsuario(usuario);
//            return ResponseEntity.ok("Usuario registrado!");
//        }else{
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuario actualmente registrado.");
//        }
//
//    }

    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String,String> loginRequest) {
        boolean isAuthenticated = usuariosService.autenticarUsuario(loginRequest.get("user"), loginRequest.get("pass"));
        if (isAuthenticated) {
            Usuarios usuario = usuariosService.obtenerUsuarioPorNombre(loginRequest.get("user"));
            //Usuarios usuario = usuariosService.obtenerUsuarioPorEmail(loginRequest.get("user"));
            return ResponseEntity.ok(usuario.getId().toString());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error en el login.");
        }
    }

    @GetMapping("/nombre/{nombreUsuario}")
    public Usuarios obtenerPorNombreUsuario(@PathVariable String nombreUsuario) {
        return usuariosService.obtenerUsuarioPorNombre(nombreUsuario);
    }

//    @GetMapping("/{id}")
//    public Usuarios getUsuarioById(@PathVariable Integer id) {
//        return usuarioRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
//    }

    @PutMapping("/{id}")
    public Usuarios updateUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.updateUsuario(usuario);        
    }

    @DeleteMapping("/{id}")
    public String deleteUsuario(@PathVariable Integer id) {
        usuariosService.deleteUsuario(id);
        return "Usuario eliminado con id " + id;
    }
}