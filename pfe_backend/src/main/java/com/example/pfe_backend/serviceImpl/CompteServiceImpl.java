package com.example.pfe_backend.serviceImpl;

import com.example.pfe_backend.dto.CompteDto;
import com.example.pfe_backend.dto.EmployeDTO;
import com.example.pfe_backend.model.Compte;
import com.example.pfe_backend.model.Employe;
import com.example.pfe_backend.model.TypeCompte;
import com.example.pfe_backend.repository.CompteRepo;
import com.example.pfe_backend.service.CompteService;
import com.example.pfe_backend.service.EmployeService;
import com.example.pfe_backend.service.TypeCompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService {
    private final TypeCompteService typeCompteService;
    private final EmployeService employeService;
    private final CompteRepo compteRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public CompteDto saveCompte(CompteDto compteDto) {
        TypeCompte typeCompte = typeCompteService.getByType(compteDto.getType()).get();
        Employe employe = EmployeDTO.toEntity(employeService.getEmployeByMatricule(compteDto.getMatricule()));
        Compte compte = CompteDto.toEntity(compteDto, typeCompte, employe);
        Compte savedCompte = compteRepo.save(compte);
        return CompteDto.toDto(savedCompte);
    }

    @Override
    public CompteDto updateCompte(CompteDto compteDto) {
        TypeCompte typeCompte = typeCompteService.getByType(compteDto.getType()).get();
        Employe employe = EmployeDTO.toEntity(employeService.getEmployeByMatricule(compteDto.getMatricule()));
        Compte compte = CompteDto.toEntity(getCompteById(compteDto.getId()), typeCompte, employe);
        compte.setEmail(compteDto.getEmail());
        return CompteDto.toDto(compteRepo.save(compte));
    }

    @Override
    public CompteDto getCompteById(Long id) {
        Compte compte = compteRepo.findById(id).orElse(null);

        // If the Compte exists, map it to DTO, otherwise return null
        return (compte != null) ? CompteDto.toDto(compte) : null;
    }

    @Override
    public Page<CompteDto> getAllComptesPaged(Pageable pageable) {
        Page<Compte> comptePage = compteRepo.findAll(pageable);

        // Convert each Compte entity to DTO and return the paged result
        return comptePage.map(CompteDto::toDto);
    }

    @Override
    public void deleteCompte(Long id) {
        if (compteRepo.existsById(id)) {
            compteRepo.deleteById(id);
        }
    }
    public void updatePassword(Long compteId, String currentPassword, String newPassword) {
        Compte compte = compteRepo.findById(compteId).orElseThrow(() -> new RuntimeException("Compte non trouvé"));

        // Vérifier que l'ancien mot de passe est correct
        if (!passwordEncoder.matches(currentPassword, compte.getPassword())) {
            throw new RuntimeException("Mot de passe actuel incorrect");
        }

        // Encoder le nouveau mot de passe et le mettre à jour
        compte.setPassword(passwordEncoder.encode(newPassword));
        compteRepo.save(compte);
    }
}
