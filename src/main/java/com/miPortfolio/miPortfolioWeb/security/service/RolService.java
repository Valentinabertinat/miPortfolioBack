package com.miPortfolio.miPortfolioWeb.security.service;

import com.miPortfolio.miPortfolioWeb.security.enums.RolNombre;
import com.miPortfolio.miPortfolioWeb.security.model.Rol;
import com.miPortfolio.miPortfolioWeb.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
