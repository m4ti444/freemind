package com.freemind.freemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.freemind.freemind.model.Usuario;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    List<Usuario> findByApellidos(String apellidos);
    Usuario findByCorreo(String correo);
    List<Usuario> findByNombresAndApellidos(String nombres, String apellidos);
}
