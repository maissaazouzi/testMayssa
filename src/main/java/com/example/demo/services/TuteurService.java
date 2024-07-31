package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Eleve;
import com.example.demo.entities.Inscription;
import com.example.demo.entities.Tuteur;
import com.example.demo.repositories.TuteurRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TuteurService {
	 private  final TuteurRepository tuteurRepository;
 //afficher les tuteurs 
	 
	 public List<Tuteur> getAllTuteurs() {
	        return tuteurRepository.findAll();
	    }
	 //ajouter tuteur 
    public Tuteur ajouterTuteur(Tuteur tuteur) {
        // Vérification de la structure de l'e-mail
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(tuteur.getEmail());

        if (!matcher.matches()) {
            throw new IllegalArgumentException("L'e-mail fourni n'a pas un format valide.");
        }

        // Vérification si l'e-mail est vide
        if (tuteur.getEmail() == null || tuteur.getEmail().isEmpty()) {
            throw new IllegalArgumentException("L'e-mail ne peut pas être vide.");
        }

      
        
if(tuteur.getNom()==null || tuteur.getNom().isEmpty()) {
	 throw new IllegalArgumentException("le nom  ne peut pas être vide.");

	
}
if(tuteur.getPrenom()==null || tuteur.getPrenom().isEmpty()) {
	 throw new IllegalArgumentException("le prenom  ne peut pas être vide.");

	
}

        // Vérification par email
        if (tuteurRepository.existsByEmail(tuteur.getEmail())) {
            throw new IllegalArgumentException("Un tuteur avec cet email existe déjà.");
        }

       

        return tuteurRepository.save(tuteur);
    }
  //modification d'un tuteur 
    public Tuteur updateTuteur(Tuteur newTuteur,Long id) {
    	Tuteur existingTuteur = tuteurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(" tuteur introuvable avec l'ID : " + id));

        // Vérifier les champs existants et les mettre à jour
        if (newTuteur.getNom() != null) {
        	existingTuteur.setNom(newTuteur.getNom());}
        	if (newTuteur.getPrenom() !=null) {
        		
        		existingTuteur.setPrenom(newTuteur.getPrenom());
        	}
        	if(newTuteur.getEmail()!=null ) {
        		existingTuteur.setEmail(newTuteur.getEmail());
        	}
        	return tuteurRepository.save(newTuteur);
        }

    //suppression d'un tuteur
    public void deleteTuteur(Long id) {
        Tuteur tuteur = tuteurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tuteur introuvable avec l'ID : " + id));
        
        tuteurRepository.delete(tuteur);
    }
  //get by  eleve  by id 
    public Optional<Tuteur> getEleveById(Long id) {
        return tuteurRepository.findById(id);
    }
   
}


