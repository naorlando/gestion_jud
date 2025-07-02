package com.gestion.jud.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expediente_id")
    private Expediente expediente;

    private String tipoDocumento;

    private LocalDate fechaEmision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_documento_id")
    private Documento parentDocumento;

    @OneToMany(mappedBy = "parentDocumento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> versiones;

    private String rutaArchivo;
}
