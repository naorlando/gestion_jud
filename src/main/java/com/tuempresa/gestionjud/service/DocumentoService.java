package com.tuempresa.gestionjud.service;

import com.tuempresa.gestionjud.domain.Documento;
import com.tuempresa.gestionjud.repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final FileStorageService fileStorageService;

    public DocumentoService(DocumentoRepository documentoRepository, FileStorageService fileStorageService) {
        this.documentoRepository = documentoRepository;
        this.fileStorageService = fileStorageService;
    }

    public Documento guardar(Documento documento, byte[] contenido) {
        documento.setFechaEmision(LocalDate.now());
        String path = fileStorageService.store(contenido, documento.getTipoDocumento());
        documento.setRutaArchivo(path);
        return documentoRepository.save(documento);
    }

    public Optional<Documento> obtener(Long id) {
        return documentoRepository.findById(id);
    }

    public List<Documento> listarPorExpediente(Long expedienteId) {
        return documentoRepository.findByExpedienteIdOrderByFechaEmisionDesc(expedienteId);
    }

    public byte[] descargar(Documento documento) {
        return fileStorageService.load(documento.getRutaArchivo());
    }
}
