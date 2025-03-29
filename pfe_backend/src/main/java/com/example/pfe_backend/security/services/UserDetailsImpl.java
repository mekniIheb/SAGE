package com.example.pfe_backend.security.services;


import com.example.pfe_backend.model.Compte;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String username;

  private String email;
  private String role;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(Long id, String username, String email, String password,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }


  public static UserDetailsImpl buildCompte(Compte compte) {
    // Assuming TypeCompte contains a method to retrieve roles
    List<GrantedAuthority> authorities = Collections.singletonList(
            new SimpleGrantedAuthority(compte.getType().getType()) // Assuming TypeCompte has a getRoleName method
    );

    return new UserDetailsImpl(
            compte.getId(),
            String.valueOf(compte.getEmployer().getMatricule()), // Use matricule from Employe
            compte.getEmail(),
            compte.getPassword(),
            authorities
    );
  }
  public String getRole() {
    // Assuming there's only one role, adjust if there are multiple
    return authorities.stream().findFirst().map(GrantedAuthority::getAuthority).orElse(null);
  }
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }


  public void setRole(String role) {
    this.role = role;
  }
}
