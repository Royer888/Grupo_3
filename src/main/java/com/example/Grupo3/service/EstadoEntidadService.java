package com.example.Grupo3.service;

import com.example.Grupo3.Entity.EstadoEntidadEntity;
import com.example.Grupo3.repository.EstadoEntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoEntidadService {

    @Autowired
    private EstadoEntidadRepository repository;

    public List<EstadoEntidadEntity> getAll() {
        return repository.findAll();
    }

    public Optional<EstadoEntidadEntity> getById(Long id) {
        return repository.findById(id);
    }

    public EstadoEntidadEntity save(EstadoEntidadEntity entity) {
        return repository.save(entity);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}