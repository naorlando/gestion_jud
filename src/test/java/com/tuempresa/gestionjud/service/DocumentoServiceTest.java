package com.tuempresa.gestionjud.service;

import com.tuempresa.gestionjud.domain.Documento;
import com.tuempresa.gestionjud.repository.DocumentoRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DocumentoServiceTest {
    @Test
    void obtener() {
        DocumentoRepository repo = mock(DocumentoRepository.class);
        FileStorageService storage = mock(FileStorageService.class);
        DocumentoService service = new DocumentoService(repo, storage);
        Documento doc = new Documento();
        when(repo.findById(1L)).thenReturn(Optional.of(doc));
        assertTrue(service.obtener(1L).isPresent());
    }
}
