package rbs.commerce.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import rbs.commerce.entities.Categorie;
import rbs.commerce.repositories.CategorieRepositorie;
import rbs.commerce.service.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	public CategorieRepositorie categorieReposirtory ;
	
	@Override
	public List<Categorie> ListerCategorie() {
		return categorieReposirtory.findAll();
	}

	@Override
	public Categorie trouverCategorie(Long id) {
		return categorieReposirtory.findOne(id);
	}
	 @Transactional
	@Override
	public Categorie ajouterCategorie(Categorie c) {
		return categorieReposirtory.save(c);
	}
	 @Transactional
	@Override
	public Categorie modifierCategorie(Long idCategorie, Categorie categorie) {
		categorie.setIdCategorie(idCategorie);
		return categorieReposirtory.save(categorie);
	}
	
	 @Transactional
	@Override
	public void deletecCategorie(Long id) {
		  try {
			  categorieReposirtory.delete(id);
	        } catch (EmptyResultDataAccessException e) {
	            System.out.println("erreur delete employée");
	        }
		
	}
}
