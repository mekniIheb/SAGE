package com.example.pfe_backend.serviceImpl;

import com.example.pfe_backend.model.TypeCompte;
import com.example.pfe_backend.repository.TypeCompteRepo;
import com.example.pfe_backend.service.TypeCompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeCompteServiceImpl implements TypeCompteService {
    private final TypeCompteRepo typeCompteRepo;

    @Override
    public Optional<TypeCompte> getByType(String type) {
        return Optional.of(typeCompteRepo.findById(type).get());
    }

    @Override
    public List<TypeCompte> getAllTypeCompte() {
        return typeCompteRepo.findAll();
    }
}
