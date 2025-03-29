package com.example.pfe_backend.serviceImpl;

import com.example.pfe_backend.model.TypeAttestation;
import com.example.pfe_backend.repository.TypeAttestationRepo;
import com.example.pfe_backend.service.TypeAttestationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeAttestationServiceImpl implements TypeAttestationService {
    private final TypeAttestationRepo typeAttestationRepo;

    @Override
    public TypeAttestation findByType(String type) {
        return typeAttestationRepo.findById(type).get();
    }

    @Override
    public List<TypeAttestation> getAllType() {
        return typeAttestationRepo.findAll();
    }
}
