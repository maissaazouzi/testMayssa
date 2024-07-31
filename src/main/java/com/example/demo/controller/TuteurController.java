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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Eleve;
import com.example.demo.entities.Tuteur;
import com.example.demo.services.TuteurService;

@RestController("/api/v1/tuteurs")
public class TuteurController {
	@Autowired
    private TuteurService  tuteurService;

	
	@GetMapping("/touslestuteurs")
    public ResponseEntity<List<Tuteur>> getAllInscriptions() {
        List<Tuteur> tuteurs = tuteurService.getAllTuteurs();
        return new ResponseEntity<>(tuteurs, HttpStatus.OK);
    }
	@PostMapping("ajouterTuteur")
	public  ResponseEntity<Tuteur> createTuteur(@RequestBody Tuteur tuteur) {
		Tuteur createdTuteur = tuteurService.ajouterTuteur(tuteur);
        return new ResponseEntity<>(createdTuteur, HttpStatus.CREATED);
    }
	@PutMapping("/modifierTuteur/{id}")
    public ResponseEntity<Tuteur> updateTuteur(@PathVariable("id") Long id,
                                                                 @RequestBody Tuteur tuteur ) {
       Tuteur updatedTuteur = tuteurService.updateTuteur(tuteur, id);

		
        if (updatedTuteur != null) {
            return new ResponseEntity<>(updatedTuteur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
  
    
    @DeleteMapping("/deleteTuteur/{id}")
    public ResponseEntity<Void> deleteTuteur(@PathVariable("id") Long id) {
    	tuteurService.deleteTuteur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getTuteurByID/{id}")
    public ResponseEntity<Tuteur> getTuteurById(@PathVariable("id") Long id) {
        Optional<Tuteur> tuteur = tuteurService.getEleveById(id);
        return tuteur.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
