package com.freemind.freemind.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freemind.freemind.model.Usuario;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return UsuarioRepository.findAll();
    }

    public Usuario findById(long id){
        return UsuarioRepository.getById(id);
    }

    public Usuario save(Usuario usuario){
        return UsuarioRepository.save(usuario);
    }

    public void delete(Long id){
        UsuarioRepository.deleteById(id);
    }

    public Usuario patchUsuario(Long id, Usuario parcialUsuario){
        Optional<Usuario> UsuarioOptional = usuarioRepository.findById(id);
        if (UsuarioOptional.isPresent()) {
            
            Usuario UsuarioToUpdate = usuarioOptional.get();
            
            if (parcialUsuario.getNombres() != null) {
                usuarioToUpdate.setNombres(parcialUsuario.getNombres());   
            }

            if(parcialUsuario.getApellidos() != null) {
                usuarioToUpdate.setApellidos(parcialUsuario.getApellidos());
            }

            if(parcialUsuario.getCorreo() != null) {
                usuarioToUpdate.setCorreo(parcialUsuario.getCorreo());
            }

            if(parcialUsuario.getFechaNacimiento() != null) {
                usuarioToUpdate.setFechaNacimiento(parcialUsuario.getFechaNacimiento());
            }

            return usuarioRepository.save(usuarioToUpdate);
        } else {
            return null; // or throw an exception
        }
    }
}