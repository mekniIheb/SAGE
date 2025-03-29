package com.example.pfe_backend.repository;

import com.example.pfe_backend.model.TypeCongee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCongeeRepo extends JpaRepository<TypeCongee, String> {
}
