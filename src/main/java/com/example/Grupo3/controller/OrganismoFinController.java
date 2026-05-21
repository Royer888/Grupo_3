package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.OrganismoFinEntity;
import com.example.Grupo3.service.OrganismoFinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/organismo-fin")
@Tag(name = "ORGANISMO FIN", description = "CRUD de organismos financiadores - Tabla del sistema VISIAF")
public class OrganismoFinController {

    @Autowired
    private OrganismoFinService service;

    @Operation(summary = "Listar todos los organismos")
    @GetMapping
    public List<OrganismoFinEntity> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Obtener organismo por ID")
    @GetMapping("/{id}")
    public ResponseEntity<OrganismoFinEntity> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear nuevo organismo")
    @PostMapping
    public OrganismoFinEntity create(@RequestBody OrganismoFinEntity entity) {
        return service.save(entity);
    }

    @Operation(summary = "Actualizar organismo")
    @PutMapping("/{id}")
    public ResponseEntity<OrganismoFinEntity> update(@PathVariable Long id, @RequestBody OrganismoFinEntity entity) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        entity.setId(id);
        return ResponseEntity.ok(service.save(entity));
    }

    @Operation(summary = "Eliminar organismo")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}