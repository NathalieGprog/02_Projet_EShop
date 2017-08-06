package fr.adaming.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import fr.adaming.entite.Categorie;
import fr.adaming.entite.Produit;

public interface ICategorieService extends IGeneriqueService<Categorie> {
	public Categorie ajouter(Categorie t);

	public Collection<Categorie> obtenirTous();

	public void modifier(Categorie t);

	public void supprimer(Categorie t);

	public Categorie obtenirUn(int id);

	public Map<String, Categorie> MapCategoriesParNom();
}
