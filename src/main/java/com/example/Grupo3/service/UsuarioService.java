package com.example.Grupo3.service;

import com.example.Grupo3.Entity.UsuarioEntity;
import com.example.Grupo3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> getAll() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> getById(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioEntity save(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }

    public boolean delete(Long id) {
        if (!usuarioRepository.existsById(id)) return false;
        usuarioRepository.deleteById(id);
        return true;
    }

    public Optional<UsuarioEntity> findByUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }
}
