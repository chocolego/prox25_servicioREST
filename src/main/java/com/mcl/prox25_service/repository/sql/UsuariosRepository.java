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
    
    //Métodos de busqueda automaticos, segun parametro/field insertado
    Optional<Usuarios> findByNombreUsuario(String nombre);
    Optional<Usuarios> findByEmail(String email);

}
