package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Eleve;
import com.example.demo.repositories.EleveRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EleveService {
	
	
	 private  final EleveRepository eleveRepository;
	 
	 //afficher les eleves 
	 
	 public List<Eleve> getAllEleves() {
	        return eleveRepository.findAll();
	    }
	 
	 //ajouter un eleve 
	 public Eleve createEleve(Eleve eleve) {
	       if(eleve.getNom() ==null || eleve.getNom().isEmpty()||
	    		   eleve.getPrenom()==null||eleve.getNom().isEmpty()||
	    		   eleve.getDateNaissance()==null
	    		   ) {
	 
	       
}
	       return eleveRepository.save(eleve);
	 }
	//suppression d'un eleve
	    public void deleteEleve(Long id) {
	        Eleve eleve = eleveRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("eleve introuvable avec l'ID : " + id));
	        
	        eleveRepository.delete(eleve);
	    }
	    
	    
	    //modification  eleve
	    public Eleve updateEleve(Long id,Eleve newEleve) {
	        Eleve existingEleve = eleveRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException(" eleve introuvable avec l'ID : " + id));

	        // Vérifier les champs existants et les mettre à jour
	        if (newEleve.getNom() != null) {
	        	existingEleve.setNom(newEleve.getNom());}
	        	if (newEleve.getPrenom() !=null) {
	        		
	        		existingEleve.setPrenom(newEleve.getPrenom());
	        	}
	        	if(newEleve.getDateNaissance()!= null) {
	        		existingEleve.setDateNaissance(newEleve.getDateNaissance());	
	        	}
	        	return eleveRepository.save(newEleve);
	        }
	    //get by  eleve  by id 
	    public Optional<Eleve> getEleveById(Long id) {
	        return eleveRepository.findById(id);
	    }
 
}
