package com.example.pfe_backend.service;

import com.example.pfe_backend.dto.EmployeDTO;
import com.example.pfe_backend.payload.request.UpdateProfilRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeService {
    EmployeDTO saveEmploye(EmployeDTO employe);
    EmployeDTO updateProfilEmploye(EmployeDTO employeDTO);

    EmployeDTO getEmployeByMatricule(int matricule);

    Page<EmployeDTO> getAllEmployesPaged(Pageable pageable);

    void deleteEmploye(int matricule);
}
