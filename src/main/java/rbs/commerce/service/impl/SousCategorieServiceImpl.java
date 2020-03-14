package rbs.commerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import rbs.commerce.entities.Categorie;
import rbs.commerce.entities.SousCategorie;
import rbs.commerce.repositories.SousCategorieRepository;
import rbs.commerce.service.CategorieService;
import rbs.commerce.service.SousCategorieService;
@Service
public class SousCategorieServiceImpl implements SousCategorieService {
	  
	   @Autowired
	    private CategorieService categorieService ;
	   
	   @Autowired
	    private SousCategorieRepository sousCategorieRepository ;
	   
	@Override
	public List<SousCategorie> listerSousCategorie(Long idCategorie) {
    Categorie cat = categorieService.trouverCategorie(idCategorie)	;
    return sousCategorieRepository.findByCategorie(cat);
	}

	@Override
	public SousCategorie trouverSousCategorie(Long idSousCategorie) {
		return sousCategorieRepository.getOne(idSousCategorie);
	}
	@Transactional
	@Override
	public SousCategorie ajouterCategorie(Categorie categorie, SousCategorie sousCategorie) {
		sousCategorie.setCategorie(categorie);	
		return sousCategorieRepository.save(sousCategorie);
	}
	
	 @Transactional
		@Override
		public SousCategorie updateSousCategorie(Long idSousCat, SousCategorie sousCategorie, Categorie categorie) {
			  
	      	 sousCategorie.setIdSousCategorie(idSousCat);
		        return ajouterCategorie( categorie, sousCategorie);
		    }

}
