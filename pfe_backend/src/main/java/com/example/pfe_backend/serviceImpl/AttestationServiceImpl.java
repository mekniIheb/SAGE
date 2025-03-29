package com.example.pfe_backend.serviceImpl;

import com.example.pfe_backend.dto.AttestationDto;
import com.example.pfe_backend.dto.EmployeDTO;
import com.example.pfe_backend.model.Attestation;
import com.example.pfe_backend.model.Employe;
import com.example.pfe_backend.model.TypeAttestation;
import com.example.pfe_backend.repository.AttestationRepo;
import com.example.pfe_backend.service.AttestationService;
import com.example.pfe_backend.service.EmployeService;
import com.example.pfe_backend.service.TypeAttestationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AttestationServiceImpl implements AttestationService {
    private final AttestationRepo attestationRepo;
    private final EmployeService employeService;
    private final TypeAttestationService typeAttestationService;

    @Override
    public AttestationDto saveAttestation(AttestationDto attestationDto) {
        Employe employer = EmployeDTO.toEntity(employeService.getEmployeByMatricule(attestationDto.getEmployerMatricule()));
        TypeAttestation typeAttestation = typeAttestationService.findByType(attestationDto.getType());
        Attestation attestation = AttestationDto.toEntity(attestationDto, employer, typeAttestation);
        Attestation savedAttestation = attestationRepo.save(attestation);
        return AttestationDto.toDTO(savedAttestation);
    }

    @Override
    public AttestationDto getAttestationById(int attestationId) {
        Attestation attestation = attestationRepo.findById((long) attestationId)
                .orElseThrow(() -> new EntityNotFoundException("Attestation not found"));
        return AttestationDto.toDTO(attestation);
    }

    @Override
    public Page<AttestationDto> getAllAttestationPaged(Pageable pageable) {
        Page<Attestation> attestations = attestationRepo.findAll(pageable);
        return attestations.map(AttestationDto::toDTO);
    }

    @Override
    public void deleteAttestation(int attestationId) {
        // Check if the attestation exists before deletion
        if (!attestationRepo.existsById((long) attestationId)) {
            throw new EntityNotFoundException("Attestation not found");
        }

        attestationRepo.deleteById((long) attestationId);
    }
}
