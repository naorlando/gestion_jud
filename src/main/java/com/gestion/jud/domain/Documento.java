package com.gestion.jud.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

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

    private String rutaArchivo;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Expediente getExpediente() { return expediente; }
    public void setExpediente(Expediente expediente) { this.expediente = expediente; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public Documento getParentDocumento() { return parentDocumento; }
    public void setParentDocumento(Documento parentDocumento) { this.parentDocumento = parentDocumento; }

    public String getRutaArchivo() { return rutaArchivo; }
    public void setRutaArchivo(String rutaArchivo) { this.rutaArchivo = rutaArchivo; }
}
