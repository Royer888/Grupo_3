package com.example.Grupo3.service;

import com.example.Grupo3.Entity.OficinaEntity;
import com.example.Grupo3.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OficinaService {

    @Autowired
    private OficinaRepository oficinaRepository;

    public List<OficinaEntity> getAll() {
        return oficinaRepository.findAll();
    }

    public Optional<OficinaEntity> getById(Long id) {
        return oficinaRepository.findById(id);
    }

    public Optional<OficinaEntity> getByCodigo(String codigo) {
        return oficinaRepository.findByCodigo(codigo);
    }

    public OficinaEntity save(OficinaEntity oficina) {
        return oficinaRepository.save(oficina);
    }

    public boolean existsById(Long id) {
        return oficinaRepository.existsById(id);
    }

    public boolean delete(Long id) {
        if (!oficinaRepository.existsById(id)) {
            return false;
        }

        oficinaRepository.deleteById(id);
        return true;
    }
}