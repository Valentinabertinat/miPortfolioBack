package com.miPortfolio.miPortfolioWeb.service;


import com.miPortfolio.miPortfolioWeb.exception.UserNotFoundException;
import com.miPortfolio.miPortfolioWeb.model.Educacion;
import com.miPortfolio.miPortfolioWeb.model.Persona;
import com.miPortfolio.miPortfolioWeb.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class EducacionService {

    @Autowired
    EducacionRepository educacionRepository;

    public Educacion addEducacion(Educacion educacion){
        return educacionRepository.save(educacion);
    }

    public List<Educacion> findAllEducaciones(){
        return educacionRepository.findAll();
    }

    public Educacion updateEducacion(Educacion educacion){
        return educacionRepository.save(educacion);
    }

    public void deleteEducacion(Long id){
        educacionRepository.deleteEducacionById(id);
    }


    //ese ofnullable no estaba originalmente, pero me saltaba error. revisar video del morocho
    public Optional<Educacion> findEducacionById(Long id) {
        return Optional.ofNullable(educacionRepository.findEducacionById(id).
                orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found")));
    }


    //esto es igual al findallpersonas pero es de luigicode
    public Optional<Educacion> getOne(Long id) {
        return educacionRepository.findById(id);
    }


    public void save(Educacion educacion){
        educacionRepository.save(educacion);
    }
}
