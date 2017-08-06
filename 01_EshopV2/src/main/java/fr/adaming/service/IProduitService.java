package fr.adaming.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import fr.adaming.entite.Categorie;
import fr.adaming.entite.Produit;

public interface IProduitService extends IGeneriqueService<Produit> {
	public Produit ajouter(Produit produit);
	public Collection<Produit> obtenirTous();
	public void modifier(Produit produit);
	public void supprimer(Produit produit);
	public Produit obtenirUn(int id);
		
	public List<Produit> obtenirTousProduitsParCategorie(Categorie t);
	public Map<Produit,Categorie> obtenirCategorieDuProduit();
	 
	public void ajouterProduitParCatégorie (Produit p, Categorie c);
}
