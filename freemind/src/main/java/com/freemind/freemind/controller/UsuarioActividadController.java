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
import com.freemind.freemind.model.UsuarioActividad;
import com.freemind.freemind.service.UsuarioActividadService;



public class UsuarioActividadController {
     @Autowired
    private UsuarioActividadService usuarioActividadService;

    @GetMapping
    public ResponseEntity<List<UsuarioActividad>> getAllUsuarioActividad() {
        List <UsuarioActividad> usuarioActividades = usuarioActividadService.findAll();
        if(usuarioActividades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarioActividades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioActividad> getUsuarioActividadById(@PathVariable Integer id) {
        try{
            UsuarioActividad usuarioActividad = usuarioActividadService.findById(id);
            return ResponseEntity.ok(usuarioActividad);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioActividad> saveUsuarioActividad(@RequestBody UsuarioActividad usuarioActividad) {
        return new ResponseEntity<>(usuarioActividadService.save(usuarioActividad), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioActividad> updateUsuarioActividad(@PathVariable Integer id, @RequestBody UsuarioActividad usuarioActividad) {
        try{
            usuarioActividadService.save(usuarioActividad);
            return ResponseEntity.ok(usuarioActividad);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioActividad(@PathVariable Integer id) {
        UsuarioActividad existingUsuarioActividad = usuarioActividadService.findById(id);
        if (existingUsuarioActividad == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioActividadService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
