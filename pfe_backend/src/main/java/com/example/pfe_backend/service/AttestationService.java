package com.example.pfe_backend.service;

import com.example.pfe_backend.dto.AttestationDto;
import com.example.pfe_backend.dto.AttestationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AttestationService {
    AttestationDto saveAttestation(AttestationDto attestationDto);

    AttestationDto getAttestationById(int attestationId);

    Page<AttestationDto> getAllAttestationPaged(Pageable pageable);

    void deleteAttestation(int attestationId);
}
