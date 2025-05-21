package com.freemind.freemind.service;

import java.util.List;
import com.freemind.freemind.model.TipoUsuario;

public interface TipoUsuarioService {
    List<TipoUsuario> findAll();
    TipoUsuario findById(Integer id);
    TipoUsuario save(TipoUsuario tipoUsuario);
    void deleteById(Integer id);
    TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario);
}
