package com.freemind.freemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.freemind.freemind.model.Institucion;
import com.freemind.freemind.model.UsuarioInstitucion;

import java.util.List;


public interface InstitucionRepository extends JpaRepository<Institucion, Long> {
    List<Institucion> findByNombre(String nombre);
    List<Institucion> findById(Integer id);

    @Query("SELECT new com.freemind.freemind.model.UsuarioInstitucion(u.nombre, i.nombre, 'Alumno') " +
        "FROM Usuario u " +
        "JOIN u.tipoUsuario tu " +
        "JOIN u.institucion i " +
        "WHERE tu.nombre = 'Alumno'")
    List<UsuarioInstitucion> findAlumnos();

}
