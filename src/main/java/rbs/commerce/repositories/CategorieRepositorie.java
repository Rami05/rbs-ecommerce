package rbs.commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rbs.commerce.entities.Categorie;

@Repository
public interface CategorieRepositorie extends JpaRepository<Categorie, Long>{

}
