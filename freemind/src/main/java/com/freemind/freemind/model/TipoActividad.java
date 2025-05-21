package com.freemind.freemind.model;

import jakarta.persistence.JoinColumn;

import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipoActividad")
public class TipoActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private ZonedDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "actividad_id")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Actividad actividad;   
}
