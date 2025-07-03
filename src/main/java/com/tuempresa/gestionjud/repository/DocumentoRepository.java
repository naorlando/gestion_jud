package com.tuempresa.gestionjud.repository;

import com.tuempresa.gestionjud.domain.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    List<Documento> findByExpedienteIdOrderByFechaEmisionDesc(Long expedienteId);
}
