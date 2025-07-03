package com.tuempresa.gestionjud.service;

import com.tuempresa.gestionjud.domain.EstadoExpediente;
import com.tuempresa.gestionjud.domain.Expediente;
import com.tuempresa.gestionjud.repository.ExpedienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ExpedienteService {

    private final ExpedienteRepository expedienteRepository;

    public ExpedienteService(ExpedienteRepository expedienteRepository) {
        this.expedienteRepository = expedienteRepository;
    }

    public Page<Expediente> listar(Pageable pageable) {
        return expedienteRepository.findAll(pageable);
    }

    public Page<Expediente> listarPorEstado(Pageable pageable, EstadoExpediente estado) {
        return expedienteRepository.findByEstado(pageable, estado);
    }

    public Optional<Expediente> obtener(Long id) {
        return expedienteRepository.findById(id);
    }

    public Expediente guardar(Expediente expediente) {
        calcularProvision(expediente);
        return expedienteRepository.save(expediente);
    }

    public void eliminar(Long id) {
        expedienteRepository.deleteById(id);
    }

    public void calcularProvision(Expediente expediente) {
        expediente.setProvisionContable(BigDecimal.valueOf(1000));
    }
}
