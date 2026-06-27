package com.example.Grupo3.repository;

import com.example.Grupo3.Entity.ActivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivoRepository extends JpaRepository<ActivoEntity, Long> {

    Optional<ActivoEntity> findByCodigo(String codigo);
}
