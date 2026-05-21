package com.example.Grupo3.service;

import com.example.Grupo3.Entity.OrganismoFinEntity;
import com.example.Grupo3.repository.OrganismoFinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrganismoFinService {

    @Autowired
    private OrganismoFinRepository repository;

    public List<OrganismoFinEntity> getAll() {
        return repository.findAll();
    }

    public Optional<OrganismoFinEntity> getById(Long id) {
        return repository.findById(id);
    }

    public OrganismoFinEntity save(OrganismoFinEntity entity) {
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