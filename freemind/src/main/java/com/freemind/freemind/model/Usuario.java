package com.freemind.freemind.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length= 13, nullable=false)
    private String run;

    @Column(length = 30, nullable=false)
    private String nombres;

    @Column(length = 30, nullable=false)
    private String apellidos;

    @Column(nullable=false)
    private Date fechaNacimiento;

    @Column(length = 30, nullable=false)
    private String correo;
    
    @Column(length = 9, nullable=false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioActividad> actividades;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioInstitucion> instituciones;
}
