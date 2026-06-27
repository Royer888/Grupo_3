package com.example.Grupo3.repository;

import com.example.Grupo3.Entity.UnidadAdministrativaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadAdministrativaRepository extends JpaRepository<UnidadAdministrativaEntity, Long> {
}
