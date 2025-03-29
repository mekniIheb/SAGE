package com.example.pfe_backend.payload.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateProfilRequest {
    private int matricule;
    private String nom;
    private int telephone;

}
