package com.example.pfe_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "type_demande")
public class TypeAttestation {
    @Id
    private String type;
}
