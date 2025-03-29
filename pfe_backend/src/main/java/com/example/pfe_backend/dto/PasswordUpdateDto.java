package com.example.pfe_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordUpdateDto {
    private String currentPassword;
    private String newPassword;
}
