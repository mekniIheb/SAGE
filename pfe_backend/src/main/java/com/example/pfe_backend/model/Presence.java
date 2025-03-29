package com.example.pfe_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "presence")
public class Presence {
    @Id
    private int matricule;
    private String nom;
    private LocalDate date;
    private String horaire;
    private String debut;
    private String fin;
    private String entree;
    private String sortie;
    private String presencePlaning;
    private String motif;
    private String departement;
}
