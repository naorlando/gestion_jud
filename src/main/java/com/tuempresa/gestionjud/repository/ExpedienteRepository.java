package com.tuempresa.gestionjud.repository;

import com.tuempresa.gestionjud.domain.EstadoExpediente;
import com.tuempresa.gestionjud.domain.Expediente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpedienteRepository extends JpaRepository<Expediente, Long> {
    Page<Expediente> findByEstado(Pageable pageable, EstadoExpediente estado);
}
