package com.example.Grupo3.service;

import com.example.Grupo3.Entity.DepartamentoEntity;
import com.example.Grupo3.repository.DepartamentoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @PostConstruct
    public void init() {

        if (departamentoRepository.count() == 0) {

            departamentoRepository.save(new DepartamentoEntity(1, "CHUQUISACA", "CHQ"));
            departamentoRepository.save(new DepartamentoEntity(2, "LA PAZ", "LPZ"));
            departamentoRepository.save(new DepartamentoEntity(3, "COCHABAMBA", "CBB"));
            departamentoRepository.save(new DepartamentoEntity(4, "ORURO", "ORU"));
            departamentoRepository.save(new DepartamentoEntity(5, "POTOSI", "PTS"));
            departamentoRepository.save(new DepartamentoEntity(6, "TARIJA", "TAR"));
            departamentoRepository.save(new DepartamentoEntity(7, "SANTA CRUZ", "SCZ"));
            departamentoRepository.save(new DepartamentoEntity(8, "BENI", "BEN"));
            departamentoRepository.save(new DepartamentoEntity(9, "PANDO", "PAN"));
            departamentoRepository.save(new DepartamentoEntity(10, "OTROS", "OTR"));
        }
    }

    // Obtener todos
    public List<DepartamentoEntity> getAll() {
        return departamentoRepository.findAll();
    }

    // Obtener por código
    public Optional<DepartamentoEntity> getById(Integer codigo) {
        return departamentoRepository.findById(codigo);
    }

    // Crear
    public DepartamentoEntity save(DepartamentoEntity departamento) {
        return departamentoRepository.save(departamento);
    }

    // Actualizar
    public DepartamentoEntity update(Integer codigo, DepartamentoEntity departamento) {
        departamento.setCodigo(codigo);
        return departamentoRepository.save(departamento);
    }

    // Eliminar
    public void delete(Integer codigo) {
        departamentoRepository.deleteById(codigo);
    }
}