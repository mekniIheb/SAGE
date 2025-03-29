package com.example.pfe_backend.repository;

import com.example.pfe_backend.model.Presence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenceRepo extends JpaRepository<Presence, Integer> {
}
