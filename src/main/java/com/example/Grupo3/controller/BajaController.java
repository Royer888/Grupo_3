package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.BajaEntity;
import com.example.Grupo3.service.BajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/baja")
public class BajaController {

    @Autowired
    private BajaService bajaService;

    @GetMapping
    public List<BajaEntity> getAll() {
        return bajaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BajaEntity> getById(@PathVariable Long id) {
        return bajaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BajaEntity create(@RequestBody BajaEntity baja) {
        return bajaService.save(baja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BajaEntity> update(@PathVariable Long id, @RequestBody BajaEntity baja) {
        if (!bajaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        baja.setCodbaja(id);
        return ResponseEntity.ok(bajaService.save(baja));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!bajaService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}