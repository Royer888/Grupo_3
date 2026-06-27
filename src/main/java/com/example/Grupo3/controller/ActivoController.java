package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.ActivoEntity;
import com.example.Grupo3.service.ActivoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activos")
@Tag(name = "ACTIVO", description = "CRUD de activos fijos del sistema VISIAF")
public class ActivoController {

    @Autowired
    private ActivoService activoService;

    @Operation(summary = "Listar todos los activos", description = "Obtiene una lista de todos los activos fijos registrados")
    @GetMapping
    public List<ActivoEntity> getAll() {
        return activoService.getAll();
    }

    @Operation(summary = "Obtener un activo por ID", description = "Busca un activo fijo por su identificador unico")
    @GetMapping("/{id}")
    public ResponseEntity<ActivoEntity> getById(
            @Parameter(description = "ID del activo a buscar") @PathVariable Long id) {
        return activoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Obtener un activo por codigo", description = "Busca un activo fijo por su codigo unico")
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ActivoEntity> getByCodigo(
            @Parameter(description = "Codigo del activo a buscar") @PathVariable String codigo) {
        return activoService.findByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo activo", description = "Crea un nuevo activo fijo en el sistema")
    @PostMapping
    public ActivoEntity create(@RequestBody ActivoEntity activo) {
        return activoService.save(activo);
    }

    @Operation(summary = "Actualizar un activo", description = "Actualiza los datos de un activo fijo existente por su ID")
    @PutMapping("/{id}")
    public ResponseEntity<ActivoEntity> update(
            @Parameter(description = "ID del activo a actualizar") @PathVariable Long id,
            @RequestBody ActivoEntity activo) {
        if (!activoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        activo.setId(id);
        return ResponseEntity.ok(activoService.save(activo));
    }

    @Operation(summary = "Eliminar un activo", description = "Elimina un activo fijo del sistema por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID del activo a eliminar") @PathVariable Long id) {
        if (!activoService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
