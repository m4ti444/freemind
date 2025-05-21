package com.freemind.freemind.service;

import java.util.List;
import com.freemind.freemind.model.UsuarioActividad;

public interface UsuarioActividadService {
    List<UsuarioActividad> findAll();
    UsuarioActividad findById(Integer id);
    UsuarioActividad save(UsuarioActividad usuarioActividad);
    void deleteById(Integer id);
    UsuarioActividad updateUsuarioActividad(UsuarioActividad usuarioActividad);
}
