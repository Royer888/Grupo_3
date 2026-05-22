package com.example.Grupo3.service;

import com.example.Grupo3.Entity.ObjGastoEntity;
import com.example.Grupo3.repository.ObjGastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjGastoService {

    @Autowired
    private ObjGastoRepository objGastoRepository;

    public List<ObjGastoEntity> obtenerTodos() {
        return objGastoRepository.findAll();
    }

    public Optional<ObjGastoEntity> obtenerPorId(Long id) {
        return objGastoRepository.findById(id);
    }

    public ObjGastoEntity guardar(ObjGastoEntity objGasto) {
        return objGastoRepository.save(objGasto);
    }

    public void eliminar(Long id) {
        objGastoRepository.deleteById(id);
    }
}