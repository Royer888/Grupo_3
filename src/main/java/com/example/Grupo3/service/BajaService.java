package com.example.Grupo3.service;

import com.example.Grupo3.Entity.BajaEntity;
import com.example.Grupo3.repository.BajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BajaService {

    @Autowired
    private BajaRepository bajaRepository;

    public List<BajaEntity> getAll() {
        return bajaRepository.findAll();
    }

    public Optional<BajaEntity> getById(Long id) {
        return bajaRepository.findById(id);
    }

    public BajaEntity save(BajaEntity baja) {
        return bajaRepository.save(baja);
    }

    public boolean existsById(Long id) {
        return bajaRepository.existsById(id);
    }

    public boolean delete(Long id) {
        if (!bajaRepository.existsById(id)) return false;
        bajaRepository.deleteById(id);
        return true;
    }
}