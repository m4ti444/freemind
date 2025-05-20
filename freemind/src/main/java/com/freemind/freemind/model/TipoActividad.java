package com.freemind.freemind.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import java.util.List;
import java.util.concurrent.atomic.LongAdder;

@Entity
@Table(name = "tipoActividad")
public class TipoActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fecha;
    private String hora;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "veterinaria_id")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Institucion institucion;

    @ManyToOne
    @JoinColumn(name = "UsuarioActividad_id")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private UsuarioActividad usuarioActividad;

    @ManyToOne
    @JoinColumn(name ="actividad_id")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Actividad actividad;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getFecha(){
        return fecha;
    }

    public void setFecha (String fecha){
        this.fecha = fecha;
    }

    public String getHora(){
        return hora;
    }

    public void setHora(String hora){
        this.hora = hora;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario (Usuario usuario){
        this.usuario = usuario;
    }

    public Institucion getInstitucion(){
        return institucion;
    }

    public void setInstitucion (Institucion institucion){
        this.institucion = institucion;
    }

    public  UsuarioActividad getUsuarioActividad (){
        return usuarioActividad;
    }

    public void setUsuarioActividad(UsuarioActividad usuarioActividad){
        this.usuarioActividad = usuarioActividad;
    }

    public Actividad geActividad(){
        return actividad;
    }

    public void setActividad (Actividad actividad){
        this.actividad = actividad;
    }

    public Long getUsuarioId(){
        return usuario != null ? usuario.getId() : null;
    }

    public void setUsuarioId(Long usuarioId){
        if (usuario == null){
            usuario = new Usuario();
        }
        usuario.setId(usuarioId);
    }

    public Long getInstitucionId() {
        return institucion != null ? institucion.getId() : null;
    }
    
    public void setInstitucionId(Long institucionId) {
        if (institucion == null) {
            institucion = new Institucion();
        }
        institucion.setId(institucionId);
    }

    public Long getUsuarioActividadId() {
        return usuarioActividad != null ? usuarioActividad.getId() : null;
    }
    
    public void setUsuarioActividadId(Long usuarioActividadId) {
        if (usuarioActividad  == null) {
            usuarioActividad = new UsuarioActividad();
        }
        usuarioActividad.setId(usuarioActividadId);
    }

}
