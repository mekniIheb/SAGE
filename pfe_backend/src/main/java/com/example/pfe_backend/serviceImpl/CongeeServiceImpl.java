package com.example.pfe_backend.serviceImpl;

import com.example.pfe_backend.exception.CongeeNotFoundException;
import com.example.pfe_backend.model.Congee;
import com.example.pfe_backend.repository.CongeeRepo;
import com.example.pfe_backend.service.CongeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CongeeServiceImpl implements CongeeService {
    @Autowired
    private CongeeRepo congeeRepo;

    @Override
    public Congee saveCCongee(Congee congee) {
        return congeeRepo.save(congee);
    }

    @Override
    public Congee getECongeeById(Long id) {
        return congeeRepo.findById(id)
                .orElseThrow(() -> new CongeeNotFoundException("Congee not found with id: " + id));
    }

    @Override
    public Page<Congee> getAllCongeePaged(Pageable pageable) {
        return congeeRepo.findAll(pageable);
    }

    @Override
    public void deleteCompte(Long id) {
        congeeRepo.deleteById(id);
    }
}
