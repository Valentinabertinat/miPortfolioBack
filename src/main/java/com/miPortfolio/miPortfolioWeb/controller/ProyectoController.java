package com.miPortfolio.miPortfolioWeb.controller;


import com.miPortfolio.miPortfolioWeb.model.Persona;
import com.miPortfolio.miPortfolioWeb.model.Proyecto;
import com.miPortfolio.miPortfolioWeb.service.ProyectoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/proyecto")
public class ProyectoController {
    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Proyecto>> getAllProyectos(){
        List<Proyecto> proyectos = proyectoService.findAllProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    //el optional lo agregue por un error, pero en el video no estaba asi este codigo. min 46//
    @GetMapping("/find/{id}")
    public ResponseEntity<Proyecto> getProyectoById(@PathVariable("id") Long id) {
        Optional<Proyecto> proyecto = proyectoService.findProyectoById(id);
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Proyecto> addProyecto(@RequestBody Proyecto proyecto){
        Proyecto proyecto1 = proyectoService.addProyecto(proyecto);
        return new ResponseEntity<>(proyecto1, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Proyecto> updateProyecto(@RequestBody Proyecto proyecto){
        Proyecto updateProyecto = proyectoService.updateProyecto(proyecto);
        return new ResponseEntity<>(updateProyecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProyecto(@PathVariable("id") Long id){
        proyectoService.deleteProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
