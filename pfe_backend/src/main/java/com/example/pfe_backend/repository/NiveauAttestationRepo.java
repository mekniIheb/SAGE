package com.example.pfe_backend.repository;

import com.example.pfe_backend.model.NiveauxAttestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauAttestationRepo extends JpaRepository<NiveauxAttestation, Long> {
}
