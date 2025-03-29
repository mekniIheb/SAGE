package com.example.pfe_backend.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private int matricule;
    @NotBlank
    private String password;
}
