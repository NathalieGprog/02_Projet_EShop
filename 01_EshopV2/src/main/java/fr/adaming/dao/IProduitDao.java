package fr.adaming.dao;

import java.util.List;
import java.util.Map;

import fr.adaming.entite.Categorie;
import fr.adaming.entite.Produit;

public interface IProduitDao extends IGeneriqueDao<Produit> {

	public Produit ajouter(Produit produit);

	public List<Produit> obtenirTous();

	public void modifier(Produit produit);

	public void supprimer(Produit produit);

	public Produit obtenirUn(int id);
	
	/**
	 * Méthode permettant de récupérer une Map de produit et de la catégorie qui lui est assigné
	 * @return La Map ayant pour clé un produit et comme valeur la catégorie
	 */
	public Map<Produit, Categorie> obtenirCategorieDuProduit();

	/**
	 * Méthode retournant la clé étrangère d'un objet en base de donnée
	 * @param id de l'objet possédant une clé étrangère en base de donnée
	 * @return retourné la clé étrangère de l'objet sélectionné
	 */
	public int obtenirCleEtrangere(int id);

	/**
	 * Methode permettant d'aller chercher en base de données une liste d'objet produit
	 * @return la liste d'objet produit
	 */
	public List<Produit> obtenirProduitParCategorie();
}
