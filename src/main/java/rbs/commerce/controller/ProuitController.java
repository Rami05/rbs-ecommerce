package rbs.commerce.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rbs.commerce.dto.ProduitDto;
import rbs.commerce.entities.Produit;
import rbs.commerce.service.ProduitService;

@RestController
public class ProuitController {
	@Autowired
	private ProduitService produitService ;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("sousCategorie/{idSousCategorie}/produit")
	public Object ProduitsList(@PathVariable Long idSousCategorie) {
		
		List<Produit> Produits = produitService.listerLesProduit(idSousCategorie);
		Type listType = new TypeToken<List<ProduitDto>>(){}.getType();
		List<ProduitDto> ProduitDtos = modelMapper.map(Produits, listType);
		return ResponseEntity.status(HttpStatus.OK).body(ProduitDtos);
	}

	@GetMapping("/produit/{id}")
	public Object retrieveProduit(@PathVariable Long id) {
		Produit produit = produitService.touverProduit(id);
		ProduitDto ProduitDto = modelMapper.map( produit,  ProduitDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(ProduitDto);
	}

	@PostMapping("sousCategorie/{idSousCategorie}/produit")
	public Object addProduit(@Valid @RequestBody ProduitDto ProduitDto,@PathVariable Long idSousCategorie) {
		Produit produit = modelMapper.map(ProduitDto, Produit.class);
		produit = produitService.ajouterProduit(idSousCategorie , produit);
		ProduitDto = modelMapper.map(produit, ProduitDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(ProduitDto);
	}
	
}
