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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rbs.commerce.dto.CategorieDto;
import rbs.commerce.entities.Categorie;
import rbs.commerce.service.CategorieService;
@CrossOrigin("*")
@RestController
public class CategorieController {


	@Autowired
	private CategorieService categorieService ;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/categorie")
	public Object CategoriesList() {
		List<Categorie> Categories = categorieService.ListerCategorie();
		Type listType = new TypeToken<List<CategorieDto>>(){}.getType();
		List<CategorieDto> CategorieDtos = modelMapper.map(Categories, listType);
		return ResponseEntity.status(HttpStatus.OK).body(CategorieDtos);
	}

	@GetMapping("/categorie/{id}")
	public Object retrieveCategorie(@PathVariable long id) {
		Categorie categorie = categorieService.trouverCategorie(id);
		CategorieDto CategorieDto = modelMapper.map( categorie,  CategorieDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(CategorieDto);
	}

	@PostMapping("/categorie")
	public Object addCategorie(@Valid @RequestBody CategorieDto CategorieDto) {
		Categorie categorie = modelMapper.map(CategorieDto, Categorie.class);
		categorie = categorieService.ajouterCategorie(categorie);
		CategorieDto = modelMapper.map(categorie, CategorieDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(CategorieDto);
	}
	
	@PutMapping("/categorie/{idCategorie}")
	public Object modifCategorie(@Valid @RequestBody CategorieDto CategorieDto, @PathVariable Long idCategorie) {
		Categorie categorie = modelMapper.map(CategorieDto, Categorie.class);
		categorie = categorieService.modifierCategorie(idCategorie, categorie);
		CategorieDto = modelMapper.map(categorie, CategorieDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(CategorieDto);
	}	
	@DeleteMapping("/categorie/{idCategorie}")
	public Object DeleteCategorie(@PathVariable("idCategorie") Long idCategorie) {
		categorieService.deletecCategorie(idCategorie);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}

