/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mcl.prox25_service.services.sql;

import com.mcl.prox25_service.model.Usuarios;
import com.mcl.prox25_service.model.Usuarios_Estado;
import com.mcl.prox25_service.model.Usuarios_Estado.Status;
import com.mcl.prox25_service.repository.sql.UsuariosRepository;
import com.mcl.prox25_service.repository.sql.Usuarios_EstadoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lmcancela
 */
@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private Usuarios_EstadoRepository usuariosEstadoRepository;
//    @Autowired
//    private TareasRepository tareasRepository;

    public List<Usuarios> obtenerTodolosUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuarios obtenerUsuarioPorId(Integer id) {
        return usuariosRepository.findById(id).orElse(null);
    }
    
    
    public Usuarios obtenerUsuarioPorNombre(String nombre) {
    Optional<Usuarios> optionalUsuario = usuariosRepository.findByNombreUsuario(nombre);

    if (optionalUsuario.isPresent()) {
        Usuarios usuario = optionalUsuario.get();
        return usuario;
    }
    return null;    
    }
    
    public Usuarios obtenerUsuarioPorEmail(String email) {
    return usuariosRepository.findByEmail(email).orElse(null);
}    


    public Usuarios guardarUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }
    
    public boolean isUsuarioActivo(Usuarios usuario) {
        String status = usuariosEstadoRepository.comprobarActivoUsuario(usuario);
        return "activo".equalsIgnoreCase(status);
    }
    
    public boolean autenticarUsuario(String user, String pass) {
    Optional<Usuarios> optionalUsuario = usuariosRepository.findByNombreUsuario(user);

    if (optionalUsuario.isPresent()) {
        Usuarios usuario = optionalUsuario.get();        
       
        if (usuario != null && usuario.getContrasena().equals(pass)) {
            return true;
        }
    }
    return false;
}
    
    public Usuarios updateUsuario(Usuarios usuario) {
    return usuariosRepository.save(usuario);
    }
    
    public void deleteUsuario(Integer id) {
        usuariosRepository.deleteById(id);
    }
    
    
//    public boolean iniciarTareaUsuario(Integer idTarea, Integer userId){
//       Optional<Usuarios> optionalUsuario = usuariosRepository.findById(userId);
//       Optional<Tareas> optionalTarea = tareasRepository.findById(idTarea);
//       
//       if (optionalUsuario.isPresent() && optionalTarea.isPresent()) {
//            Usuarios usuario = optionalUsuario.get();
//            Tareas tarea = optionalTarea.get();
//            usuario.getTareas().add(tarea);
//            usuariosRepository.save(usuario);
//            return true;
//        }
//       return false;   
//    }
    
//       public boolean completarTareaUsuario(Integer idTarea, Integer userId){
//       Optional<Usuarios> optionalUsuario = usuariosRepository.findById(userId);
//       Optional<Tareas> optionalTarea = tareasRepository.findById(idTarea);
//       
//       if (optionalUsuario.isPresent() && optionalTarea.isPresent()) {
//            Usuarios usuario = optionalUsuario.get();
//            Tareas tarea = optionalTarea.get();
//            usuario.setPuntos_totales(usuario.getPuntos_totales() + 
//                    tarea.getPuntos_tarea());
//            usuariosRepository.save(usuario);
//            tarea.setEstado("completada");
//            tareasRepository.save(tarea);
//            return true;
//        }
//       return false;   
//    }
    
}
