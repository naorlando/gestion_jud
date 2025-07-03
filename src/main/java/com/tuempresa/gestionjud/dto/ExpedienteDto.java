package com.tuempresa.gestionjud.dto;

import com.tuempresa.gestionjud.domain.EstadoExpediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpedienteDto {
    private Long id;
    private String tipoSiniestro;
    private LocalDate fechaInicio;
    private EstadoExpediente estado;
    private BigDecimal provisionContable;
}
