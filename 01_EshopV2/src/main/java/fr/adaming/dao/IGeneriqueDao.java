package fr.adaming.dao;

import java.util.Collection;

/**
 * Interface générique pour le DAO, permet de réaliser les fonctions de base du CRUD
 * @author INTI2017FORMATION
 *
 * @param <T> T est l'objet à manipuler dans la DAO
 */
public interface IGeneriqueDao<T> {
	
	/**
	 * Permet l'ajout d'un Objet T dans la base de données
	 * @param t Ce paramètre est à rentrer dans la base de données
	 * @return retourne l'objet avec la clé qui lui a été assigné par Hibernate
	 */
	public T ajouter(T t);
	
	/**
	 * Méthode retournant la liste des objets T présent en base de données
	 * @return Liste Object T : objet présent en base de données
	 */
	public Collection<T> obtenirTous();

	/**
	 * Méthode permettant de modifier l'objet T en base de données
	 * @param t Objet T qui doit être modifié
	 */
	public void modifier(T t);
	
	/**
	 * Méthode permettant de supprimer un objet T en base de données
	 * @param t Objet T à supprimer de la base de données
	 */
	public void supprimer(T t);
	
	/**
	 * Methode permettant de récupérer un objet T en base de données.
	 * @param id de l'objet à récupérer
	 * @return l'objet récupérer en base de données
	 */
	public T obtenirUn(int id);

}
