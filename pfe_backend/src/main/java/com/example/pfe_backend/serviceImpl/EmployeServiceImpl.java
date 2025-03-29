package com.example.pfe_backend.serviceImpl;

import com.example.pfe_backend.dto.EmployeDTO;
import com.example.pfe_backend.exception.EmployeNotFoundException;
import com.example.pfe_backend.model.Employe;
import com.example.pfe_backend.payload.request.UpdateProfilRequest;
import com.example.pfe_backend.repository.EmployeRepo;
import com.example.pfe_backend.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeServiceImpl implements EmployeService {
    private final EmployeRepo employeRepo;

    @Override
    public EmployeDTO saveEmploye(EmployeDTO employeDTO) {
        Employe employe = EmployeDTO.toEntity(employeDTO);
        Employe savedEmploye = employeRepo.save(employe);
        return EmployeDTO.toDTO(savedEmploye);
    }

    @Override
    public EmployeDTO updateProfilEmploye(EmployeDTO employeDTO) {
        Employe employe = EmployeDTO.toEntity(getEmployeByMatricule(employeDTO.getMatricule()));
        employe.setName(employeDTO.getName());
        employe.setTelephone(employeDTO.getTelephone());
        return EmployeDTO.toDTO(employeRepo.save(employe));
    }

    @Override
    public EmployeDTO getEmployeByMatricule(int matricule) {
        return EmployeDTO.toDTO(employeRepo.findById(matricule)
                .orElseThrow(() -> new EmployeNotFoundException("Employe not found with matricule: " + matricule)));
    }

    @Override
    public Page<EmployeDTO> getAllEmployesPaged(Pageable pageable) {
        return employeRepo.findAll(pageable)
                .map(EmployeDTO::toDTO);
    }


    @Override
    public void deleteEmploye(int matricule) {
        employeRepo.deleteById(matricule);
    }
}
