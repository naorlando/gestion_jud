package com.gestion.jud.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
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

    @OneToMany(mappedBy = "expediente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> documentos;

    @OneToMany(mappedBy = "expediente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;
}
