package com.example.Grupo3.repository;

import com.example.Grupo3.Entity.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoEntity, Integer> {
    // Integer porque codestado es int
}