package com.example.Grupo3.objgasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/objgasto")
public class ObjGastoController {

    @Autowired
    private ObjGastoRepository repository;

    @GetMapping
    public List<ObjGasto> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjGasto> buscarPorId(@PathVariable Long id) {
        Optional<ObjGasto> objGasto = repository.findById(id);
        return objGasto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ObjGasto crear(@RequestBody ObjGasto objGasto) {
        return repository.save(objGasto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjGasto> actualizar(@PathVariable Long id, @RequestBody ObjGasto detalles) {
        Optional<ObjGasto> objGastoExistente = repository.findById(id);

        if (objGastoExistente.isPresent()) {
            ObjGasto actualizado = objGastoExistente.get();
            actualizado.setGestion(detalles.getGestion());
            actualizado.setPartida(detalles.getPartida());
            actualizado.setDescrip(detalles.getDescrip());
            return ResponseEntity.ok(repository.save(actualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}