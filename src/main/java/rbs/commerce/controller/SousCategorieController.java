package rbs.commerce.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rbs.commerce.dto.SousCategorieDto;
import rbs.commerce.entities.Categorie;
import rbs.commerce.entities.SousCategorie;
import rbs.commerce.service.CategorieService;
import rbs.commerce.service.SousCategorieService;

@CrossOrigin("*")
@RestController
public class SousCategorieController {

	@Autowired
	private SousCategorieService sousCategorieService ;
	
	@Autowired
	private CategorieService categorieService ;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	   @PostMapping("/categorie/{idCategorie}/sousCategories")
	   public Object addSousCategorieCategorie(@PathVariable("idCategorie") Long idCategorie, @Valid @RequestBody SousCategorieDto sousCategorieDto) {
	        Categorie categorie = categorieService.trouverCategorie(idCategorie);
	        SousCategorie sousCategorie = modelMapper.map(sousCategorieDto, SousCategorie.class);
	        sousCategorie = sousCategorieService.ajouterCategorie(categorie, sousCategorie);
	        sousCategorieDto = modelMapper.map(sousCategorie, SousCategorieDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(sousCategorieDto);
	    }
	
	 @GetMapping("/categorie/{idCategorie}/sousCategories")
	   public Object SousCategoriesCategorieList(@PathVariable("idCategorie") Long idCategorie) {
	        List<SousCategorie> sousCategories = sousCategorieService.listerSousCategorie(idCategorie);
	        Type listType = new TypeToken<List<SousCategorieDto>>() {
	        }.getType();
	        List<SousCategorieDto> SousCategorieDtos = modelMapper.map(sousCategories, listType);
	        return ResponseEntity.status(HttpStatus.OK).body(SousCategorieDtos);
	    }
	   
	 @GetMapping("/sousCategories/{idSousCategorie}")
	   public Object gertSousCategorie(@PathVariable("idSousCategorie") Long idC) {
	        SousCategorie sousCategories = sousCategorieService.trouverSousCategorie(idC);
	        SousCategorieDto SousCategorieDtos = modelMapper.map(sousCategories, SousCategorieDto.class);
	        return ResponseEntity.status(HttpStatus.OK).body(SousCategorieDtos);
	    }
//	 
//		@PutMapping("/categorie/{idCategorie}/sousCategories/{id}")
//	   public Object updateSousCategorieCategorie(@Valid @RequestBody SousCategorieDto sousCategorieDto, @PathVariable("id") Long id, @PathVariable("idCategorie") Long idCategorie) {
//     Categorie Categorie = categorieService.getCategorie(idCategorie);
//     SousCategorie sousCategorie = modelMapper.map(sousCategorieDto, SousCategorie.class);
//     sousCategorie = sousCategorieService.updateSousCategorieCategorie(id, sousCategorie, Categorie);
//     sousCategorieDto = modelMapper.map(sousCategorie, SousCategorieDto.class);
//     return ResponseEntity.status(HttpStatus.CREATED).body(sousCategorieDto);
// }
//	
//	
//	@DeleteMapping("/sousCategories/{id}")
//	public Object Delete(@PathVariable("id") Long id) {
//		sousCategorieService.deleteSousCategorie(id);
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//	}


}
