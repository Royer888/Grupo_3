package com.example.Grupo3.repository;

import com.example.Grupo3.Entity.MesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesRepository extends JpaRepository<MesEntity, Long> {
}