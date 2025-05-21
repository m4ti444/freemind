package com.freemind.freemind.service;

import java.util.List;
import com.freemind.freemind.model.TipoActividad;

public interface TipoActividadService {
    List<TipoActividad> findAll();
    TipoActividad findById(Integer id);
    TipoActividad save(TipoActividad tipoActividad);
    void deleteById(Integer id);
    TipoActividad updateTipoActividad(TipoActividad tipoActividad);
}
