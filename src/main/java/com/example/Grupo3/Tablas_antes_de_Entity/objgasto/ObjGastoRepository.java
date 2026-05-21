package com.example.Grupo3.Tablas_antes_de_Entity.objgasto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjGastoRepository extends JpaRepository<ObjGasto, Long> {
}