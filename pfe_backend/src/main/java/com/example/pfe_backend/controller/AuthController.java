package com.example.pfe_backend.controller;

import com.example.pfe_backend.dto.EmployeDTO;
import com.example.pfe_backend.exception.AuthenticationFailedException;
import com.example.pfe_backend.model.Compte;
import com.example.pfe_backend.payload.request.LoginRequest;
import com.example.pfe_backend.payload.request.SignupRequest;
import com.example.pfe_backend.payload.response.JwtResponse;
import com.example.pfe_backend.payload.response.MessageResponse;
import com.example.pfe_backend.repository.CompteRepo;
import com.example.pfe_backend.repository.EmployeRepo;
import com.example.pfe_backend.repository.TypeCompteRepo;
import com.example.pfe_backend.security.jwt.JwtUtils;
import com.example.pfe_backend.security.services.UserDetailsImpl;
import com.example.pfe_backend.service.EmployeService;
import com.example.pfe_backend.service.TypeCompteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    EmployeRepo employeRepo;
    @Autowired
    CompteRepo compteRepo;
    @Autowired
    TypeCompteRepo typeCompteRepo;
    @Autowired
    EmployeService employeService;
    @Autowired
    TypeCompteService typeCompteService;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (compteRepo.existsByEmployer(EmployeDTO.toEntity(employeService.getEmployeByMatricule(signUpRequest.getMatricule())))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: matricule is already taken!"));
        }
        if (!typeCompteRepo.existsById(signUpRequest.getRole())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Role not found!"));
        }
        // Create new user's account
        Compte user = new Compte(signUpRequest.getEmail(),
                employeRepo.findById(signUpRequest.getMatricule()).get(),
                typeCompteRepo.findById(signUpRequest.getRole()).get(),
                encoder.encode(signUpRequest.getPassword()),
                LocalDate.now()
        );

        compteRepo.save(user);

        return ResponseEntity.ok(new MessageResponse("Compte registered successfully!"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getMatricule(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    Integer.parseInt(userDetails.getUsername()),
                    userDetails.getEmail(),
                    userDetails.getRole()));
        } catch (AuthenticationException e) {
            throw new AuthenticationFailedException("Invalid matricule or password");
        }
    }

}
