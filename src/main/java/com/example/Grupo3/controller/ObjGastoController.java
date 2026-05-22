package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.ObjGastoEntity;
import com.example.Grupo3.service.ObjGastoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/objgasto")
@Tag(name = "OBJGASTO", description = "CRUD de Objetos de Gasto del sistema VISIAF")
public class ObjGastoController {

    @Autowired
    private ObjGastoService objGastoService;

    @GetMapping
    @Operation(summary = "Obtener todos los objetos de gasto")
    public List<ObjGastoEntity> listarTodos() {
        return objGastoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un objeto de gasto por ID")
    public ResponseEntity<ObjGastoEntity> obtenerPorId(@PathVariable Long id) {
        Optional<ObjGastoEntity> objGasto = objGastoService.obtenerPorId(id);
        return objGasto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo objeto de gasto")
    public ObjGastoEntity crear(@RequestBody ObjGastoEntity objGasto) {
        return objGastoService.guardar(objGasto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un objeto de gasto")
    public ResponseEntity<ObjGastoEntity> actualizar(@PathVariable Long id, @RequestBody ObjGastoEntity objGastoDetalles) {
        Optional<ObjGastoEntity> objGastoOptional = objGastoService.obtenerPorId(id);
        if (objGastoOptional.isPresent()) {
            ObjGastoEntity objGastoExistente = objGastoOptional.get();
            objGastoExistente.setCodigo(objGastoDetalles.getCodigo());
            objGastoExistente.setDescripcion(objGastoDetalles.getDescripcion());
            return ResponseEntity.ok(objGastoService.guardar(objGastoExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un objeto de gasto")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<ObjGastoEntity> objGastoOptional = objGastoService.obtenerPorId(id);
        if (objGastoOptional.isPresent()) {
            objGastoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}