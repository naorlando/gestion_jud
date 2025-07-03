package com.tuempresa.gestionjud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoSiniestro;

    private LocalDate fechaInicio;

    @Enumerated(EnumType.STRING)
    private EstadoExpediente estado;

    private BigDecimal provisionContable;
}
