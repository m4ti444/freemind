package com.freemind.freemind.service;

import java.util.List;
import com.freemind.freemind.model.Institucion;

public interface InstitucionService {
    List<Institucion> findAll();
    Institucion findById(Integer id);
    Institucion save(Institucion institucion);
    void deleteById(Integer id);
    Institucion updateInstitucion(Institucion institucion);
}
