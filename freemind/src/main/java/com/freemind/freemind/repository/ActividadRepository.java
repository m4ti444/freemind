package com.freemind.freemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.freemind.freemind.model.Actividad;

import java.time.LocalDate;
import java.util.List;
import java.lang.Long;

@Repository
public interface ActividadRepository extends JpaRepository <Actividad, Long> {
    List<Actividad> findByFechaActividad(LocalDate fechaActividad);
    List<Actividad> findByUsuarioId(Long usuarioId);
}
