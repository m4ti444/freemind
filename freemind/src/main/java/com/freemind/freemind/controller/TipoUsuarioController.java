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
import com.freemind.freemind.model.TipoUsuario;
import com.freemind.freemind.service.TipoUsuarioService;

public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> getAllTipoUsuario() {
        List <TipoUsuario> tipoUsuarios = tipoUsuarioService.findAll();
        if(tipoUsuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tipoUsuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> getTipoUsuarioById(@PathVariable Integer id) {
        try{
            TipoUsuario tipoUsuario = tipoUsuarioService.findById(id);
            return ResponseEntity.ok(tipoUsuario);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> saveTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return new ResponseEntity<>(tipoUsuarioService.save(tipoUsuario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> updateTipoUsuario(@PathVariable Integer id, @RequestBody TipoUsuario tipoUsuario) {
        try{
            tipoUsuarioService.save(tipoUsuario);
            return ResponseEntity.ok(tipoUsuario);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoUsuario(@PathVariable Integer id) {
        TipoUsuario existingTipoUsuario = tipoUsuarioService.findById(id);
        if (existingTipoUsuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tipoUsuarioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
