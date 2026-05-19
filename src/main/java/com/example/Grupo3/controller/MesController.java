package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.MesEntity;
import com.example.Grupo3.service.MesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mes")
@CrossOrigin(origins = "*")
@Tag(name = "MES", description = "CRUD de meses del año - Tabla de apoyo del sistema VISIAF")
public class MesController {

    @Autowired
    private MesService mesService;

    @Operation(summary = "Listar todos los meses", description = "Obtiene una lista de todos los meses registrados")
    @GetMapping
    public List<MesEntity> getAll() {
        return mesService.getAll();
    }

    @Operation(summary = "Obtener un mes por ID", description = "Busca un mes por su identificador único")
    @GetMapping("/{id}")
    public ResponseEntity<MesEntity> getById(
            @Parameter(description = "ID del mes a buscar") @PathVariable Long id) {
        return mesService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo mes", description = "Crea un nuevo mes en el sistema")
    @PostMapping
    public MesEntity create(@RequestBody MesEntity mes) {
        return mesService.save(mes);
    }

    //ejemplo para insertar
    //  {
    //    "nommes": "ENERO"
    //  }
    // automaticamente se le asiganra un codigo al mes



    @Operation(summary = "Actualizar un mes", description = "Actualiza los datos de un mes existente por su ID")
    @PutMapping("/{id}")
    public ResponseEntity<MesEntity> update(
            @Parameter(description = "ID del mes a actualizar") @PathVariable Long id,
            @RequestBody MesEntity mes) {
        if (!mesService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        mes.setMes(id);
        return ResponseEntity.ok(mesService.save(mes));
    }

    @Operation(summary = "Eliminar un mes", description = "Elimina un mes del sistema por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID del mes a eliminar") @PathVariable Long id) {
        if (!mesService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}