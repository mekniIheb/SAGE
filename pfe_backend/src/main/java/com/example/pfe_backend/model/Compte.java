package com.example.pfe_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, length = 999)
    private String email;

    @Column(name = "password", nullable = false, length = 999)
    private String password;

    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private TypeCompte type;

    @ManyToOne
    @JoinColumn(name = "matricule", nullable = false)
    private Employe employer;
    @CreatedDate
    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;

    public Compte(String email, Employe employer, TypeCompte type, String password,LocalDate dateCreation) {
        this.email = email;
        this.password = password;
        this.type = type;
        this.employer = employer;
        this.dateCreation=dateCreation;
    }


}
