package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tuteur")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tuteur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	@OneToMany
	private Set<Eleve> eleves= new HashSet<>() ;


}
