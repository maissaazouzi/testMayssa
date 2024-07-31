package com.example.demo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="eleve")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Eleve {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nom;
	
	private String prenom;
	@Column
    @JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	
	@OneToOne 
	private Inscription inscription;
	

}
