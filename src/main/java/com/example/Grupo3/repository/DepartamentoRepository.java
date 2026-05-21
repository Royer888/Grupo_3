package com.example.Grupo3.repository;

import com.example.Grupo3.Entity.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Integer> {
}