package com.example.Grupo3.service;

import com.example.Grupo3.Entity.EstadoEntity;
import com.example.Grupo3.repository.EstadoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @PostConstruct
    public void init() {
        if (estadoRepository.count() == 0) {
            estadoRepository.save(new EstadoEntity(1, "BUENO"));
            estadoRepository.save(new EstadoEntity(2, "REGULAR"));
            estadoRepository.save(new EstadoEntity(3, "MALO"));
            estadoRepository.save(new EstadoEntity(4, "EXCELENTE"));
        }
    }

    public List<EstadoEntity> obtenerTodos() {
        return estadoRepository.findAll();
    }

    public Optional<EstadoEntity> obtenerPorCodigo(int codestado) {
        return estadoRepository.findById(codestado);
    }

    public EstadoEntity crear(EstadoEntity estado) {
        return estadoRepository.save(estado);
    }

    public EstadoEntity actualizar(int codestado, EstadoEntity nuevoEstado) {
        nuevoEstado.setCodestado(codestado);
        return estadoRepository.save(nuevoEstado);
    }

    public void eliminar(int codestado) {
        estadoRepository.deleteById(codestado);
    }
}