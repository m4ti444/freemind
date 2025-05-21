package com.freemind.freemind.service;

import java.util.List;
import com.freemind.freemind.model.Estado;

public interface EstadoService {
    List<Estado> findAll();
    Estado findById(Integer id);
    Estado save(Estado estado);
    void deleteById(Integer id);
    Estado updateEstado(Estado estado);
}
