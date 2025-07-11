package com.tuempresa.gestionjud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateExpedienteDto {
    private String tipoSiniestro;
    private LocalDate fechaInicio;
}
