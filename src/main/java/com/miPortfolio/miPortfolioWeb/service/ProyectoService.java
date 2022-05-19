package com.miPortfolio.miPortfolioWeb.service;


import com.miPortfolio.miPortfolioWeb.exception.UserNotFoundException;
import com.miPortfolio.miPortfolioWeb.model.Persona;
import com.miPortfolio.miPortfolioWeb.model.Proyecto;
import com.miPortfolio.miPortfolioWeb.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class ProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;

    public Proyecto addProyecto(Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }

    public List<Proyecto> findAllProyectos(){
        return proyectoRepository.findAll();
    }

    public Proyecto updateProyecto(Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }

    public void deleteProyecto(Long id){
        proyectoRepository.deletePoyectoById(id);
    }


    //ese ofnullable no estaba originalmente, pero me saltaba error. revisar video del morocho
    public Optional<Proyecto> findProyectoById(Long id) {
        return Optional.ofNullable(proyectoRepository.findProyectoById(id).
                orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found")));
    }


    //esto es igual al findallpersonas pero es de luigicode


    public void save(Proyecto proyecto){
        proyectoRepository.save(proyecto);
    }
}
