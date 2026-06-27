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
    private OrganismoFinRepository organismoFinRepository;

    public List<OrganismoFinEntity> getAll() {
        return organismoFinRepository.findAll();
    }

    public Optional<OrganismoFinEntity> getById(String of) {
        return organismoFinRepository.findById(of);
    }

    public OrganismoFinEntity save(OrganismoFinEntity organismo) {
        return organismoFinRepository.save(organismo);
    }

    public OrganismoFinEntity update(String of, OrganismoFinEntity organismo) {
        organismo.setOf(of);
        return organismoFinRepository.save(organismo);
    }

    public void delete(String of) {
        organismoFinRepository.deleteById(of);
    }
}
