package com.example.pfe_backend.controller;

import com.example.pfe_backend.model.Congee;
import com.example.pfe_backend.service.CongeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/congees")
@AllArgsConstructor
public class CongeeController {

    private final CongeeService congeeService;

    @PostMapping
    public ResponseEntity<Congee> createCongee(@RequestBody Congee congee) {
        Congee savedCongee = congeeService.saveCCongee(congee);
        return new ResponseEntity<>(savedCongee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Congee> getCongeeById(@PathVariable Long id) {
        Congee congee = congeeService.getECongeeById(id);
        return new ResponseEntity<>(congee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Congee>> getAllCongeePaged(Pageable pageable) {
        Page<Congee> congees = congeeService.getAllCongeePaged(pageable);
        return new ResponseEntity<>(congees, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCongee(@PathVariable Long id) {
        congeeService.deleteCompte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
