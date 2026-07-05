package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.OficinaEntity;
import com.example.Grupo3.service.OficinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oficinas")
@Tag(name = "OFICINAS", description = "CRUD de oficinas para el sistema VSIAF")
public class OficinaController {

    @Autowired
    private OficinaService oficinaService;

    @Operation(summary = "Listar todas las oficinas", description = "Obtiene una lista de todas las oficinas registradas")
    @GetMapping
    public List<OficinaEntity> getAll() {
        return oficinaService.getAll();
    }

    @Operation(summary = "Obtener una oficina por ID", description = "Busca una oficina por su identificador único")
    @GetMapping("/{id}")
    public ResponseEntity<OficinaEntity> getById(
            @Parameter(description = "ID de la oficina a buscar") @PathVariable Long id) {

        return oficinaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Obtener una oficina por código", description = "Busca una oficina por su código")
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<OficinaEntity> getByCodigo(
            @Parameter(description = "Código de la oficina a buscar") @PathVariable String codigo) {

        return oficinaService.getByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar una nueva oficina", description = "Crea una nueva oficina en el sistema")
    @PostMapping
    public OficinaEntity create(@RequestBody OficinaEntity oficina) {
        return oficinaService.save(oficina);
    }

    @Operation(summary = "Actualizar una oficina", description = "Actualiza los datos de una oficina existente por su ID")
    @PutMapping("/{id}")
    public ResponseEntity<OficinaEntity> update(
            @Parameter(description = "ID de la oficina a actualizar") @PathVariable Long id,
            @RequestBody OficinaEntity oficina) {

        if (!oficinaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        oficina.setId(id);
        return ResponseEntity.ok(oficinaService.save(oficina));
    }

    @Operation(summary = "Eliminar una oficina", description = "Elimina una oficina del sistema por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID de la oficina a eliminar") @PathVariable Long id) {

        if (!oficinaService.delete(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}