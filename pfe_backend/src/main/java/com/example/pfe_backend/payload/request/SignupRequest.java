package com.example.pfe_backend.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
    private int matricule;
    private String email;
    private String role;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
