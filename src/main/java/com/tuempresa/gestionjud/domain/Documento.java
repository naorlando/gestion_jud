package com.tuempresa.gestionjud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Expediente expediente;

    private String tipoDocumento;

    private LocalDate fechaEmision;

    @ManyToOne
    private Documento parentDocumento;

    private String rutaArchivo;
}
