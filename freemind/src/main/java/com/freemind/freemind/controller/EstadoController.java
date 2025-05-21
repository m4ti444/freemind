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
import org.springframework.web.bind.annotation.RequestMapping;

import com.freemind.freemind.model.Estado;
import com.freemind.freemind.service.EstadoService;

@RestController
@RequestMapping("/api/v1/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> getAllEstado() {
        List <Estado> estados = estadoService.findAll();
        if(estados.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable Integer id) {
        try{
            Estado estado = estadoService.findById(id);
            return ResponseEntity.ok(estado);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Estado> saveEstado(@RequestBody Estado estado) {
        return new ResponseEntity<>(estadoService.save(estado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> updateEstado(@PathVariable Integer id, @RequestBody Estado estado) {
        try{
            estadoService.save(estado);
            return ResponseEntity.ok(estado);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Integer id) {
        Estado existingEstado = estadoService.findById(id);
        if (existingEstado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        estadoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
