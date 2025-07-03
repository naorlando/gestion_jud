package com.tuempresa.gestionjud.service;

import com.tuempresa.gestionjud.domain.Comentario;
import com.tuempresa.gestionjud.repository.ComentarioRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ComentarioServiceTest {
    @Test
    void agregar() {
        ComentarioRepository repo = mock(ComentarioRepository.class);
        NotificationService notificationService = mock(NotificationService.class);
        ComentarioService service = new ComentarioService(repo, notificationService);
        Comentario comentario = new Comentario();
        service.agregar(comentario);
        verify(repo).save(any(Comentario.class));
    }
}
