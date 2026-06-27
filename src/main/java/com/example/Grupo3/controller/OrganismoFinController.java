package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.OrganismoFinEntity;
import com.example.Grupo3.service.OrganismoFinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organismos")
@Tag(
        name = "ORGANISMO_FIN",
        description = "CRUD de organismos financiadores del sistema VISIAF"
)
@CrossOrigin("*")
public class OrganismoFinController {

    @Autowired
    private OrganismoFinService organismoFinService;

    @Operation(summary = "Obtener todos los organismos financiadores",
            description = "Devuelve la lista completa de organismos registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping
    public List<OrganismoFinEntity> obtenerOrganismos() {
        return organismoFinService.getAll();
    }

    @Operation(summary = "Obtener un organismo financiador por código",
            description = "Devuelve un organismo usando el código OF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Organismo encontrado"),
            @ApiResponse(responseCode = "404", description = "Organismo no encontrado")
    })
    @GetMapping("/{of}")
    public ResponseEntity<OrganismoFinEntity> obtenerPorOf(
            @Parameter(description = "Código OF del organismo")
            @PathVariable String of) {
        return organismoFinService.getById(of)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo organismo financiador",
            description = "Permite agregar un nuevo organismo")
    @PostMapping
    public OrganismoFinEntity agregarOrganismo(@RequestBody OrganismoFinEntity organismo) {
        return organismoFinService.save(organismo);
    }

    @Operation(summary = "Actualizar un organismo financiador",
            description = "Actualiza los datos de un organismo utilizando el código OF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Organismo actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Organismo no encontrado")
    })
    @PutMapping("/{of}")
    public ResponseEntity<OrganismoFinEntity> actualizarOrganismo(
            @Parameter(description = "Código OF del organismo")
            @PathVariable String of,
            @RequestBody OrganismoFinEntity organismo) {
        return organismoFinService.getById(of)
                .map(o -> ResponseEntity.ok(organismoFinService.update(of, organismo)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar un organismo financiador",
            description = "Elimina un organismo utilizando el código OF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Organismo eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Organismo no encontrado")
    })
    @DeleteMapping("/{of}")
    public ResponseEntity<Void> eliminarOrganismo(
            @Parameter(description = "Código OF del organismo")
            @PathVariable String of) {
        if (organismoFinService.getById(of).isPresent()) {
            organismoFinService.delete(of);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
