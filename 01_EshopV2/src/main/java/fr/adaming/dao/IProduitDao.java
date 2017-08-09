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
	 * M�thode permettant de r�cup�rer une Map de produit et de la cat�gorie qui lui est assign�
	 * @return La Map ayant pour cl� un produit et comme valeur la cat�gorie
	 */
	public Map<Produit, Categorie> obtenirCategorieDuProduit();

	/**
	 * M�thode retournant la cl� �trang�re d'un objet en base de donn�e
	 * @param id de l'objet poss�dant une cl� �trang�re en base de donn�e
	 * @return retourn� la cl� �trang�re de l'objet s�lectionn�
	 */
	public int obtenirCleEtrangere(int id);

	/**
	 * Methode permettant d'aller chercher en base de donn�es une liste d'objet produit
	 * @return la liste d'objet produit
	 */
	public List<Produit> obtenirProduitParCategorie();
}
