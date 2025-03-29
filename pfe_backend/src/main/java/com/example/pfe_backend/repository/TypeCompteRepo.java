package com.example.pfe_backend.repository;


import com.example.pfe_backend.model.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCompteRepo extends JpaRepository<TypeCompte, String> {
}
