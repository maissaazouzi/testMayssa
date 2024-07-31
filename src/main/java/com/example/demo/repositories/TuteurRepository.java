package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Tuteur;

public interface TuteurRepository extends JpaRepository<Tuteur,Long> {
	boolean existsByEmail(String email);

}
