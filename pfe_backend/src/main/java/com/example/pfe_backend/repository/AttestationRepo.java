package com.example.pfe_backend.repository;

import com.example.pfe_backend.model.Attestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttestationRepo extends JpaRepository<Attestation, Long> {
}
