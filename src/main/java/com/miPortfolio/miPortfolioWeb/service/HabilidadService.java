package com.miPortfolio.miPortfolioWeb.service;


import com.miPortfolio.miPortfolioWeb.exception.UserNotFoundException;
import com.miPortfolio.miPortfolioWeb.model.Habilidad;
import com.miPortfolio.miPortfolioWeb.model.Proyecto;
import com.miPortfolio.miPortfolioWeb.repository.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class HabilidadService {
    @Autowired
    HabilidadRepository habilidadRepository;

    public Habilidad addHabilidad(Habilidad habilidad){
        return habilidadRepository.save(habilidad);
    }

    public List<Habilidad> findAllHabilidades(){
        return habilidadRepository.findAll();
    }

    public Habilidad updateHabilidad(Habilidad habilidad){
        return habilidadRepository.save(habilidad);
    }

    public void deleteHabilidad(Long id){
        habilidadRepository.deleteHabilidadById(id);
    }

    //ese ofnullable no estaba originalmente, pero me saltaba error. revisar video del morocho
    public Optional<Habilidad> findHabilidadById(Long id) {
        return Optional.ofNullable(habilidadRepository.findHabilidadById(id).
                orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found")));
    }

    //esto es igual al findallpersonas pero es de luigicode
    public Optional<Habilidad> getOne(Long id) {
        return habilidadRepository.findById(id);
    }

    public void save(Habilidad habilidad){
        habilidadRepository.save(habilidad);
    }
}

