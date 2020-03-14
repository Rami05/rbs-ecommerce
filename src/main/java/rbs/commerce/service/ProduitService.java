package rbs.commerce.service;

import java.util.List;

import rbs.commerce.entities.Produit;

public interface ProduitService {
   List<Produit> listerLesProduit(Long idSousCategorie);
   Produit touverProduit(Long idProduit);
   Produit ajouterProduit(Long idSousCategorie ,Produit produit);
}
