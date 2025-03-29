package com.example.pfe_backend.repository;


import com.example.pfe_backend.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepo extends JpaRepository<Employe, Integer> {

    boolean existsByMatricule(int matricule);
}
