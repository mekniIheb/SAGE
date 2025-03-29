package com.example.pfe_backend.controller;

import com.example.pfe_backend.model.TypeAttestation;
import com.example.pfe_backend.service.TypeAttestationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/typeAttestations")
public class TypeAttestationController {
    private final TypeAttestationService typeAttestationService;

    @GetMapping("/{type}")
    public ResponseEntity<TypeAttestation> getTypeAttestationType(@PathVariable String type) {
        return ResponseEntity.ok(typeAttestationService.findByType(type));
    }
    @GetMapping("/all")
    public ResponseEntity<List<TypeAttestation>> getAllTypeAttestationType() {
        return ResponseEntity.ok(typeAttestationService.getAllType());
    }

}
