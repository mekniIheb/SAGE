package com.example.pfe_backend.controller;

import com.example.pfe_backend.dto.EmployeDTO;
import com.example.pfe_backend.payload.request.UpdateProfilRequest;
import com.example.pfe_backend.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employes")
public class EmployeController {

    private final EmployeService employeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeDTO> saveEmploye(@RequestBody EmployeDTO employeDTO) {
        EmployeDTO savedEmployeDTO = employeService.saveEmploye(employeDTO);
        return ResponseEntity.status(201).body(savedEmployeDTO);
    }
    @PutMapping("/update-profile")
    public ResponseEntity<EmployeDTO> updateProfilEmploye(@RequestBody EmployeDTO employeDTO) {
        EmployeDTO updatedEmploye = employeService.updateProfilEmploye(employeDTO);
        return new ResponseEntity<>(updatedEmploye, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<Page<EmployeDTO>> getAllEmployesPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<EmployeDTO> employes = employeService.getAllEmployesPaged(pageable);
        return ResponseEntity.ok(employes);
    }

    @DeleteMapping("/delete/{matricule}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable int matricule) {
        employeService.deleteEmploye(matricule);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{matricule}")
    public ResponseEntity<EmployeDTO> getEmployeByMatricule(@PathVariable int matricule) {
        EmployeDTO employeDTO = employeService.getEmployeByMatricule(matricule);
        return ResponseEntity.ok(employeDTO);
    }
}
