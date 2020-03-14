package rbs.commerce.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "PRODUIT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produit implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -244962720178917799L;

	@Id
	@GeneratedValue
	@Column(name = "ID_PRODUIT" )
	private Long idProduit;

	@Column(name = "DESIGNATION" )
	private String designation;
	
	@Column(name = "PRIX" )
	private Double prix;
	
	@Column(name = "QUANTITE" )
	private Integer quantite;
	
	@ManyToOne
	@JoinColumn(name="ID_Sous_Categorie")
	private SousCategorie sousCategorie ;

}
