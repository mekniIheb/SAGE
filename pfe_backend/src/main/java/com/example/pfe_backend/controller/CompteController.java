package com.example.pfe_backend.controller;

import com.example.pfe_backend.dto.CompteDto;
import com.example.pfe_backend.dto.PasswordUpdateDto;
import com.example.pfe_backend.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    private final CompteService compteService;

    @Autowired
    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<CompteDto> getCompteById(@PathVariable Long id) {
        CompteDto compteDto = compteService.getCompteById(id);
        return compteDto != null ? ResponseEntity.ok(compteDto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<CompteDto>> getAllComptesPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CompteDto> comptes = compteService.getAllComptesPaged(pageable);
        return ResponseEntity.ok(comptes);
    }

    @PutMapping("/update")
    public ResponseEntity<CompteDto> updateCompte(@RequestBody CompteDto compteDto) {
        try {
            CompteDto updatedCompte = compteService.updateCompte(compteDto);
            return ResponseEntity.ok(updatedCompte);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompte(@PathVariable Long id) {
        if (compteService.getCompteById(id) != null) {
            compteService.deleteCompte(id);
            return ResponseEntity.noContent().build(); // Return 204 No Content on successful deletion
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePassword(
            @PathVariable Long id,
            @RequestBody PasswordUpdateDto passwordUpdateDto) {

        try {
            compteService.updatePassword(id, passwordUpdateDto.getCurrentPassword(), passwordUpdateDto.getNewPassword());
            return ResponseEntity.ok("Mot de passe mis à jour avec succès");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

