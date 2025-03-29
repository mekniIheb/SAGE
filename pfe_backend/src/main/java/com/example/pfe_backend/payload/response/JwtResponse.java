package com.example.pfe_backend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private int matricule;
    private String email;
    private String role;
    public JwtResponse(String accessToken, Long id, int matricule, String email, String role) {
        this.token = accessToken;
        this.id = id;
        this.matricule = matricule;
        this.email = email;
        this.role = role;
    }
}
