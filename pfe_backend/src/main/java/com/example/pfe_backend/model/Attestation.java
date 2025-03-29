package com.example.pfe_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Attestation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long attestationId;
    @ManyToOne
    @JoinColumn(name = "type")
    private TypeAttestation typeAttestation;
    @Column(name = "attestation_de", nullable = false, length = 150)
    private String attestationDe;
    private String objet;
    @ManyToOne
    @JoinColumn(name = "matricule", nullable = false)
    private Employe employer;
    private LocalDate dateEnvoyer;
}
