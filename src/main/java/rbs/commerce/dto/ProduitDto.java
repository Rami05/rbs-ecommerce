package rbs.commerce.dto;

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
public class ProduitDto {
	private Long idProduit;

	private String designation;
	
	private Double prix;
	
	private Integer quantite;

	// private CategorieDto categorie ;
}
