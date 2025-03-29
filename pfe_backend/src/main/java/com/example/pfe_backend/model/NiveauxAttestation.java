package com.example.pfe_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "niveaux_attestation")
public class NiveauxAttestation {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private  Long niveauxAttestationId;
    private int rh;
    private int manager;
    private int matricule;

}
