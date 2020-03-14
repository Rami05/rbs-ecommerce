package rbs.commerce.service;

import java.util.List;

import rbs.commerce.entities.Categorie;

public interface CategorieService {
	
	List<Categorie> ListerCategorie () ;
	
	Categorie trouverCategorie(Long id);
	
	Categorie ajouterCategorie (Categorie c);

	Categorie modifierCategorie(Long idCategorie, Categorie c);

	void deletecCategorie(Long id);
	

}
