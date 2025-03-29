package com.example.pfe_backend.repository;

import com.example.pfe_backend.model.TypeAttestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAttestationRepo extends JpaRepository<TypeAttestation,String> {
}
