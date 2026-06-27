package com.example.Grupo3.repository;

import com.example.Grupo3.Entity.EntidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadRepository extends JpaRepository<EntidadEntity, String> {
}
