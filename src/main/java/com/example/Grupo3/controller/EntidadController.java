package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.EntidadEntity;
import com.example.Grupo3.service.EntidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entidad")
@Tag(name = "ENTIDAD", description = "CRUD de entidades institucionales - Tabla de apoyo del sistema VISIAF")
public class EntidadController {

    @Autowired
    private EntidadService entidadService;

    @Operation(summary = "Listar todas las entidades", description = "Obtiene una lista de todas las entidades institucionales registradas")
    @GetMapping
    public List<EntidadEntity> getAll() {
        return entidadService.getAll();
    }

    @Operation(summary = "Obtener una entidad por sigla", description = "Busca una entidad por su sigla de estructura")
    @GetMapping("/{siglaestru}")
    public ResponseEntity<EntidadEntity> getById(
            @Parameter(description = "Sigla de la entidad a buscar") @PathVariable String siglaestru) {
        return entidadService.getById(siglaestru)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar una nueva entidad", description = "Crea una nueva entidad institucional en el sistema")
    @PostMapping
    public EntidadEntity create(@RequestBody EntidadEntity entidad) {
        return entidadService.save(entidad);
    }

    @Operation(summary = "Actualizar una entidad", description = "Actualiza los datos de una entidad existente por su sigla")
    @PutMapping("/{siglaestru}")
    public ResponseEntity<EntidadEntity> update(
            @Parameter(description = "Sigla de la entidad a actualizar") @PathVariable String siglaestru,
            @RequestBody EntidadEntity entidad) {
        if (!entidadService.existsById(siglaestru)) {
            return ResponseEntity.notFound().build();
        }
        entidad.setSiglaestru(siglaestru);
        return ResponseEntity.ok(entidadService.save(entidad));
    }

    @Operation(summary = "Eliminar una entidad", description = "Elimina una entidad institucional del sistema por su sigla")
    @DeleteMapping("/{siglaestru}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Sigla de la entidad a eliminar") @PathVariable String siglaestru) {
        if (!entidadService.delete(siglaestru)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
