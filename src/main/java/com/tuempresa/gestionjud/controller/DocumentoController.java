package com.tuempresa.gestionjud.controller;

import com.tuempresa.gestionjud.domain.Documento;
import com.tuempresa.gestionjud.service.DocumentoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Documento upload(@RequestPart Documento documento, @RequestPart MultipartFile file) throws IOException {
        return documentoService.guardar(documento, file.getBytes());
    }

    @GetMapping("/expediente/{expedienteId}")
    public List<Documento> listar(@PathVariable Long expedienteId) {
        return documentoService.listarPorExpediente(expedienteId);
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> download(@PathVariable Long id) {
        return documentoService.obtener(id).map(doc -> {
            byte[] data = documentoService.descargar(doc);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + doc.getTipoDocumento())
                    .body(data);
        }).orElse(ResponseEntity.notFound().build());
    }
}
