package com.example.Grupo3.repository;

import com.example.Grupo3.Entity.ObjetoGastoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetoGastoRepository extends JpaRepository<ObjetoGastoEntity, String> {
}
