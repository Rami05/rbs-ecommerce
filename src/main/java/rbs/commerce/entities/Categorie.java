package rbs.commerce.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CATEGORIE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8140895482202665163L;

	@Id
	@GeneratedValue
	@Column(name = "ID_Categorie" )
	private Long idCategorie;

	@Column(name = "DESIGNATION" )
	private String designation;
	
	@Column(name = "sexe" )
	private String sexe;
	
//	@OneToMany(mappedBy="categorie")
//	private List<Produit> produit ;
	
	@OneToMany(mappedBy="categorie")
	private List<SousCategorie> sousCategorie ;
}
