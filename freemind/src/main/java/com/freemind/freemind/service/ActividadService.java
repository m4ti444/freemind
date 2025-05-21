package com.freemind.freemind.service;

import java.util.List;
import com.freemind.freemind.model.Actividad;

public interface ActividadService {
    List<Actividad> findAll();
    Actividad findById(Integer id);
    Actividad save(Actividad actividad);
    void deleteById(Integer id);
    Actividad updateActividad(Actividad actividad);
}


