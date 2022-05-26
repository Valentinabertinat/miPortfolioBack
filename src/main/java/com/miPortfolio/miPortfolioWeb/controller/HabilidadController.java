package com.miPortfolio.miPortfolioWeb.controller;

import com.miPortfolio.miPortfolioWeb.model.Educacion;
import com.miPortfolio.miPortfolioWeb.model.Habilidad;
import com.miPortfolio.miPortfolioWeb.service.HabilidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/habilidad")
public class HabilidadController {
    private final HabilidadService habilidadService;

    public HabilidadController(HabilidadService habilidadService) {
        this.habilidadService = habilidadService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Habilidad>> getAllHabilidades(){
        List<Habilidad> habilidades = habilidadService.findAllHabilidades();
        return new ResponseEntity<>(habilidades, HttpStatus.OK);
    }

    //el optional lo agregue por un error, pero en el video no estaba asi este codigo. min 46//
    @GetMapping("/find/{id}")
    public ResponseEntity<Habilidad> getHabilidadById(@PathVariable("id") Long id) {
        Optional<Habilidad> habilidad = habilidadService.findHabilidadById(id);
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }


    //este postmapping no es del morocho, es un video de yt nuevo.
    @PostMapping("/add")
    public ResponseEntity<Habilidad> addHabilidad(@RequestBody Habilidad habilidad){
        Habilidad habilidad1= habilidadService.addHabilidad(habilidad);
        return new ResponseEntity<>(habilidad1, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Habilidad> updateHabilidad(@RequestBody Habilidad habilidad){
        Habilidad updateHabilidad = habilidadService.updateHabilidad(habilidad);
        return new ResponseEntity<>(updateHabilidad, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHabilidad(@PathVariable("id") Long id){
        habilidadService.deleteHabilidad(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
