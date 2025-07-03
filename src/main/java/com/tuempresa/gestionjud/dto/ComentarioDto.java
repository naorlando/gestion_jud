package com.tuempresa.gestionjud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDto {
    private Long id;
    private Long expedienteId;
    private Long usuarioId;
    private String texto;
    private LocalDateTime timestamp;
}
