package rbs.commerce.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)

public class SousCategorieDto {

	private Long idSousCategorie;

	private String designation;
	
	private List<ProduitDto> produit ;

	// private CategorieDto categorie ;
	
}
