package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.ObjetoGastoEntity;
import com.example.Grupo3.service.ObjetoGastoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objgasto")
@Tag(name = "OBJETO_GASTO", description = "CRUD de objetos de gasto - Tabla de apoyo del sistema VISIAF")
public class ObjetoGastoController {

    @Autowired
    private ObjetoGastoService objetoGastoService;

    @Operation(summary = "Listar todos los objetos de gasto", description = "Obtiene una lista de todos los objetos de gasto registrados")
    @GetMapping
    public List<ObjetoGastoEntity> getAll() {
        return objetoGastoService.getAll();
    }

    @Operation(summary = "Obtener un objeto de gasto por codigo", description = "Busca un objeto de gasto por su codigo")
    @GetMapping("/{objeto}")
    public ResponseEntity<ObjetoGastoEntity> getById(
            @Parameter(description = "Codigo del objeto de gasto a buscar") @PathVariable String objeto) {
        return objetoGastoService.getById(objeto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo objeto de gasto", description = "Crea un nuevo objeto de gasto en el sistema")
    @PostMapping
    public ObjetoGastoEntity create(@RequestBody ObjetoGastoEntity objetoGasto) {
        return objetoGastoService.save(objetoGasto);
    }

    @Operation(summary = "Actualizar un objeto de gasto", description = "Actualiza los datos de un objeto de gasto existente por su codigo")
    @PutMapping("/{objeto}")
    public ResponseEntity<ObjetoGastoEntity> update(
            @Parameter(description = "Codigo del objeto de gasto a actualizar") @PathVariable String objeto,
            @RequestBody ObjetoGastoEntity objetoGasto) {
        if (!objetoGastoService.existsById(objeto)) {
            return ResponseEntity.notFound().build();
        }
        objetoGasto.setObjeto(objeto);
        return ResponseEntity.ok(objetoGastoService.save(objetoGasto));
    }

    @Operation(summary = "Eliminar un objeto de gasto", description = "Elimina un objeto de gasto del sistema por su codigo")
    @DeleteMapping("/{objeto}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Codigo del objeto de gasto a eliminar") @PathVariable String objeto) {
        if (!objetoGastoService.delete(objeto)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
