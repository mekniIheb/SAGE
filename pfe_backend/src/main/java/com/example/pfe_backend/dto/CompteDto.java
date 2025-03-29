package com.example.pfe_backend.dto;

import com.example.pfe_backend.model.Compte;
import com.example.pfe_backend.model.Employe;
import com.example.pfe_backend.model.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CompteDto {
    private Long id;
    private String email;
    private String password;
    private String type;
    private int matricule;
    private LocalDate dateCreation;

    public static CompteDto toDto(Compte compte) {
        if (compte == null) {
            return null;
        }

        return new CompteDto(
                compte.getId(),
                compte.getEmail(),
                compte.getPassword(),
                compte.getType().getType(),
                EmployeDTO.toDTO(compte.getEmployer()).getMatricule(),
                compte.getDateCreation()
        );
    }

    public static Compte toEntity(CompteDto dto, TypeCompte typeCompte, Employe employe) {
        if (dto == null) {
            return null;
        }

        Compte compte = new Compte();
        compte.setId(dto.getId());
        compte.setEmail(dto.getEmail());
        compte.setPassword(dto.getPassword());
        compte.setType(typeCompte);
        compte.setEmployer(employe);
        compte.setDateCreation(dto.getDateCreation());

        return compte;
    }
}
