package com.freemind.freemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.freemind.freemind.model.UsuarioActividad;
import java.util.List;

@Repository
public interface UsuarioActividadRepository extends JpaRepository <UsuarioActividad, Long> {
    List<UsuarioActividad> findByUsuarioId(Long usuarioId);
    List<UsuarioActividad> findByActividadId(Long actividadId);
}
