package com.freemind.freemind.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.freemind.freemind.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository <TipoUsuario, Long> {
    List<TipoUsuario> findByNombre(String nombre);

}
