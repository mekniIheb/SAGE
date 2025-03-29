package com.example.pfe_backend.service;

import com.example.pfe_backend.dto.CompteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompteService {
    CompteDto saveCompte(CompteDto compteDto);
    CompteDto updateCompte(CompteDto compteDto);

    CompteDto getCompteById(Long id);

    Page<CompteDto> getAllComptesPaged(Pageable pageable);

    void deleteCompte(Long id);
    void updatePassword(Long compteId, String currentPassword, String newPassword);
}
