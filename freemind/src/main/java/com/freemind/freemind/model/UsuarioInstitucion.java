package com.freemind.freemind.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "usuario_institucion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInstitucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "institucion_id", nullable = false)
    private Institucion institucion;
}
