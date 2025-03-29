package com.example.pfe_backend.serviceImpl;

import com.example.pfe_backend.model.NiveauxAttestation;
import com.example.pfe_backend.repository.NiveauAttestationRepo;
import com.example.pfe_backend.service.NiveauAttestationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NiveauAttestationServiceImpl implements NiveauAttestationService {
    private final NiveauAttestationRepo attestationRepo;

    @Override
    public NiveauxAttestation getNiveauAttestationById(Long id) {
        return attestationRepo.findById(id).get();
    }

    @Override
    public List<NiveauxAttestation> getListNiveauAttestation() {
        return attestationRepo.findAll();
    }
}
