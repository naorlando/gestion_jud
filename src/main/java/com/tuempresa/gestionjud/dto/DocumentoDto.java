package com.tuempresa.gestionjud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoDto {
    private Long id;
    private Long expedienteId;
    private String tipoDocumento;
    private LocalDate fechaEmision;
    private Long parentDocumentoId;
    private String url;
}
