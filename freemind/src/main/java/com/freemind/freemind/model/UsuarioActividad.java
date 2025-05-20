package com.freemind.freemind.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "usuario_actividad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "actividad_id", nullable = false)
    private Actividad actividad;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;
}
