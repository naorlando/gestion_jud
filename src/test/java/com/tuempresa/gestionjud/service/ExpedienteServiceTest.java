package com.tuempresa.gestionjud.service;

import com.tuempresa.gestionjud.domain.Expediente;
import com.tuempresa.gestionjud.repository.ExpedienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExpedienteServiceTest {

    @Test
    void listar() {
        ExpedienteRepository repo = mock(ExpedienteRepository.class);
        Page<Expediente> page = new PageImpl<>(Collections.emptyList());
        when(repo.findAll(any(PageRequest.class))).thenReturn(page);
        ExpedienteService service = new ExpedienteService(repo);
        Page<Expediente> result = service.listar(PageRequest.of(0,1));
        assertEquals(page, result);
        verify(repo).findAll(any(PageRequest.class));
    }
}
