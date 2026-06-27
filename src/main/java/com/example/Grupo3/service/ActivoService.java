package com.example.Grupo3.service;

import com.example.Grupo3.Entity.ActivoEntity;
import com.example.Grupo3.repository.ActivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivoService {

    @Autowired
    private ActivoRepository activoRepository;

    public List<ActivoEntity> getAll() {
        return activoRepository.findAll();
    }

    public Optional<ActivoEntity> getById(Long id) {
        return activoRepository.findById(id);
    }

    public ActivoEntity save(ActivoEntity activo) {
        return activoRepository.save(activo);
    }

    public boolean existsById(Long id) {
        return activoRepository.existsById(id);
    }

    public boolean delete(Long id) {
        if (!activoRepository.existsById(id)) return false;
        activoRepository.deleteById(id);
        return true;
    }

    public Optional<ActivoEntity> findByCodigo(String codigo) {
        return activoRepository.findByCodigo(codigo);
    }
}
