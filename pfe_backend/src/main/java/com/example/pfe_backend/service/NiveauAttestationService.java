package com.example.pfe_backend.service;

import com.example.pfe_backend.model.NiveauxAttestation;

import java.util.List;

public interface NiveauAttestationService {
    NiveauxAttestation getNiveauAttestationById(Long id);
    List<NiveauxAttestation> getListNiveauAttestation();
}
