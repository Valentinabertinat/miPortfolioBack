package com.miPortfolio.miPortfolioWeb.controller;


import com.miPortfolio.miPortfolioWeb.model.Educacion;
import com.miPortfolio.miPortfolioWeb.model.Persona;
import com.miPortfolio.miPortfolioWeb.service.EducacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/educacion")
public class EducacionController {
    private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Educacion>> getAllEducaciones(){
        List<Educacion> educaciones = educacionService.findAllEducaciones();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }

    //el optional lo agregue por un error, pero en el video no estaba asi este codigo. min 46//
    @GetMapping("/find/{id}")
    public ResponseEntity<Educacion> getEducacionById(@PathVariable("id") Long id) {
        Optional<Educacion> educacion = educacionService.findEducacionById(id);
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Educacion> addEducacion(@RequestBody Educacion educacion){
        Educacion educacion1= educacionService.addEducacion(educacion);
        return new ResponseEntity<>(educacion1, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Educacion> updateEducacion(@RequestBody Educacion educacion){
        Educacion updateEducacion = educacionService.updateEducacion(educacion);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable("id") Long id){
        educacionService.deleteEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
