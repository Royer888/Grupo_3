package com.example.Grupo3.service;

import com.example.Grupo3.Entity.DepartamentoEntity;
import com.example.Grupo3.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<DepartamentoEntity> getAll() {
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoEntity> getById(Integer codigo) {
        return departamentoRepository.findById(codigo);
    }

    public DepartamentoEntity save(DepartamentoEntity departamento) {
        return departamentoRepository.save(departamento);
    }

    public DepartamentoEntity update(Integer codigo, DepartamentoEntity departamento) {
        departamento.setCodigo(codigo);
        return departamentoRepository.save(departamento);
    }

    public void delete(Integer codigo) {
        departamentoRepository.deleteById(codigo);
    }
}
