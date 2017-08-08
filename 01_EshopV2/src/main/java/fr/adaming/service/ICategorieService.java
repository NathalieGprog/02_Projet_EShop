package fr.adaming.service;

import java.util.Collection;
import java.util.Map;

import fr.adaming.entite.Categorie;

public interface ICategorieService extends IGeneriqueService<Categorie> {
	public Categorie ajouter(Categorie t);

	public Collection<Categorie> obtenirTous();

	public void modifier(Categorie t);

	public void supprimer(Categorie t);

	public Categorie obtenirUn(int id);

	public Map<String, Categorie> MapCategoriesParNom();
}
