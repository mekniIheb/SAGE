package com.example.pfe_backend.repository;



import com.example.pfe_backend.model.Compte;
import com.example.pfe_backend.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRepo extends JpaRepository<Compte, Long> {
    Optional<Compte> findByEmployer_Matricule(int employer_matricule);
    Optional<Compte> findByEmployerMatricule(int matricule);
    Boolean existsByEmployer(Employe employe);
}
