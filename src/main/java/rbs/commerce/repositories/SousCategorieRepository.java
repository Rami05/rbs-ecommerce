package rbs.commerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rbs.commerce.entities.Categorie;
import rbs.commerce.entities.SousCategorie;

public interface SousCategorieRepository extends JpaRepository<SousCategorie, Long> {
List<SousCategorie> findByCategorie(Categorie categorie );
}
