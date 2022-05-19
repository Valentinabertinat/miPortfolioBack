package com.miPortfolio.miPortfolioWeb.controller;


import com.miPortfolio.miPortfolioWeb.model.Persona;
import com.miPortfolio.miPortfolioWeb.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/persona")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Persona>> getAllPersonas(){
        List<Persona> personas = personaService.findAllPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    //el optional lo agregue por un error, pero en el video no estaba asi este codigo. min 46//
    @GetMapping("/find/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable("id") Long id) {
        Optional<Persona> persona = personaService.findPersonaById(id);
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona){
      Persona persona1 = personaService.addPersona(persona);
      return new ResponseEntity<>(persona1, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona){
        Persona updatePersona = personaService.updatePersona(persona);
        return new ResponseEntity<>(updatePersona, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable("id") Long id){
        personaService.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}




