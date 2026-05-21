package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.EstadoEntidadEntity;
import com.example.Grupo3.service.EstadoEntidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estado-entidad")
@Tag(name = "ESTADO ENTIDAD", description = "CRUD de estructura del Estado - Tabla del sistema VISIAF")
public class EstadoEntidadController {

    @Autowired
    private EstadoEntidadService service;

    @Operation(summary = "Listar todas las entidades")
    @GetMapping
    public List<EstadoEntidadEntity> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Obtener entidad por ID")
    @GetMapping("/{id}")
    public ResponseEntity<EstadoEntidadEntity> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear nueva entidad")
    @PostMapping
    public EstadoEntidadEntity create(@RequestBody EstadoEntidadEntity entity) {
        return service.save(entity);
    }

    @Operation(summary = "Actualizar entidad")
    @PutMapping("/{id}")
    public ResponseEntity<EstadoEntidadEntity> update(@PathVariable Long id, @RequestBody EstadoEntidadEntity entity) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        entity.setId(id);
        return ResponseEntity.ok(service.save(entity));
    }

    @Operation(summary = "Eliminar entidad")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}