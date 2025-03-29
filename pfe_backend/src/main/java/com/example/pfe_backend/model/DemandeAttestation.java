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
@Table(name = "demande_attestation")
public class DemandeAttestation {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_attestation", nullable = false)
    private Attestation attestation;

    @ManyToOne
    @JoinColumn(name = "id_niveaux", nullable = false)
    private NiveauxAttestation niveaux;

    @Column(name = "etat_manager", nullable = false)
    private boolean etatManager;

    @Column(name = "etat_rh", nullable = false)
    private boolean etatRh;
}
