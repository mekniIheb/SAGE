package com.example.pfe_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "employer")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employe {
    @Id
    @Column(name = "matricule")
    private int matricule;

    @Column(name = "id_wrd", nullable = false, length = 999)
    private String idWrd;

    @Column(name = "name", nullable = false, length = 999)
    private String name;

    @Column(name = "departement", nullable = false, length = 500)
    private String departement;

    @Column(name = "category", nullable = false, length = 400)
    private String category;

    @Column(name = "current_job", nullable = false, length = 400)
    private String currentJob;

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "projet", nullable = false, length = 999)
    private String projet;

    @Column(name = "team", nullable = false, length = 999)
    private String team;

    @Column(name = "poste", nullable = false, length = 999)
    private String poste;

    @Column(name = "sexe", nullable = false, length = 500)
    private String sexe;

    @Column(name = "level", nullable = false, length = 200)
    private String level;

    @Column(name = "marital_statut", nullable = false, length = 750)
    private String maritalStatut;

    @Column(name = "date_ancienne", nullable = false)
    private String dateAncienne;

    @Column(name = "date_naissance", nullable = false, length = 200)
    private String dateNaissance;

    @Column(name = "zrfz", nullable = false, length = 200)
    private String zrfz;

    @Column(name = "zfgrq", nullable = false, precision = 10, scale = 3)
    private BigDecimal zfgrq;

    @Column(name = "tranche_age", nullable = false, length = 200)
    private String trancheAge;

    @Column(name = "telephone", nullable = false, length = 8)
    private int telephone;

    @Column(name = "destination", nullable = false, length = 999)
    private String destination;

}
