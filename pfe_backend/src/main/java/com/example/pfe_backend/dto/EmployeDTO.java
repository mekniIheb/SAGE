package com.example.pfe_backend.dto;

import com.example.pfe_backend.model.Employe;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class EmployeDTO {
    private int matricule;
    private String idWrd;
    private String name;
    private String departement;
    private String category;
    private String currentJob;
    private String startDate;
    private String projet;
    private String team;
    private String poste;
    private String sexe;
    private String level;
    private String maritalStatut;
    private String dateAncienne;
    private String dateNaissance;
    private String zrfz;
    private BigDecimal zfgrq;
    private String trancheAge;
    private int telephone;
    private String destination;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static EmployeDTO toDTO(Employe employe) {
        EmployeDTO dto = new EmployeDTO();
        dto.setMatricule(employe.getMatricule());
        dto.setIdWrd(employe.getIdWrd());
        dto.setName(employe.getName());
        dto.setDepartement(employe.getDepartement());
        dto.setCategory(employe.getCategory());
        dto.setCurrentJob(employe.getCurrentJob());

        dto.setProjet(employe.getProjet());
        dto.setTeam(employe.getTeam());
        dto.setPoste(employe.getPoste());
        dto.setSexe(employe.getSexe());
        dto.setLevel(employe.getLevel());
        dto.setMaritalStatut(employe.getMaritalStatut());

        // Handle zero or invalid dates
        dto.setDateAncienne(employe.getDateAncienne().toString());
        dto.setDateNaissance(employe.getDateNaissance().toString());
        dto.setZrfz(employe.getZrfz().toString());
        dto.setStartDate(employe.getStartDate().toString());

        dto.setZfgrq(employe.getZfgrq());
        dto.setTrancheAge(employe.getTrancheAge());
        dto.setTelephone(employe.getTelephone());
        dto.setDestination(employe.getDestination());
        return dto;
    }

    private static boolean isValidDate(LocalDate date) {
        return date != null && !date.isEqual(LocalDate.of(0, 1, 1)); // Adjust this check based on your zero date representation
    }


    public static Employe toEntity(EmployeDTO dto) {
        Employe employe = new Employe();
        employe.setMatricule(dto.getMatricule());
        employe.setIdWrd(dto.getIdWrd());
        employe.setName(dto.getName());
        employe.setDepartement(dto.getDepartement());
        employe.setCategory(dto.getCategory());
        employe.setCurrentJob(dto.getCurrentJob());

        employe.setProjet(dto.getProjet());
        employe.setTeam(dto.getTeam());
        employe.setPoste(dto.getPoste());
        employe.setSexe(dto.getSexe());
        employe.setLevel(dto.getLevel());
        employe.setMaritalStatut(dto.getMaritalStatut());
        employe.setDateAncienne(dto.getDateAncienne());
        employe.setDateNaissance(dto.getDateNaissance());
        employe.setZrfz(dto.getZrfz());
        employe.setStartDate(dto.getStartDate());
        employe.setZfgrq(dto.getZfgrq());
        employe.setTrancheAge(dto.getTrancheAge());
        employe.setTelephone(dto.getTelephone());
        employe.setDestination(dto.getDestination());
        return employe;
    }

}
