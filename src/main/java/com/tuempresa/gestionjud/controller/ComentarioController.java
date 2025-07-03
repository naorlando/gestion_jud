package com.tuempresa.gestionjud.controller;

import com.tuempresa.gestionjud.domain.Comentario;
import com.tuempresa.gestionjud.service.ComentarioService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public Comentario crear(@Validated @RequestBody Comentario comentario) {
        return comentarioService.agregar(comentario);
    }

    @GetMapping("/expediente/{expedienteId}")
    public List<Comentario> listar(@PathVariable Long expedienteId) {
        return comentarioService.listar(expedienteId);
    }
}
