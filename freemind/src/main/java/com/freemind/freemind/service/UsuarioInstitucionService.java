package com.freemind.freemind.service;

import java.util.List;
import com.freemind.freemind.model.UsuarioInstitucion;

public interface UsuarioInstitucionService {
    List<UsuarioInstitucion> findAll();
    UsuarioInstitucion findById(Integer id);
    UsuarioInstitucion save(UsuarioInstitucion usuarioInstitucion);
    void deleteById(Integer id);
    UsuarioInstitucion updateUsuarioInstitucion(UsuarioInstitucion usuarioInstitucion);
}
