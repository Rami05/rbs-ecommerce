package rbs.commerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rbs.commerce.entities.Produit;
import rbs.commerce.entities.SousCategorie;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
List<Produit> findBySousCategorie(SousCategorie sousCat);
}
