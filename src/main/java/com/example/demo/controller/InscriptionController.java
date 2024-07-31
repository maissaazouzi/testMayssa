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
import com.example.demo.entities.Inscription;
import com.example.demo.entities.Tuteur;
import com.example.demo.services.InscriptionService;

@RestController("/api/v1/inscriptions")
public class InscriptionController {
	@Autowired
    private InscriptionService  inscriptionService;

	
	@GetMapping("/touslesInscriptions")
    public ResponseEntity<List<Inscription>> getAllInscriptions() {
        List<Inscription> inscriptions = inscriptionService.getAllInscriptions();
        return new ResponseEntity<>(inscriptions, HttpStatus.OK);
    }
	
	@PostMapping("ajouterInscription")
	public  ResponseEntity<Inscription> createInscription(@RequestBody Inscription inscription) {
		Inscription createdInscription = inscriptionService.createInscription(inscription);
        return new ResponseEntity<>(createdInscription, HttpStatus.CREATED);
    }
	/*@PutMapping("/modifier/{id}")
    public ResponseEntity<Inscription> updateInscription(@PathVariable("id") Long id,
                                                                 @RequestBody Inscription inscription ) {
       Tuteur updatedInscription = inscriptionService.updateInscription(inscription, id);

		
        if (updatedInscription != null) {
            return new ResponseEntity<>(updatedInscription, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    
  
    
    @DeleteMapping("/deleteInscription/{id}")
    public ResponseEntity<Void> deleteInscription(@PathVariable("id") Long id) {
    	inscriptionService.deleteInscription(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getInscriptionByID/{id}")
    public ResponseEntity<Inscription> getInscriptioneById(@PathVariable("id") Long id) {
        Optional<Inscription> inscription = inscriptionService.getInscriptionById(id);
        return inscription.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
