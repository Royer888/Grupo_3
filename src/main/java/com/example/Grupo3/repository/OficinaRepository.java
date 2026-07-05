package com.example.Grupo3.repository;

import com.example.Grupo3.Entity.OficinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OficinaRepository extends JpaRepository<OficinaEntity, Long> {

    Optional<OficinaEntity> findByCodigo(String codigo);
}