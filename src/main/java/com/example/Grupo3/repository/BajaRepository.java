package com.example.Grupo3.repository;

import com.example.Grupo3.Entity.BajaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BajaRepository extends JpaRepository<BajaEntity, Long> {
}
