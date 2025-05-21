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
import com.freemind.freemind.model.Institucion;
import com.freemind.freemind.service.InstitucionService;

public class InstitucionController {
    @Autowired
    private InstitucionService institucionService;

    @GetMapping
    public ResponseEntity<List<Institucion>> getAllInstitucion() {
        List <Institucion> instituciones = institucionService.findAll();
        if(instituciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(instituciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institucion> getInstitucionById(@PathVariable Integer id) {
        try{
            Institucion institucion = institucionService.findById(id);
            return ResponseEntity.ok(institucion);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Institucion> saveInstitucion(@RequestBody Institucion institucion) {
        return new ResponseEntity<>(institucionService.save(institucion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Institucion> updateInstitucion(@PathVariable Integer id, @RequestBody Institucion institucion) {
        try{
            institucionService.save(institucion);
            return ResponseEntity.ok(institucion);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitucion(@PathVariable Integer id) {
        Institucion existingInstitucion = institucionService.findById(id);
        if (existingInstitucion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        institucionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
