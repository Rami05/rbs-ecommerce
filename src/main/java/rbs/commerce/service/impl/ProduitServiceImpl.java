package rbs.commerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import rbs.commerce.entities.Produit;
import rbs.commerce.entities.SousCategorie;
import rbs.commerce.repositories.ProduitRepository;
import rbs.commerce.service.ProduitService;
import rbs.commerce.service.SousCategorieService;

@Service
public class ProduitServiceImpl implements ProduitService  {

	
	@Autowired
	private ProduitRepository produitRepository ;
	
	@Autowired
	private SousCategorieService sousCategorieService ;

	@Override
	public List<Produit> listerLesProduit(Long idSousCategorie) {
		SousCategorie sousCategorie = sousCategorieService.trouverSousCategorie(idSousCategorie);
 		return produitRepository.findBySousCategorie(sousCategorie);
	}

	@Override
	public Produit touverProduit(Long idProduit) {
		return produitRepository.findOne(idProduit);
	}

	@Override
	public Produit ajouterProduit(Long idSousCategorie ,Produit produit) {
		SousCategorie sousCategorie = sousCategorieService.trouverSousCategorie(idSousCategorie);
		produit.setSousCategorie(sousCategorie);
		return produitRepository.save(produit);
	}
}
