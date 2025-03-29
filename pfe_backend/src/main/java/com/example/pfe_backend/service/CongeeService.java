package com.example.pfe_backend.service;

import com.example.pfe_backend.dto.CompteDto;
import com.example.pfe_backend.model.Congee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CongeeService {
    Congee saveCCongee(Congee congee);

    Congee getECongeeById(Long id);

    Page<Congee> getAllCongeePaged(Pageable pageable);

    void deleteCompte(Long id);
}
