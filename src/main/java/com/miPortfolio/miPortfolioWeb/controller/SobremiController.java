package com.miPortfolio.miPortfolioWeb.controller;


import com.miPortfolio.miPortfolioWeb.model.Educacion;
import com.miPortfolio.miPortfolioWeb.model.Sobremi;
import com.miPortfolio.miPortfolioWeb.service.SobremiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sobremi")
public class SobremiController {
    private final SobremiService sobremiService;

    public SobremiController(SobremiService sobremiService) {
        this.sobremiService = sobremiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sobremi>> getAllSobremis(){
        List<Sobremi> sobremis = sobremiService.findAllSobremis();
        return new ResponseEntity<>(sobremis, HttpStatus.OK);
    }

    //el optional lo agregue por un error, pero en el video no estaba asi este codigo. min 46//
    @GetMapping("/find/{id}")
    public ResponseEntity<Sobremi> getSobremiById(@PathVariable("id") Long id) {
        Optional<Sobremi> sobremi = sobremiService.findSobremiById(id);
        return new ResponseEntity(sobremi, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Sobremi> addSobremi(@RequestBody Sobremi sobremi){
        Sobremi sobremi1= sobremiService.addSobremi(sobremi);
        return new ResponseEntity<>(sobremi1, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Sobremi> updateSobremi(@RequestBody Sobremi sobremi){
        Sobremi updateSobremi = sobremiService.updateSobremi(sobremi);
        return new ResponseEntity<>(updateSobremi, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSobremi(@PathVariable("id") Long id){
        sobremiService.deleteSobremi(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

