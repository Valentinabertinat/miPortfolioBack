package com.miPortfolio.miPortfolioWeb.service;


import com.miPortfolio.miPortfolioWeb.exception.UserNotFoundException;
import com.miPortfolio.miPortfolioWeb.model.Educacion;
import com.miPortfolio.miPortfolioWeb.model.Sobremi;
import com.miPortfolio.miPortfolioWeb.repository.EducacionRepository;
import com.miPortfolio.miPortfolioWeb.repository.SobremiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SobremiService {
    @Autowired
    SobremiRepository sobremiRepository;

    public Sobremi addSobremi(Sobremi sobremi){
        return sobremiRepository.save(sobremi);
    }

    public List<Sobremi> findAllSobremis(){
        return sobremiRepository.findAll();
    }

    public Sobremi updateSobremi(Sobremi sobremi){
        return sobremiRepository.save(sobremi);
    }

    public void deleteSobremi(Long id){
        sobremiRepository.deleteSobremiById(id);
    }


    //ese ofnullable no estaba originalmente, pero me saltaba error. revisar video del morocho
    public Optional<Sobremi> findSobremiById(Long id) {
        return Optional.ofNullable(sobremiRepository.findSobremiById(id).
                orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found")));
    }


    //esto es igual al findallpersonas pero es de luigicode
    public Optional<Sobremi> getOne(Long id) {
        return sobremiRepository.findById(id);
    }


    public void save(Sobremi sobremi){
        sobremiRepository.save(sobremi);
    }
}

