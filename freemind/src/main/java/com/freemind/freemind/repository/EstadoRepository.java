package com.freemind.freemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.freemind.freemind.model.Estado;
import java.util.List;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findByNombre(String nombre);

}
