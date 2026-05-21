package com.example.Grupo3.objgasto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjGastoRepository extends JpaRepository<ObjGasto, Long> {
}