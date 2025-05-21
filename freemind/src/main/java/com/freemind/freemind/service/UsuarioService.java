package com.freemind.freemind.service;

import java.util.List;
import com.freemind.freemind.model.Usuario;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(Integer id);
    Usuario save(Usuario usuario);
    void deleteById(Integer id);
    Usuario updateUsuario(Usuario usuario);
    Usuario patchUsuario(Usuario usuario);
}
