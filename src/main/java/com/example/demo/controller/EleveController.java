package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Eleve;
import com.example.demo.services.EleveService;

@RestController("/api/v1/eleves")
public class EleveController {
	@Autowired
    private EleveService  eleveService;

   
    
    @GetMapping("/tousleseleves")
    public ResponseEntity<List<Eleve>> getAllEleve() {
        List<Eleve> eleves = eleveService.getAllEleves();
        return new ResponseEntity<>(eleves, HttpStatus.OK);
    }
    @PostMapping("ajouterEleve")
	public  ResponseEntity<Eleve> createEleve(@RequestBody Eleve eleve) {
    	Eleve createdEleve = eleveService.createEleve(eleve);
        return new ResponseEntity<>(createdEleve, HttpStatus.CREATED);
    }
   /* @PutMapping("/modifier/{id}")
    public ResponseEntity<Eleve> updateEleve(@PathVariable("id") Long id,
                                                                 @RequestBody Eleve eleve ) {
       Tuteur updatedEleve = eleveService.updateEleve(id, eleve);

		
        if (updatedEleve!= null) {
            return new ResponseEntity<>(updatedEleve, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    
  
    
    @DeleteMapping("/deleteEleve/{id}")
    public ResponseEntity<Void> deleteEleve(@PathVariable("id") Long id) {
    	eleveService.deleteEleve(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getEleveByID/{id}")
    public ResponseEntity<Eleve> getEleveById(@PathVariable("id") Long id) {
        Optional<Eleve> eleve = eleveService.getEleveById(id);
        return eleve.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
