package com.freemind.freemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.freemind.freemind.model.TipoActividad;
import java.util.List;

public interface TipoActividadRepository extends JpaRepository<TipoActividad, Long> {
    List<TipoActividad> findByNombre(String nombre);
}
