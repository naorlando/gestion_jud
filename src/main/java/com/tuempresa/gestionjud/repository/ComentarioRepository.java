package com.tuempresa.gestionjud.repository;

import com.tuempresa.gestionjud.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByExpedienteId(Long expedienteId);
}
