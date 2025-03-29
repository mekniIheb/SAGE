package com.example.pfe_backend.controller;

import com.example.pfe_backend.model.NiveauxAttestation;
import com.example.pfe_backend.service.NiveauAttestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/niveaux-attestation")
public class NiveauAttestationController {

    private final NiveauAttestationService niveauAttestationService;

    @Autowired
    public NiveauAttestationController(NiveauAttestationService niveauAttestationService) {
        this.niveauAttestationService = niveauAttestationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NiveauxAttestation> getNiveauAttestationById(@PathVariable Long id) {
        NiveauxAttestation attestation = niveauAttestationService.getNiveauAttestationById(id);
        return attestation != null ? ResponseEntity.ok(attestation) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<NiveauxAttestation>> getAllNiveauxAttestation() {
        List<NiveauxAttestation> attestations = niveauAttestationService.getListNiveauAttestation();
        return ResponseEntity.ok(attestations);
    }
}
