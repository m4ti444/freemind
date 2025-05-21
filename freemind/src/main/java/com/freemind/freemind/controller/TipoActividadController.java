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
import com.freemind.freemind.model.TipoActividad;
import com.freemind.freemind.service.TipoActividadService;

public class TipoActividadController {

    @Autowired
    private TipoActividadService tipoActividadService;

    @GetMapping
    public ResponseEntity<List<TipoActividad>> getAllTipoActividad() {
        List <TipoActividad> tipoActividades = tipoActividadService.findAll();
        if(tipoActividades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tipoActividades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoActividad> getTipoActividadById(@PathVariable Integer id) {
        try{
            TipoActividad tipoActividad = tipoActividadService.findById(id);
            return ResponseEntity.ok(tipoActividad);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoActividad> saveTipoActividad(@RequestBody TipoActividad tipoActividad) {
        return new ResponseEntity<>(tipoActividadService.save(tipoActividad), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoActividad> updateTipoActividad(@PathVariable Integer id, @RequestBody TipoActividad tipoActividad) {
        try{
            tipoActividadService.save(tipoActividad);
            return ResponseEntity.ok(tipoActividad);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoActividad(@PathVariable Integer id) {
        TipoActividad existingTipoActividad = tipoActividadService.findById(id);
        if (existingTipoActividad == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tipoActividadService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
