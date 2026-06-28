package com.example.Grupo3.service;

import com.example.Grupo3.Entity.ObjetoGastoEntity;
import com.example.Grupo3.repository.ObjetoGastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetoGastoService {

    @Autowired
    private ObjetoGastoRepository objetoGastoRepository;

    public List<ObjetoGastoEntity> getAll() {
        return objetoGastoRepository.findAll();
    }

    public Optional<ObjetoGastoEntity> getById(String objeto) {
        return objetoGastoRepository.findById(objeto);
    }

    public ObjetoGastoEntity save(ObjetoGastoEntity objetoGasto) {
        return objetoGastoRepository.save(objetoGasto);
    }

    public boolean existsById(String objeto) {
        return objetoGastoRepository.existsById(objeto);
    }

    public boolean delete(String objeto) {
        if (!objetoGastoRepository.existsById(objeto)) return false;
        objetoGastoRepository.deleteById(objeto);
        return true;
    }
}
