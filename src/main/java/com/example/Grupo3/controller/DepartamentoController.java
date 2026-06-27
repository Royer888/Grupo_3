package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.DepartamentoEntity;
import com.example.Grupo3.service.DepartamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departamentos")
@Tag(
        name = "DEPARTAMENTOS",
        description = "CRUD de departamentos de Bolivia del sistema VISIAF"
)
@CrossOrigin("*")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @Operation(
            summary = "Obtener todos los departamentos",
            description = "Devuelve la lista completa de departamentos"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping
    public List<DepartamentoEntity> getAll() {
        return departamentoService.getAll();
    }

    @Operation(
            summary = "Obtener un departamento por código",
            description = "Devuelve un departamento usando el código"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departamento encontrado"),
            @ApiResponse(responseCode = "404", description = "Departamento no encontrado")
    })
    @GetMapping("/{codigo}")
    public ResponseEntity<DepartamentoEntity> getById(
            @Parameter(description = "Código del departamento")
            @PathVariable Integer codigo) {
        Optional<DepartamentoEntity> departamento = departamentoService.getById(codigo);
        return departamento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Registrar un nuevo departamento",
            description = "Permite agregar un departamento"
    )
    @PostMapping
    public DepartamentoEntity save(@RequestBody DepartamentoEntity departamento) {
        return departamentoService.save(departamento);
    }

    @Operation(
            summary = "Actualizar un departamento",
            description = "Actualiza un departamento usando el código"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departamento actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Departamento no encontrado")
    })
    @PutMapping("/{codigo}")
    public ResponseEntity<DepartamentoEntity> update(
            @Parameter(description = "Código del departamento")
            @PathVariable Integer codigo,
            @RequestBody DepartamentoEntity departamento) {
        return ResponseEntity.ok(departamentoService.update(codigo, departamento));
    }

    @Operation(
            summary = "Eliminar un departamento",
            description = "Elimina un departamento usando el código"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Departamento eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Departamento no encontrado")
    })
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Código del departamento")
            @PathVariable Integer codigo) {
        departamentoService.delete(codigo);
        return ResponseEntity.noContent().build();
    }
}
