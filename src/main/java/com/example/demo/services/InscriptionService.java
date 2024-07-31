package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Eleve;
import com.example.demo.entities.Inscription;
import com.example.demo.repositories.InscriptionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InscriptionService {
	 private  final InscriptionRepository inscriptionRepository;

	 //afficher les inscriptions 
	 
	 public List<Inscription> getAllInscriptions() {
	        return inscriptionRepository.findAll();
	    }
	 
	 //ajouter inscription
	 public Inscription createInscription(Inscription inscription) {
	       if(inscription.getNomClasse() ==null || inscription.getNomClasse().isEmpty()
	    		   
	    		   
	    		   ) {
	 
	       
}
	       return inscriptionRepository.save(inscription);
	 }	
	 
	//suppression d'une inscription
	    public void deleteInscription(Long id) {
	        Inscription inscription = inscriptionRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("inscription introuvable avec l'ID : " + id));
	        
	        inscriptionRepository.delete(inscription);
	    }
	  //modification d'une inscription
	    public Inscription updateInscription(Long id,Inscription newInscription) {
	        Inscription existingInscription = inscriptionRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException(" inscription introuvable avec l'ID : " + id));

	        // Vérifier les champs existants et les mettre à jour
	        if (newInscription.getNomClasse() != null) {
	        	existingInscription.setNomClasse(newInscription.getNomClasse());}
	        	
	        	return inscriptionRepository.save(newInscription);
	        }

	    //get by  eleve  by id 
	    public Optional<Inscription> getInscriptionById(Long id) {
	        return inscriptionRepository.findById(id);
	    }
}
