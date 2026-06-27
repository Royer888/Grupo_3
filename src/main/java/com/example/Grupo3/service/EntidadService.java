package com.example.Grupo3.service;

import com.example.Grupo3.Entity.EntidadEntity;
import com.example.Grupo3.repository.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntidadService {

    @Autowired
    private EntidadRepository entidadRepository;

    public List<EntidadEntity> getAll() {
        return entidadRepository.findAll();
    }

    public Optional<EntidadEntity> getById(String siglaestru) {
        return entidadRepository.findById(siglaestru);
    }

    public EntidadEntity save(EntidadEntity entidad) {
        return entidadRepository.save(entidad);
    }

    public boolean existsById(String siglaestru) {
        return entidadRepository.existsById(siglaestru);
    }

    public boolean delete(String siglaestru) {
        if (!entidadRepository.existsById(siglaestru)) return false;
        entidadRepository.deleteById(siglaestru);
        return true;
    }
}
