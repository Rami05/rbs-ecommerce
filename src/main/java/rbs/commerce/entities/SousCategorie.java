package rbs.commerce.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "SOUS_CATEGORIE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SousCategorie implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8734562586897530212L;

	@Id
	@GeneratedValue
	@Column(name = "ID_PRODUIT" )
	private Long idSousCategorie;

	@Column(name = "DESIGNATION" )
	private String designation;
	
	
	@ManyToOne
	@JoinColumn(name="ID_Categorie")
	private Categorie categorie ;

	@OneToMany(mappedBy="sousCategorie")
	private List<Produit> produit ;	
}
