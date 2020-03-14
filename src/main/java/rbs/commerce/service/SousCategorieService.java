package rbs.commerce.service;

import java.util.List;

import rbs.commerce.entities.Categorie;
import rbs.commerce.entities.SousCategorie;

public interface SousCategorieService {
	
	List<SousCategorie> listerSousCategorie (Long idCategorie) ;
	
	SousCategorie trouverSousCategorie(Long idSousCategorie);
	
	SousCategorie ajouterCategorie (Categorie categorie , SousCategorie sousCategorie);

	SousCategorie updateSousCategorie(Long idSousCat, SousCategorie sousCategorie, Categorie categorie);
	
	
	
}
