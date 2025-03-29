package com.example.pfe_backend.dto;

import com.example.pfe_backend.model.Attestation;
import com.example.pfe_backend.model.Employe;
import com.example.pfe_backend.model.TypeAttestation;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class AttestationDto {
    private Long attestationId;
    private String type;
    private String attestationDe;
    private String objet;
    private int employerMatricule;
    private LocalDate dateEnvoyer;
    public static AttestationDto toDTO(Attestation attestation) {
        AttestationDto dto = new AttestationDto();
        dto.setAttestationId(attestation.getAttestationId());
        dto.setType(attestation.getTypeAttestation().getType());
        dto.setAttestationDe(attestation.getAttestationDe());
        dto.setObjet(attestation.getObjet());
        dto.setEmployerMatricule(attestation.getEmployer().getMatricule());
        dto.setDateEnvoyer(attestation.getDateEnvoyer());
        return dto;
    }
    public static Attestation toEntity(AttestationDto dto, Employe employer, TypeAttestation typeAttestation) {
        Attestation attestation = new Attestation();
        attestation.setAttestationId(dto.getAttestationId());

        attestation.setTypeAttestation(typeAttestation);
        attestation.setAttestationDe(dto.getAttestationDe());
        attestation.setObjet(dto.getObjet());
        attestation.setEmployer(employer);

        attestation.setDateEnvoyer(dto.getDateEnvoyer());
        return attestation;
    }

}
