package com.freemind.freemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.freemind.freemind.model.Institucion;
import java.util.List;


public interface InstitucionRepository extends JpaRepository<Institucion, Long> {
    @Query(""" 
        SELECT s, s.configuracion.notificaciones_activadas, s.institucion.nombre FROM Sucursal s
        """)
    List<Object[]> findInstitcuionConConfigYInsti();
}
