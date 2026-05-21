package com.example.Grupo3.service;

import com.example.Grupo3.Entity.MesEntity;
import com.example.Grupo3.repository.MesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MesService {

    @Autowired
    private MesRepository mesRepository;

    public List<MesEntity> getAll() {
        return mesRepository.findAll();
    }

    public Optional<MesEntity> getById(Long id) {
        return mesRepository.findById(id);
    }

    public MesEntity save(MesEntity mes) {
        return mesRepository.save(mes);
    }

    public boolean existsById(Long id) {
        return mesRepository.existsById(id);
    }

    public boolean delete(Long id) {
        if (!mesRepository.existsById(id)) {
            return false;
        }
        mesRepository.deleteById(id);
        return true;
    }
}