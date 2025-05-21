package com.freemind.freemind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.freemind.freemind.model.Usuario;
import com.freemind.freemind.model.UsuarioInstitucion;
import com.freemind.freemind.service.UsuarioInstitucionService;



public class UsuarioInstitucionController {
    @Autowired
    private UsuarioInstitucionService usuarioInstitucionService;

    @GetMapping
    public ResponseEntity<List<UsuarioInstitucion>> getAllUsuarioInstitucion() {
        List <UsuarioInstitucion> usuarioInstituciones = usuarioInstitucionService.findAll();
        if(usuarioInstituciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarioInstituciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioInstitucion> getUsuarioInstitucionById(@PathVariable Integer id) {
        try{
            UsuarioInstitucion usuarioInstitucion = usuarioInstitucionService.findById(id);
            return ResponseEntity.ok(usuarioInstitucion);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioInstitucion> saveUsuarioInstitucion(@RequestBody UsuarioInstitucion usuarioInstitucion) {
        return new ResponseEntity<>(usuarioInstitucionService.save(usuarioInstitucion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioInstitucion> updateUsuarioInstitucion(@PathVariable Integer id, @RequestBody UsuarioInstitucion usuarioInstitucion) {
        try{
            usuarioInstitucionService.save(usuarioInstitucion);
            return ResponseEntity.ok(usuarioInstitucion);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioInstitucion(@PathVariable Integer id) {
        UsuarioInstitucion existingUsuarioInstitucion = usuarioInstitucionService.findById(id);
        if (existingUsuarioInstitucion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioInstitucionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
