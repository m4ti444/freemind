package com.freemind.freemind.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "actividad")
@Data
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo_actividad;
    private int fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Usuario tipoUsuario;

    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<TipoActividad> tipoActividad;

    public Long getUsuarioId() {
        return tipoUsuario != null ? tipoUsuario.getId() : null;
    }

    public void setUsuarioId(Long usuarioId) {
        if (tipoUsuario == null){
            tipoUsuario = new Usuario();

        }
        tipoUsuario.setId(usuarioId);
    }
}
