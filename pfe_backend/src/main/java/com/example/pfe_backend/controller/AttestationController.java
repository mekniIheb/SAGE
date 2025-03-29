package com.example.pfe_backend.controller;

import com.example.pfe_backend.dto.AttestationDto;
import com.example.pfe_backend.service.AttestationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attestations")
public class AttestationController {
    private final AttestationService attestationService;

    public AttestationController(AttestationService attestationService) {
        this.attestationService = attestationService;
    }
    @PostMapping
    public ResponseEntity<AttestationDto> createAttestation(@RequestBody AttestationDto attestationDto) {
        AttestationDto createdAttestation = attestationService.saveAttestation(attestationDto);
        return new ResponseEntity<>(createdAttestation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttestationDto> getAttestationById(@PathVariable("id") int attestationId) {
        AttestationDto attestationDto = attestationService.getAttestationById(attestationId);
        return new ResponseEntity<>(attestationDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<AttestationDto>> getAllAttestations(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AttestationDto> attestationDtos = attestationService.getAllAttestationPaged(pageable);
        return new ResponseEntity<>(attestationDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttestation(@PathVariable("id") int attestationId) {
        attestationService.deleteAttestation(attestationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
