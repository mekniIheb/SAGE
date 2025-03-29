package com.example.pfe_backend.repository;

import com.example.pfe_backend.model.Congee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeeRepo extends JpaRepository<Congee, Long> {
}
