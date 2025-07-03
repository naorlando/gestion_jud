package com.tuempresa.gestionjud.service;

import com.tuempresa.gestionjud.domain.Comentario;
import com.tuempresa.gestionjud.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final NotificationService notificationService;

    public ComentarioService(ComentarioRepository comentarioRepository, NotificationService notificationService) {
        this.comentarioRepository = comentarioRepository;
        this.notificationService = notificationService;
    }

    public Comentario agregar(Comentario comentario) {
        comentario.setTimestamp(LocalDateTime.now());
        Comentario saved = comentarioRepository.save(comentario);
        notificationService.notifyComentario(saved);
        return saved;
    }

    public List<Comentario> listar(Long expedienteId) {
        return comentarioRepository.findByExpedienteId(expedienteId);
    }
}
