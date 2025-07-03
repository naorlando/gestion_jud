package com.tuempresa.gestionjud.controller;

import com.tuempresa.gestionjud.domain.EstadoExpediente;
import com.tuempresa.gestionjud.domain.Expediente;
import com.tuempresa.gestionjud.service.ExpedienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expedientes")
public class ExpedienteController {

    private final ExpedienteService expedienteService;

    public ExpedienteController(ExpedienteService expedienteService) {
        this.expedienteService = expedienteService;
    }

    @GetMapping
    public Page<Expediente> listar(Pageable pageable, @RequestParam(required = false) EstadoExpediente estado) {
        if (estado != null) {
            return expedienteService.listarPorEstado(pageable, estado);
        }
        return expedienteService.listar(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expediente> obtener(@PathVariable Long id) {
        return expedienteService.obtener(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Expediente crear(@Validated @RequestBody Expediente expediente) {
        return expedienteService.guardar(expediente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expediente> actualizar(@PathVariable Long id, @Validated @RequestBody Expediente expediente) {
        return expedienteService.obtener(id)
                .map(ex -> {
                    expediente.setId(id);
                    return ResponseEntity.ok(expedienteService.guardar(expediente));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
