package com.example.pfe_backend.service;

import com.example.pfe_backend.model.TypeAttestation;

import java.util.List;

public interface TypeAttestationService {
    TypeAttestation findByType(String type);
    List<TypeAttestation> getAllType();

}
