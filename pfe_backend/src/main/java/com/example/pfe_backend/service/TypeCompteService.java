package com.example.pfe_backend.service;

import com.example.pfe_backend.model.TypeCompte;

import java.util.List;
import java.util.Optional;

public interface TypeCompteService {
    Optional<TypeCompte> getByType(String type);
    List<TypeCompte> getAllTypeCompte();
}
