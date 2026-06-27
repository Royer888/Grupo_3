package com.example.Grupo3.controller;

import com.example.Grupo3.Entity.UsuarioEntity;
import com.example.Grupo3.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "USUARIO", description = "CRUD de usuarios y login simple del sistema VISIAF")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Listar todos los usuarios", description = "Obtiene una lista de todos los usuarios registrados")
    @GetMapping
    public List<UsuarioEntity> getAll() {
        return usuarioService.getAll();
    }

    @Operation(summary = "Obtener un usuario por ID", description = "Busca un usuario por su identificador unico")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> getById(
            @Parameter(description = "ID del usuario a buscar") @PathVariable Long id) {
        return usuarioService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo usuario", description = "Crea un nuevo usuario en el sistema")
    @PostMapping
    public UsuarioEntity create(@RequestBody UsuarioEntity usuario) {
        return usuarioService.save(usuario);
    }

    @Operation(summary = "Actualizar un usuario", description = "Actualiza los datos de un usuario existente por su ID")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> update(
            @Parameter(description = "ID del usuario a actualizar") @PathVariable Long id,
            @RequestBody UsuarioEntity usuario) {
        if (!usuarioService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario del sistema por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID del usuario a eliminar") @PathVariable Long id) {
        if (!usuarioService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Iniciar sesion", description = "Valida usuario y password sin Spring Security ni JWT")
    @PostMapping("/login")
    public ResponseEntity<UsuarioEntity> login(@RequestBody UsuarioEntity loginRequest) {
        return usuarioService.findByUsuario(loginRequest.getUsuario())
                .filter(usuario -> usuario.getPassword().equals(loginRequest.getPassword()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }
}
