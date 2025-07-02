package com.gestion.jud.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expedientes")
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoSiniestro;

    private LocalDate fechaInicio;

    @Enumerated(EnumType.STRING)
    private EstadoExpediente estado;

    private BigDecimal provisionContable;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoSiniestro() { return tipoSiniestro; }
    public void setTipoSiniestro(String tipoSiniestro) { this.tipoSiniestro = tipoSiniestro; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public EstadoExpediente getEstado() { return estado; }
    public void setEstado(EstadoExpediente estado) { this.estado = estado; }

    public BigDecimal getProvisionContable() { return provisionContable; }
    public void setProvisionContable(BigDecimal provisionContable) { this.provisionContable = provisionContable; }
}
