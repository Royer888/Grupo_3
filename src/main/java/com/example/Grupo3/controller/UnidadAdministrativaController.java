package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.UnidadAdministrativaEntity;
import com.example.Grupo3.service.UnidadAdministrativaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidades-administrativas")
@Tag(name = "UNIDAD_ADMINISTRATIVA", description = "CRUD de unidades administrativas - Tabla de apoyo del sistema VISIAF")
public class UnidadAdministrativaController {

    @Autowired
    private UnidadAdministrativaService unidadAdministrativaService;

    @Operation(summary = "Listar todas las unidades administrativas", description = "Obtiene una lista de todas las unidades administrativas registradas")
    @GetMapping
    public List<UnidadAdministrativaEntity> getAll() {
        return unidadAdministrativaService.getAll();
    }

    @Operation(summary = "Obtener una unidad administrativa por ID", description = "Busca una unidad administrativa por su identificador unico")
    @GetMapping("/{id}")
    public ResponseEntity<UnidadAdministrativaEntity> getById(
            @Parameter(description = "ID de la unidad administrativa a buscar") @PathVariable Long id) {
        return unidadAdministrativaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar una nueva unidad administrativa", description = "Crea una nueva unidad administrativa en el sistema")
    @PostMapping
    public UnidadAdministrativaEntity create(@RequestBody UnidadAdministrativaEntity unidad) {
        return unidadAdministrativaService.save(unidad);
    }

    @Operation(summary = "Actualizar una unidad administrativa", description = "Actualiza los datos de una unidad administrativa existente por su ID")
    @PutMapping("/{id}")
    public ResponseEntity<UnidadAdministrativaEntity> update(
            @Parameter(description = "ID de la unidad administrativa a actualizar") @PathVariable Long id,
            @RequestBody UnidadAdministrativaEntity unidad) {
        if (!unidadAdministrativaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        unidad.setId(id);
        return ResponseEntity.ok(unidadAdministrativaService.save(unidad));
    }

    @Operation(summary = "Eliminar una unidad administrativa", description = "Elimina una unidad administrativa del sistema por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID de la unidad administrativa a eliminar") @PathVariable Long id) {
        if (!unidadAdministrativaService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
