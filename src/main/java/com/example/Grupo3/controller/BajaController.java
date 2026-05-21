package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.BajaEntity;
import com.example.Grupo3.service.BajaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/baja")
@Tag(name = "BAJA", description = "CRUD de motivos de baja - Tabla de apoyo del sistema VISIAF")
public class BajaController {

    @Autowired
    private BajaService bajaService;

    @Operation(summary = "Listar todos los motivos de baja", description = "Obtiene una lista de todos los motivos de baja registrados")
    @GetMapping
    public List<BajaEntity> getAll() {
        return bajaService.getAll();
    }

    @Operation(summary = "Obtener un motivo de baja por ID", description = "Busca un motivo de baja por su identificador único")
    @GetMapping("/{id}")
    public ResponseEntity<BajaEntity> getById(
            @Parameter(description = "ID del motivo de baja a buscar") @PathVariable Long id) {
        return bajaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo motivo de baja", description = "Crea un nuevo motivo de baja en el sistema")
    @PostMapping
    public BajaEntity create(@RequestBody BajaEntity baja) {
        return bajaService.save(baja);
    }

    // Ejemplo para insertar
    // {
    //    "descbaja": "Disposición definitiva de bienes"
    // }
    // automaticamente se le asignará un código al motivo de baja

    @Operation(summary = "Actualizar un motivo de baja", description = "Actualiza los datos de un motivo de baja existente por su ID")
    @PutMapping("/{id}")
    public ResponseEntity<BajaEntity> update(
            @Parameter(description = "ID del motivo de baja a actualizar") @PathVariable Long id,
            @RequestBody BajaEntity baja) {
        if (!bajaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        baja.setCodbaja(id);
        return ResponseEntity.ok(bajaService.save(baja));
    }

    @Operation(summary = "Eliminar un motivo de baja", description = "Elimina un motivo de baja del sistema por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID del motivo de baja a eliminar") @PathVariable Long id) {
        if (!bajaService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}