package com.miPortfolio.miPortfolioWeb.service;

import com.miPortfolio.miPortfolioWeb.exception.UserNotFoundException;
import com.miPortfolio.miPortfolioWeb.model.Persona;
import com.miPortfolio.miPortfolioWeb.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public Persona addPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public List<Persona> findAllPersonas(){
        return personaRepository.findAll();
    }

    public Persona updatePersona(Persona persona){
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id){
        personaRepository.deletePersonaById(id);
    }

    public Optional<Persona> findPersonaById(Long id) {
        return Optional.ofNullable(personaRepository.findPersonaById(id).
                orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found")));
    }


    //esto es igual al findallpersonas pero es de luigicode
    public Optional<Persona> getOne(Long id) {
        return personaRepository.findById(id);
    }


    public void save(Persona persona){
        personaRepository.save(persona);
    }
}
