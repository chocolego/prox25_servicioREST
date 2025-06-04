package com.mcl.prox25_service.repository.sql;

import com.mcl.prox25_service.model.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lmcancela
 */
@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    
    //
    //Cualquier método declarado aquí que empiece por "findBy..."
    //seguido de como llames
    //tu a un determinado campo en tu entidad, 
    //en este caso el campo "nombre" de la entidad "Usuarios",
    //va a generar automáticamente una consulta hacia ese campo
    Optional<Usuarios> findByNombreUsuario(String nombre);
    Optional<Usuarios> findByEmail(String email);

}
