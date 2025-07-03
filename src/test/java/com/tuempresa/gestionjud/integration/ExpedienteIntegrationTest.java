package com.tuempresa.gestionjud.integration;

import com.tuempresa.gestionjud.domain.Expediente;
import com.tuempresa.gestionjud.repository.ExpedienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExpedienteIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ExpedienteRepository expedienteRepository;

    @Test
    void listarExpedientes() throws Exception {
        Expediente e = new Expediente();
        e.setTipoSiniestro("tipo");
        e.setFechaInicio(LocalDate.now());
        expedienteRepository.save(e);

        mockMvc.perform(get("/api/expedientes").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
