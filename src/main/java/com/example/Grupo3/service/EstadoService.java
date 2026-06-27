package com.example.Grupo3.service;

import com.example.Grupo3.Entity.EstadoEntity;
import com.example.Grupo3.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

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
