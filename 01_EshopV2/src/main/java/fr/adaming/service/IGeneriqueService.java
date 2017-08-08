package fr.adaming.service;

import java.util.Collection;

/**
 * Interface générique de la couche service
 * @author INTI2017FORMATION
 *
 * @param <T> objet générique à toutes les interfaces qui étende de celle-ci
 */
public interface IGeneriqueService<T> {
	
	/**
	 * Méthode ajouter de la couche service
	 * @param t objet à ajouter
	 * @return retourne l'objet ajouté avec son identifiant en base de données
	 */
	public T ajouter(T t);

	/**
	 * Méthode obtenir tous de la couche service
	 * @return la Liste des objets de la bd
	 */
	public Collection<T> obtenirTous();

	/**
	 * méthode modifier de la couche service
	 * @param t objet à modifier
	 */
	public void modifier(T t);

	/**
	 * méthode supprimer de la couche service
	 * @param t objet à supprimer
	 */
	public void supprimer(T t);

	/**
	 * méthode obtenir un objet avec l'id de la couche service
	 * @param id de l'objet à récupérer
	 * @return l'objet issu de la base de données
	 */
	public T obtenirUn(int id);

}
