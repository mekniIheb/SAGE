package com.example.pfe_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Congee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "typeConge", nullable = false)
    private TypeCongee typeConge;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String motif;
    private String contact;
    private String telephone;
    @ManyToOne
    @JoinColumn(name = "matricule")
    private Employe employe;
}
