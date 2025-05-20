package com.freemind.freemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.freemind.freemind.model.UsuarioInstitucion;
import java.util.List;

@Repository
public interface UsuarioInstitucionRepository extends JpaRepository<UsuarioInstitucion, Long>{
    List<UsuarioInstitucion> findByUsuarioId(Long usuarioId);
    List<UsuarioInstitucion> findByInstitucionId(Long institucionId);
}
