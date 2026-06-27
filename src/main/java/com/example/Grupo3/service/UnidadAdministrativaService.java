package com.example.Grupo3.service;

import com.example.Grupo3.Entity.UnidadAdministrativaEntity;
import com.example.Grupo3.repository.UnidadAdministrativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadAdministrativaService {

    @Autowired
    private UnidadAdministrativaRepository unidadAdministrativaRepository;

    public List<UnidadAdministrativaEntity> getAll() {
        return unidadAdministrativaRepository.findAll();
    }

    public Optional<UnidadAdministrativaEntity> getById(Long id) {
        return unidadAdministrativaRepository.findById(id);
    }

    public UnidadAdministrativaEntity save(UnidadAdministrativaEntity unidad) {
        return unidadAdministrativaRepository.save(unidad);
    }

    public boolean existsById(Long id) {
        return unidadAdministrativaRepository.existsById(id);
    }

    public boolean delete(Long id) {
        if (!unidadAdministrativaRepository.existsById(id)) return false;
        unidadAdministrativaRepository.deleteById(id);
        return true;
    }
}
