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
import com.freemind.freemind.model.Actividad;
import com.freemind.freemind.service.ActividadService;

public class ActividadController {
    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public ResponseEntity<List<Actividad>> getAllActividades() {
        List <Actividad> actividades = actividadService.findAll();
        if(actividades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(actividades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actividad> getActividadById(@PathVariable Integer id) {
        try{
            Actividad actividad = actividadService.findById(id);
            return ResponseEntity.ok(actividad);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Actividad> saveActividad(@RequestBody Actividad actividad) {
        return new ResponseEntity<>(actividadService.save(actividad), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actividad> updateActividad(@PathVariable Integer id, @RequestBody Actividad actividad) {
        try{
            actividadService.save(actividad);
            return ResponseEntity.ok(actividad);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActividad(@PathVariable Integer id) {
        Actividad existingActividad = actividadService.findById(id);
        if (existingActividad == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        actividadService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
