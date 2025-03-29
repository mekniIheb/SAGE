package com.example.pfe_backend.security.services;


import com.example.pfe_backend.model.Compte;
import com.example.pfe_backend.repository.CompteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private CompteRepo compteRepository;


  @Override
  public UserDetails loadUserByUsername(String matricule) throws UsernameNotFoundException {
    Compte compte = compteRepository.findByEmployer_Matricule(Integer.parseInt(matricule))
            .orElseThrow(() -> new UsernameNotFoundException("Compte not found with matricule: " + matricule));

    return UserDetailsImpl.buildCompte(compte);
  }
}
