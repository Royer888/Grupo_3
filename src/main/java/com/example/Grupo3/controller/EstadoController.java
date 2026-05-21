package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.EstadoEntity;
import com.example.Grupo3.service.EstadoService;
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
@RequestMapping("/estados")
@Tag(
        name = "ESTADO",
        description = "CRUD de estados físicos de bienes del sistema VISIAF"
)
@CrossOrigin("*")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @Operation(
            summary = "Obtener todos los estados",
            description = "Devuelve la lista completa de estados registrados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping
    public List<EstadoEntity> obtenerEstados() {
        return estadoService.obtenerTodos();
    }

    @Operation(
            summary = "Obtener un estado por código",
            description = "Devuelve un estado usando el código"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estado encontrado"),
            @ApiResponse(responseCode = "404", description = "Estado no encontrado")
    })
    @GetMapping("/{codestado}")
    public ResponseEntity<EstadoEntity> obtenerPorCodigo(
            @Parameter(description = "Código del estado")
            @PathVariable int codestado) {
        Optional<EstadoEntity> estado = estadoService.obtenerPorCodigo(codestado);
        return estado.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Registrar un nuevo estado",
            description = "Permite agregar un nuevo estado"
    )
    @PostMapping
    public EstadoEntity agregarEstado(@RequestBody EstadoEntity estado) {
        return estadoService.crear(estado);
    }

    @Operation(
            summary = "Actualizar un estado",
            description = "Actualiza un estado usando el código"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estado actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Estado no encontrado")
    })
    @PutMapping("/{codestado}")
    public ResponseEntity<EstadoEntity> actualizarEstado(
            @Parameter(description = "Código del estado")
            @PathVariable int codestado,
            @RequestBody EstadoEntity nuevoEstado) {
        return estadoService.obtenerPorCodigo(codestado)
                .map(e -> {
                    e.setNomestado(nuevoEstado.getNomestado());
                    return ResponseEntity.ok(estadoService.crear(e));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Eliminar un estado",
            description = "Elimina un estado usando el código"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Estado eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Estado no encontrado")
    })
    @DeleteMapping("/{codestado}")
    public ResponseEntity<Void> eliminarEstado(
            @Parameter(description = "Código del estado")
            @PathVariable int codestado) {
        if (estadoService.obtenerPorCodigo(codestado).isPresent()) {
            estadoService.eliminar(codestado);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}