package com.example.Grupo3.repository;

import com.example.Grupo3.Entity.OrganismoFinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganismoFinRepository extends JpaRepository<OrganismoFinEntity, String> {
    // String porque "of" es String ("111", "112"...)
}